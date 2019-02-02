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

public class FavouritesFragment extends CardViewLayout {
  public FavouritesFragment() {
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
    FavouriteCaseDAO dao = new FavouriteCaseDAO(getContext());
    List<Case> caseList = dao.getAllFavourites();

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
