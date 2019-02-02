package dev.likz.lawnetgo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dev.likz.lawnetgo.adapter.BaseCasesAdapter;
import dev.likz.lawnetgo.databases.dao.RecentCasesDAO;
import dev.likz.lawnetgo.entities.Case;

public class RecommendedFragment extends CardViewLayout {
  public RecommendedFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);

    populateRecyclerView(new BaseCasesAdapter(getContext()));
    initializeFAB();

    retrieveFavouriteCases();

    return rootView;
  }

  public void retrieveFavouriteCases() {
    RecentCasesDAO dao = new RecentCasesDAO(getContext());
    List<Case> caseList = dao.getAllRecent();

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
