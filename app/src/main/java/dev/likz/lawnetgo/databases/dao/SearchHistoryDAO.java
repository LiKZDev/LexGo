package dev.likz.lawnetgo.databases.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import dev.likz.lawnetgo.databases.tables.SearchHistoryTable;
import dev.likz.lawnetgo.entities.SearchSuggestion;

/**
 * Created by Li on 6/4/2015.
 */
public class SearchHistoryDAO extends DAOManager {
  private String[] ALL_COLUMNS = {
          SearchHistoryTable.COLUMN_ID,
          SearchHistoryTable.COLUMN_NAME,
          SearchHistoryTable.COLUMN_DESCRIPTION
  };

  public SearchHistoryDAO(Context context) {
    super(context);
  }

  public boolean createSearchRecord(SearchSuggestion ss) {
    openDatabase();

    if (database == null)
      return false;

    deleteHistoryRecord(ss.getSearchName());

    ContentValues values = new ContentValues();
    values.put(SearchHistoryTable.COLUMN_NAME, ss.getSearchName());
    values.put(SearchHistoryTable.COLUMN_DESCRIPTION, ss.getDescription());

    database.insert(SearchHistoryTable.TABLE_SEARCH_HISTORY, null,
            values);

    closeDatabase();

    return true;
  }

  private void deleteHistoryRecord(String name) {
    database.delete(SearchHistoryTable.TABLE_SEARCH_HISTORY, SearchHistoryTable.COLUMN_NAME
            + " = '" + name + "'", null);
  }

  public ArrayList<SearchSuggestion> getAllHistory() {
    openDatabase();

    if (database == null)
      return null;

    ArrayList<SearchSuggestion> searchHistory = new ArrayList<SearchSuggestion>();
    Cursor cursor = database.query(SearchHistoryTable.TABLE_SEARCH_HISTORY,
            ALL_COLUMNS, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      SearchSuggestion ss = cursorToNext(cursor);
      searchHistory.add(ss);
      cursor.moveToNext();
    }

    cursor.close();

    closeDatabase();

    return searchHistory;
  }

//  public ArrayList<SearchSuggestion> getHistoryByCount(int count) {
//    int i = 0;
//    ArrayList<SearchSuggestion> searchHistory = new ArrayList<SearchSuggestion>();
//    Cursor cursor = database.query(SearchHistoryTable.TABLE_SEARCH_HISTORY,
//            ALL_COLUMNS, null, null, null, null, null);
//
//    cursor.moveToFirst();
//    while (!cursor.isAfterLast() && i <= count) {
//      SearchSuggestion ss = cursorToNext(cursor);
//      searchHistory.add(ss);
//      cursor.moveToNext();
//      i++;
//    }
//    // make sure to close the cursor
//    cursor.close();
//    return searchHistory;
//  }

  @Override
  public SearchSuggestion cursorToNext(Cursor cursor) {
    SearchSuggestion ss = new SearchSuggestion();
    ss.setSearchName(cursor.getString(1));
    ss.setDescription(cursor.getString(2));

    return ss;
  }

}
