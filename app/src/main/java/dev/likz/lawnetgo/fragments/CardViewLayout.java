package dev.likz.lawnetgo.fragments;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import dev.likz.lawnetgo.R;
import dev.likz.lawnetgo.adapter.BaseAdapter;

public abstract class CardViewLayout extends Fragment {
  View rootView;
  private ProgressBar progressBar;
  private View errorLayout;
  private ObservableRecyclerView recyclerView;
  FloatingActionButton floatingActionButton;

  BaseAdapter adapter;
  private LinearLayoutManager llm;

  public CardViewLayout() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    rootView = inflater.inflate(R.layout.layout_cardview, container, false);

    progressBar = rootView.findViewById(R.id.progressBar);
    errorLayout = rootView.findViewById(R.id.errorLayout);
    recyclerView = rootView.findViewById(R.id.scroll);
//    floatingActionButton = rootView.findViewById(R.id.floatingActionButton);
//    floatingActionButton.setVisibility(View.VISIBLE);

    return rootView;
  }

  public abstract void initializeFAB();

  void populateRecyclerView(BaseAdapter adapter) {
    this.adapter = adapter;

    llm = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(llm);
    recyclerView.setHasFixedSize(false);
//    recyclerView.setTouchInterceptionViewGroup(getParentFragment().getView().findViewById(R.id.root));
    recyclerView.setScrollViewCallbacks((ObservableScrollViewCallbacks) getParentFragment());

    recyclerView.setAdapter(adapter);

    showLoadingLayout();
  }

  private void showLoadingLayout() {
    progressBar.setVisibility(View.VISIBLE);
    recyclerView.setVisibility(View.GONE);
    errorLayout.setVisibility(View.GONE);
  }

  static void showResultsLayout(List list, View rootView, BaseAdapter adapter) {
    rootView.findViewById(R.id.scroll).setVisibility(View.VISIBLE);
    rootView.findViewById(R.id.progressBar).setVisibility(View.GONE);
    rootView.findViewById(R.id.errorLayout).setVisibility(View.GONE);

    adapter.updateAdapter(list);
  }

  static void showErrorLayout(View rootView) {
    rootView.findViewById(R.id.errorLayout).setVisibility(View.VISIBLE);
    rootView.findViewById(R.id.scroll).setVisibility(View.GONE);
    rootView.findViewById(R.id.progressBar).setVisibility(View.GONE);
  }

  void showFloatingActionButton() {
    float headerTranslationY = floatingActionButton.getTranslationY();

    if (headerTranslationY != 0) {
      ObjectAnimator animation = ObjectAnimator.ofFloat(floatingActionButton, "translationY", 0);
      animation.setDuration(200);
      animation.start();
    }
  }

  void hideFloatingActionButton() {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) floatingActionButton.getLayoutParams();
    float headerTranslationY = floatingActionButton.getTranslationY();

    int fabHeight = floatingActionButton.getHeight();
    int fab_bottomMargin = layoutParams.bottomMargin;

    if (headerTranslationY != -fabHeight) {
      ObjectAnimator animation = ObjectAnimator.ofFloat(floatingActionButton, "translationY", fabHeight + fab_bottomMargin);
      animation.setDuration(200);
      animation.start();
    }
  }
}
