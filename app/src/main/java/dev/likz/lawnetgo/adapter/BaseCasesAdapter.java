package dev.likz.lawnetgo.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import dev.likz.lawnetgo.MainActivity;
import dev.likz.lawnetgo.R;
import dev.likz.lawnetgo.components.DialogHelper;
import dev.likz.lawnetgo.databases.dao.FavouriteCaseDAO;
import dev.likz.lawnetgo.entities.Case;
import dev.likz.lawnetgo.fragments.ContentFragment;

public class BaseCasesAdapter extends BaseAdapter {
  private static final int VIEW_TYPE_BUFFER = 0;
  private static final int VIEW_TYPE_ITEM = 1;

  private static final String TYPE_FAVOURITES = "Favourites";
  private static final String TYPE_RECENT = "Recent";

  List<Case> caseList = new ArrayList<>();

  private Context context;

  public BaseCasesAdapter(Context context) {
    this.context = context;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v;
    RecyclerView.ViewHolder viewHolder;

    if (viewType == VIEW_TYPE_BUFFER) {
      v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tab_buffer, parent, false);
      viewHolder = new BufferViewHolder(context, v);
    } else {
      v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_case, parent, false);
      viewHolder = new CaseViewHolder(context, v, this);
    }

    return viewHolder;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
    if (viewHolder instanceof BufferViewHolder) {
    }

    if (viewHolder instanceof CaseViewHolder) {
      CaseViewHolder caseViewHolder = (CaseViewHolder) viewHolder;
      int currentListPosition = position - 1;

      Case caseInfo = caseList.get(currentListPosition);

      caseViewHolder.caseTitleTextView.setText(caseInfo.getTitle());
      caseViewHolder.caseNumberTextView.setText(caseInfo.getCaseNumber());
      caseViewHolder.decisionDateTextView.setText(caseInfo.getDecisionDate());
      caseViewHolder.caseFollowingTextView.setText(String.valueOf(caseInfo.getFollowing()));
      caseViewHolder.caseReferringTextView.setText(String.valueOf(caseInfo.getReferring()));
      caseViewHolder.caseSnippets.setText(caseInfo.getSnippets());

      if (caseInfo.getFavourite() == 1) {
        caseViewHolder.isFavourite = true;
        caseViewHolder.favoriteImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite));
        ImageViewCompat.setImageTintList(caseViewHolder.favoriteImage, ColorStateList.valueOf(context.getResources().getColor(R.color.colorAccentLight)));
      } else {
        caseViewHolder.isFavourite = false;
        caseViewHolder.favoriteImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_border));
        ImageViewCompat.setImageTintList(caseViewHolder.favoriteImage, ColorStateList.valueOf(context.getResources().getColor(R.color.black)));
      }

      caseViewHolder.favoriteImage.setOnClickListener(v -> {
        FavouriteCaseDAO dao = new FavouriteCaseDAO(context);

        if (caseViewHolder.isFavourite) {
          caseViewHolder.isFavourite = false;
          caseViewHolder.favoriteImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_border));
          ImageViewCompat.setImageTintList(caseViewHolder.favoriteImage, ColorStateList.valueOf(context.getResources().getColor(R.color.black)));
          dao.toggleFavourite(caseInfo, 0);
          ((MainActivity) context).snackBarHelper.showShortSnackBar("Removed from Favourites");
        } else {
          caseViewHolder.isFavourite = true;
          caseViewHolder.favoriteImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite));
          ImageViewCompat.setImageTintList(caseViewHolder.favoriteImage, ColorStateList.valueOf(context.getResources().getColor(R.color.colorAccentLight)));
          dao.toggleFavourite(caseInfo, 1);
          ((MainActivity) context).snackBarHelper.showShortSnackBar("Added to Favourites");
        }
      });

      caseViewHolder.caseLayout.setOnClickListener(v -> {
        ((MainActivity) context).redirectToFragment(ContentFragment.newInstance(caseInfo.getId()), String.valueOf(MainActivity.FRAGMENT_CONTENT));
      });

//      busRoute = (BusRoute) caseList.get(currentListPosition);
//
//      if (caseList.size() > 0) {
//        busViewHolder.busNoTextView.setText(busRoute.getBusServiceNumber());
//        busViewHolder.busStopDescriptionTextView.setText(busRoute.getBusStopDescription());
//        busViewHolder.busStopRoadTextView.setText(busRoute.getFullAddress());
//
//        BusOperatorFormatter.formatTextView(context, busViewHolder.busOperatorTextView, busRoute.getBusOperator());
//
//        busViewHolder.currentListPosition = position;
//        busViewHolder.setupExpanded(expanded.get(busViewHolder.currentListPosition), refresh.get(busViewHolder.currentListPosition));
//      }
//
//      initializePopupMenu(viewHolder);
    }
  }

  @Override
  public int getItemCount() {
    return caseList.size() + 1;
  }

  @Override
  public void updateAdapter(List caseList) {
    this.caseList = caseList;
    Log.d("BaseCasesAdapter", "Size is " + caseList.size());
    resetExpanded();
    notifyDataSetChanged();
  }

  @Override
  public int getItemViewType(int position) {
    return (position == 0) ? VIEW_TYPE_BUFFER : VIEW_TYPE_ITEM;
  }

  public static class BufferViewHolder extends RecyclerView.ViewHolder {
    MaterialButton filterButton;

    public BufferViewHolder(Context context, @NonNull View itemView) {
      super(itemView);

      filterButton = itemView.findViewById(R.id.material_icon_button);

      filterButton.setOnClickListener(v -> {
        showFilterDialog(context);
      });
    }

    public void showFilterDialog(Context context) {
      AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
      mBuilder.setTitle("Filter");
      mBuilder.setSingleChoiceItems(context.getResources().getStringArray(R.array.filter_item), -1, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
          if (i == 0) {

          } else if (i == 1) {

          }
          dialogInterface.dismiss();
        }
      });

      AlertDialog mDialog = mBuilder.create();
      mDialog.show();
    }
  }

  public class CaseViewHolder extends RecyclerView.ViewHolder {
    //    RelativeLayout headerLayout;
    TextView caseTitleTextView;
    TextView caseNumberTextView;
    TextView decisionDateTextView;
    TextView caseFollowingTextView;
    TextView caseReferringTextView;
    TextView caseSnippets;
    ImageView favoriteImage;
    LinearLayout caseLayout;

    Context context;
    View rootView;
    BaseCasesAdapter adapter;
    Boolean isFavourite = false;
    int currentListPosition = -1;

    public CaseViewHolder(Context context, View rootView, final BaseCasesAdapter adapter) {
      super(rootView);

      this.rootView = rootView;
      this.adapter = adapter;
      this.context = context;

      caseTitleTextView = rootView.findViewById(R.id.caseTitle);
      caseNumberTextView = rootView.findViewById(R.id.caseNumber);
      decisionDateTextView = rootView.findViewById(R.id.decisionDate);
      caseFollowingTextView = rootView.findViewById(R.id.caseFollowing);
      caseReferringTextView = rootView.findViewById(R.id.caseReferring);
      caseSnippets = rootView.findViewById(R.id.caseSnippets);
      favoriteImage = rootView.findViewById(R.id.favorite_button);
      caseLayout = rootView.findViewById(R.id.caseLayout);

//      headerLayout.setOnClickListener(v -> {
//        if (adapter.expanded.get(currentListPosition)) {
//          adapter.refresh.put(currentListPosition, true);
//          refreshBus();
//        } else {
//          adapter.expanded.put(currentListPosition, true);
//          adapter.refresh.put(currentListPosition, true);
//        }
//        adapter.notifyItemChanged(currentListPosition);
//      });

    }

  }
}
