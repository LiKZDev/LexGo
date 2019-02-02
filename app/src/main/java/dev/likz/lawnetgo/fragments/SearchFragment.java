package dev.likz.lawnetgo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dev.likz.lawnetgo.adapter.BaseCasesAdapter;
import dev.likz.lawnetgo.databases.dao.FavouriteCaseDAO;
import dev.likz.lawnetgo.entities.Case;

public class SearchFragment extends CardViewLayout {
  private static final String QUERY = "query";

  private String query;

  public SearchFragment() {
  }

  public static SearchFragment newInstance(String query) {
    SearchFragment fragment = new SearchFragment();
    Bundle args = new Bundle();
    args.putString(QUERY, query);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      query = getArguments().getString(QUERY);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);

    populateRecyclerView(new BaseCasesAdapter(getContext()));
    initializeFAB();

    retrieveSearchCases();

    return rootView;
  }

  public void retrieveSearchCases() {
    FavouriteCaseDAO dao = new FavouriteCaseDAO(getContext());
    List<Case> caseList = dao.searchCases(query);

    showResultsLayout(caseList, rootView, adapter);
  }

  @Override
  public void initializeFAB() {

  }


  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override
  public void onDetach() {
    super.onDetach();
  }
}
