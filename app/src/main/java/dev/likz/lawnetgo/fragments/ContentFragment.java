package dev.likz.lawnetgo.fragments;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.Fragment;
import dev.likz.lawnetgo.MainActivity;
import dev.likz.lawnetgo.R;
import dev.likz.lawnetgo.components.DialogHelper;
import dev.likz.lawnetgo.databases.dao.FavouriteCaseDAO;
import dev.likz.lawnetgo.databases.dao.RecentCasesDAO;
import dev.likz.lawnetgo.entities.Case;
import dev.likz.lawnetgo.entities.CaseContent;

public class ContentFragment extends Fragment {
  private static final String CASE_ID = "caseId";
  View rootView;

  TextView caseTitleTextView;
  TextView caseNumberTextView;
  TextView decisionDateTextView;
  TextView tribunalCourtTextView;
  TextView coramTextView;
  TextView counselNamesTextView;
  TextView partiesTextView;
  TextView caseReferringTextView;
  TextView caseFollowingTextView;
  MaterialButton collabButton;
  FloatingActionButton floatingActionButton;

  private Case caseInfo;

  public ContentFragment() {
    // Required empty public constructor
  }

  public static ContentFragment newInstance(int caseId) {
    ContentFragment fragment = new ContentFragment();
    Bundle args = new Bundle();
    args.putString(CASE_ID, String.valueOf(caseId));
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      FavouriteCaseDAO dao = new FavouriteCaseDAO(getContext());
      caseInfo = dao.retrieveRecordById(getArguments().getString(CASE_ID));

      RecentCasesDAO recentCasesDAO = new RecentCasesDAO(getContext());
      recentCasesDAO.createRecentRecord(caseInfo);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    rootView = inflater.inflate(R.layout.fragment_content, container, false);

    caseTitleTextView = rootView.findViewById(R.id.caseTitle);
    caseNumberTextView = rootView.findViewById(R.id.caseNumber);
    decisionDateTextView = rootView.findViewById(R.id.decisionDate);
    tribunalCourtTextView = rootView.findViewById(R.id.tribunalCourt);
    coramTextView = rootView.findViewById(R.id.coram);
    counselNamesTextView = rootView.findViewById(R.id.counselNames);
    partiesTextView = rootView.findViewById(R.id.parties);
    caseReferringTextView = rootView.findViewById(R.id.caseReferring);
    caseFollowingTextView = rootView.findViewById(R.id.caseFollowing);
    collabButton = rootView.findViewById(R.id.collabButton);
    floatingActionButton = rootView.findViewById(R.id.floating_action_button);

    collabButton.setOnClickListener(v -> {
      DialogHelper dialogHelper = new DialogHelper(getContext());
      dialogHelper.showCollabDialog(String.valueOf(caseInfo.getId()));
    });

    if (caseInfo.getFavourite() == 1) {
      ImageViewCompat.setImageTintList(
              floatingActionButton,
              ColorStateList.valueOf(getResources().getColor(R.color.colorAccentLight))
      );
    } else {
      ImageViewCompat.setImageTintList(
              floatingActionButton,
              ColorStateList.valueOf(getResources().getColor(R.color.iconWhite))
      );
    }

    floatingActionButton.setOnClickListener(v -> {
      FavouriteCaseDAO dao = new FavouriteCaseDAO(getContext());
      if (caseInfo.getFavourite() == 1) {
        caseInfo.setFavourite(0);
        ImageViewCompat.setImageTintList(
                floatingActionButton,
                ColorStateList.valueOf(getResources().getColor(R.color.iconWhite))
        );
        dao.toggleFavourite(caseInfo, 0);
        ((MainActivity) getContext()).snackBarHelper.showShortSnackBar("Removed from Favourites");
      } else {
        caseInfo.setFavourite(1);
        ImageViewCompat.setImageTintList(
                floatingActionButton,
                ColorStateList.valueOf(getResources().getColor(R.color.colorAccentLight))
        );
        dao.toggleFavourite(caseInfo, 1);
        ((MainActivity) getContext()).snackBarHelper.showShortSnackBar("Added to Favourites");

      }
    });

    populateLayout();

    return rootView;
  }

  private void populateLayout() {
    caseTitleTextView.setText(caseInfo.getTitle());
    caseNumberTextView.setText(caseInfo.getCaseNumber());
    decisionDateTextView.setText(caseInfo.getDecisionDate());
    tribunalCourtTextView.setText(caseInfo.getTribunalCourt());
    coramTextView.setText(caseInfo.getCoram());
    counselNamesTextView.setText(caseInfo.getCounselNames());
    partiesTextView.setText(caseInfo.getParties());
    caseReferringTextView.setText(String.valueOf(caseInfo.getReferring()));
    caseFollowingTextView.setText(String.valueOf(caseInfo.getFollowing()));

    populateContentLayout();
  }


  public void populateContentLayout() {
    List<CaseContent> caseContentList = extractCaseContent();
    LinearLayout contentLayout = rootView.findViewById(R.id.contentLayout);

    for (CaseContent caseContent : caseContentList) {
      TextView textViewTitle = new TextView(getContext());
      textViewTitle.setText(caseContent.getTitle());
      textViewTitle.setTypeface(null, Typeface.BOLD);

      TextView textViewContent = new TextView(getContext());
      textViewContent.setText(caseContent.getContent());

      contentLayout.addView(textViewTitle);
      contentLayout.addView(textViewContent);
    }
  }

  public List<CaseContent> extractCaseContent() {
    List<CaseContent> caseContentList = new ArrayList<>();

    if (caseInfo.getContent1() != null)
      if (!caseInfo.getContent1().getTitle().isEmpty() && !caseInfo.getContent1().getContent().isEmpty()) {
        caseContentList.add(caseInfo.getContent1());
      }
    if (caseInfo.getContent2() != null)
      if (!caseInfo.getContent2().getTitle().isEmpty() && !caseInfo.getContent2().getContent().isEmpty()) {
        caseContentList.add(caseInfo.getContent2());
      }
    if (caseInfo.getContent3() != null)
      if (!caseInfo.getContent3().getTitle().isEmpty() && !caseInfo.getContent3().getContent().isEmpty()) {
        caseContentList.add(caseInfo.getContent3());
      }
    if (caseInfo.getContent4() != null)
      if (!caseInfo.getContent4().getTitle().isEmpty() && !caseInfo.getContent4().getContent().isEmpty()) {
        caseContentList.add(caseInfo.getContent4());
      }
    if (caseInfo.getContent5() != null)
      if (!caseInfo.getContent5().getTitle().isEmpty() && !caseInfo.getContent5().getContent().isEmpty()) {
        caseContentList.add(caseInfo.getContent5());
      }
    if (caseInfo.getContent6() != null)
      if (!caseInfo.getContent6().getTitle().isEmpty() && !caseInfo.getContent6().getContent().isEmpty()) {
        caseContentList.add(caseInfo.getContent6());
      }
    if (caseInfo.getContent7() != null)
      if (!caseInfo.getContent7().getTitle().isEmpty() && !caseInfo.getContent7().getContent().isEmpty()) {
        caseContentList.add(caseInfo.getContent7());
      }
    if (caseInfo.getContent8() != null)
      if (!caseInfo.getContent8().getTitle().isEmpty() && !caseInfo.getContent8().getContent().isEmpty()) {
        caseContentList.add(caseInfo.getContent8());
      }
    if (caseInfo.getContent9() != null)
      if (!caseInfo.getContent9().getTitle().isEmpty() && !caseInfo.getContent9().getContent().isEmpty()) {
        caseContentList.add(caseInfo.getContent9());
      }
    if (caseInfo.getContent10() != null)
      if (!caseInfo.getContent10().getTitle().isEmpty() && !caseInfo.getContent10().getContent().isEmpty()) {
        caseContentList.add(caseInfo.getContent10());
      }

    return caseContentList;
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
