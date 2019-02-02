package dev.likz.lawnetgo.helpers;

import android.content.Context;
import android.os.AsyncTask;

import com.arlib.floatingsearchview.FloatingSearchView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import dev.likz.lawnetgo.databases.dao.SearchHistoryDAO;
import dev.likz.lawnetgo.entities.SearchSuggestion;

/**
 * Created by Li on 30/6/2017.
 */
public class SearchDataHelper {
  final public static int SEARCH_RESULT_COUNT = 3;

  private static ArrayList<SearchSuggestion> ssList = new ArrayList<>();

  public interface OnFindSuggestionsListener {
    void onResults(List<SearchSuggestion> results);
  }

  public static ArrayList<SearchSuggestion> compareSuggestions(String query, int count) {
    ArrayList<SearchSuggestion> resultsList = new ArrayList<>();
    int j = 0;
    for (int i = ssList.size() - 1; i >= 0; i--) {
      if (j < count) {
        if (ssList.get(i).getBody().toLowerCase().contains(query.toLowerCase())) {
          resultsList.add(ssList.get(i));
          j++;
        }
      } else {
        break;
      }
    }

    return resultsList;
  }

  public static class SaveSearchHistory extends AsyncTask<Void, Void, Boolean> {
    private WeakReference<Context> contextRef;
    private String name;


    public SaveSearchHistory(Context context, String name) {
      super();
      this.contextRef = new WeakReference<>(context);
      this.name = name;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
      SearchHistoryDAO dao = new SearchHistoryDAO(contextRef.get());
      return dao.createSearchRecord(new SearchSuggestion(name));
    }

    @Override
    protected void onPostExecute(Boolean success) {
    }
  }

  public static class GetSearchHistory extends AsyncTask<Void, Void, Boolean> {
    private WeakReference<Context> contextRef;
    private WeakReference<FloatingSearchView> floatingSearchViewRef;
    private int count;

    public GetSearchHistory(Context context, FloatingSearchView floatingSearchView, int count) {
      super();
      this.contextRef = new WeakReference<>(context);
      this.floatingSearchViewRef = new WeakReference<>(floatingSearchView);
      this.count = count;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
      if (ssList != null && ssList.size() > 0) {
        ssList.clear();
      }
      SearchHistoryDAO dao = new SearchHistoryDAO(contextRef.get());
      ssList = dao.getAllHistory();

      return ssList == null;
    }

    @Override
    protected void onPostExecute(Boolean success) {
      if (success) {
        FloatingSearchView floatingSearchView = floatingSearchViewRef.get();
        if (floatingSearchView != null) {
          if (ssList != null && ssList.size() > 0) {
            ArrayList<SearchSuggestion> swapList = new ArrayList<>();
            if (ssList.size() > count) {
              for (int i = ssList.size() - 1; i >= ssList.size() - count; i--) {
                swapList.add(ssList.get(i));
              }
              floatingSearchView.swapSuggestions(swapList);
            } else {
              floatingSearchView.swapSuggestions(ssList);
            }
          }
          floatingSearchView.hideProgress();
        }
      }
    }
  }
}
