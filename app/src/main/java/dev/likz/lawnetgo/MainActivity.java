package dev.likz.lawnetgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import dev.likz.lawnetgo.fragments.RecommendedFragment;
import dev.likz.lawnetgo.helpers.SnackBarHelper;
import dev.likz.lawnetgo.entities.User;
import dev.likz.lawnetgo.fragments.FavouritesFragment;
import dev.likz.lawnetgo.fragments.LoginFragment;
import dev.likz.lawnetgo.fragments.RecentFragment;
import dev.likz.lawnetgo.fragments.SearchFragment;
import dev.likz.lawnetgo.helpers.JSONExtracter;
import dev.likz.lawnetgo.helpers.SearchDataHelper;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.arlib.floatingsearchview.util.Util;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
  public static User loggedInUser;

  /**
   * Constants
   **/
  public static final int FRAGMENT_LOGIN = 12387;
  public static final int FRAGMENT_FAVOURITES = R.id.navigation_favourites;
  public static final int FRAGMENT_RECENT = R.id.navigation_recent;
  public static final int FRAGMENT_RECOMMENDED = R.id.navigation_recommended;
  public static final int FRAGMENT_SEARCH = R.id.navigation_search;
  public static final int FRAGMENT_CONTENT = R.id.navigation_content;

  /**
   * Layouts
   **/
  private FrameLayout mainLayout;
  private BottomNavigationView navigation;
  private FloatingSearchView floatingSearchView;
  private FrameLayout searchBarBackground;

  /**
   * Helpers
   **/
  public SnackBarHelper snackBarHelper;

  /**
   * Local Variables
   **/
  private String searchQuery = "";
  public int currentFragment = FRAGMENT_LOGIN;
  private String previousBackStack = "";

  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
          = item -> {
    switch (item.getItemId()) {
      case FRAGMENT_FAVOURITES:
        redirectToFragment(new FavouritesFragment(), String.valueOf(FRAGMENT_RECENT));
        return true;
      case FRAGMENT_RECENT:
        redirectToFragment(new RecentFragment(), String.valueOf(FRAGMENT_RECENT));
        return true;
      case FRAGMENT_RECOMMENDED:
        redirectToFragment(new RecommendedFragment(), String.valueOf(FRAGMENT_RECOMMENDED));
        return true;
      case FRAGMENT_SEARCH:
        redirectToFragment(SearchFragment.newInstance(searchQuery), String.valueOf(FRAGMENT_SEARCH ));
//        redirectToFragment(ViewPagerFragment.newInstance(ViewPagerFragment.FAVOURITES_TYPE), String.valueOf(FRAGMENT_FAVOURITES));
        return true;

    }
    return false;
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Layouts
    mainLayout = findViewById(R.id.mainLayout);

    // Helpers
    snackBarHelper = new SnackBarHelper(mainLayout);

    initializeBottomNavigation();
    initializeSearchView();

    redirectToFragment(new LoginFragment(), String.valueOf(FRAGMENT_LOGIN));

    JSONExtracter extracter = new JSONExtracter();
    extracter.extractData(this);
  }

  public void redirectToFragment(Fragment fragment, String backStack) {
    toggleViews(backStack);

    FragmentManager fragmentManager = getSupportFragmentManager();

    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.contentLayout, fragment);

    if (!backStack.isEmpty()) {
      if (!previousBackStack.equals(backStack)) {
        previousBackStack = backStack;
        fragmentTransaction.addToBackStack(backStack);
      }
    }

    fragmentTransaction.commit();
  }

  private void toggleViews(String currentFragment) {
    if (currentFragment.equals(String.valueOf(FRAGMENT_LOGIN))) {
      navigation.setVisibility(View.GONE);
    } else {
      navigation.setVisibility(View.VISIBLE);
    }

    if (currentFragment.equals(String.valueOf(FRAGMENT_LOGIN)) || currentFragment.equals(String.valueOf(FRAGMENT_CONTENT))) {
      floatingSearchView.setVisibility(View.GONE);
      searchBarBackground.setVisibility(View.GONE);
    } else {
      floatingSearchView.setVisibility(View.VISIBLE);
      searchBarBackground.setVisibility(View.VISIBLE);
    }
  }

  private void initializeBottomNavigation() {
    navigation = findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
  }

  private void initializeSearchView() {
    searchBarBackground = findViewById(R.id.searchBarBackground);
    floatingSearchView = findViewById(R.id.floatingSearchView);

    floatingSearchView.setOnQueryChangeListener((oldQuery, newQuery) -> {
      String newline = System.getProperty("line.separator");

      if (!oldQuery.equals("") && newQuery.equals("")) {
        floatingSearchView.clearSuggestions();
      } else if (newQuery.contains(newline)) {
        String query = newQuery.replace(newline, "");
        if (query.isEmpty()) {
          snackBarHelper.showShortSnackBar(getResources().getString(R.string.search_empty_query));
        } else {
          new SearchDataHelper.SaveSearchHistory(getApplicationContext(), searchQuery).execute();
          startSearch(query);
        }
      } else {
        floatingSearchView.showProgress();
        floatingSearchView.swapSuggestions(SearchDataHelper.compareSuggestions(newQuery, SearchDataHelper.SEARCH_RESULT_COUNT));
        floatingSearchView.hideProgress();
      }
    });

    floatingSearchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
      @Override
      public void onSuggestionClicked(final SearchSuggestion searchSuggestion) {
        new SearchDataHelper.SaveSearchHistory(getApplicationContext(), searchSuggestion.getBody()).execute();
        startSearch(searchSuggestion.getBody());
      }

      @Override
      public void onSearchAction(String query) {
        if (query == null || query.isEmpty()) {
          snackBarHelper.showShortSnackBar(getResources().getString(R.string.search_empty_query));
        } else {
          new SearchDataHelper.SaveSearchHistory(getApplicationContext(), query).execute();
          startSearch(query);
        }
      }
    });

    floatingSearchView.setOnFocusChangeListener(new FloatingSearchView.OnFocusChangeListener() {
      @Override
      public void onFocus() {
        new SearchDataHelper.GetSearchHistory(getApplicationContext(), floatingSearchView, SearchDataHelper.SEARCH_RESULT_COUNT).execute();
      }

      @Override
      public void onFocusCleared() {
        //set the title of the bar so that when focus is returned a new query begins
        floatingSearchView.setSearchBarTitle(searchQuery);
      }
    });

    floatingSearchView.setOnBindSuggestionCallback((suggestionView, leftIcon, textView, item, itemPosition) -> {
      leftIcon.setImageResource(R.drawable.ic_history);
      Util.setIconColor(leftIcon, getResources().getColor(R.color.secondaryText));
      textView.setText(item.getBody());
      textView.setTextColor(getResources().getColor(R.color.secondaryText));
    });
  }

  public void startSearch(String query) {
    searchQuery = query;
    floatingSearchView.setSearchFocused(false);
    currentFragment = FRAGMENT_SEARCH;
    navigation.setSelectedItemId(R.id.navigation_search);
  }
}
