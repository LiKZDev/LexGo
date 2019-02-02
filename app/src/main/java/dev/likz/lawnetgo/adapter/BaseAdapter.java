package dev.likz.lawnetgo.adapter;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  public SparseBooleanArray expanded = new SparseBooleanArray();
  public SparseBooleanArray refresh = new SparseBooleanArray();

  SparseArray<List<T>> loadedInfo = new SparseArray<>();

  @Override
  public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

  @Override
  public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

  @Override
  public abstract int getItemCount();

  public abstract void updateAdapter(List<T> list);

  public void resetExpanded() {
    expanded = new SparseBooleanArray();
    refresh = new SparseBooleanArray();
  }

//  public static class GetBusInfoAsync extends AsyncTask<String, Void, BusTiming> {
//    WeakReference<View> rootView;
//    WeakReference<AbsListView> resultView;
//    WeakReference<ProgressBar> progressBar;
//    WeakReference<View> refreshImageView;
//
//    int currentListPosition;
//    String busStopId;
//    String serviceNumber;
//    WeakReference<Context> context;
//    SparseArray<List> loadedInfo;
//
//    GetBusInfoAsync(Context context, int currentListPosition, String busStopId, String serviceNumber,
//                    View rootView, AbsListView resultView, SparseArray<List> loadedInfo) {
//      super();
//      this.context = new WeakReference<>(context);
//      this.currentListPosition = currentListPosition;
//      this.busStopId = busStopId;
//      this.serviceNumber = serviceNumber;
//      this.rootView = new WeakReference<>(rootView);
//      this.resultView = new WeakReference<>(resultView);
//      this.loadedInfo = loadedInfo;
//
//      progressBar = new WeakReference<>(rootView.findViewById(R.id.progressBar));
//      refreshImageView = new WeakReference<>(rootView.findViewById(R.id.refresh));
//    }
//
//    @Override
//    protected BusTiming doInBackground(String... params) {
//      final String BASE_URL = "https://where-my-bus.azurewebsites.net/api/busTiming/getBusService?";
//      APIHelper apiManager = new APIHelper();
//      Gson gson = new Gson();
//
//      Map<String, String> URLParams = new HashMap<>();
//      URLParams.put("busStopCode", busStopId);
//      URLParams.put("serviceNumber", serviceNumber);
//
//      String JSONStr = apiManager.call(BASE_URL, URLParams);
//      return gson.fromJson(JSONStr, new TypeToken<BusTiming>() {
//      }.getType());
//    }
//
//    @Override
//    protected void onPostExecute(BusTiming result) {
//      /** Hides the progressbar **/
//      if (progressBar != null)
//        progressBar.get().setVisibility(View.GONE);
//
//      /** Show the refresh image again if it is a BusStop view **/
//      if (refreshImageView.get() != null)
//        refreshImageView.get().setVisibility(View.VISIBLE);
//
//      if (result != null) {
//        if (resultView.get() instanceof GridView) {
//          setupGridAdapter(result);
//        } else if (resultView.get() instanceof ListView) {
//          setupListAdapter(result);
//        }
//      } else {
//
//      }
//    }
//
//    public void setupGridAdapter(BusTiming busTiming) {
//      BusTiming.ServiceInfo serviceInfo = null;
//
//      if (busTiming.getServices().size() > 0)
//        serviceInfo = busTiming.getServices().get(0);
//
//      List<BusTiming.ServiceInfo.BusInfo> busServiceTimingList = BusTiming.extractBusTimings(serviceInfo);
//
//      loadedInfo.put(currentListPosition, busServiceTimingList);
//
//      resultView.get().setAdapter(new BusGridAdapter(context.get(), busServiceTimingList, BusGridAdapter.TYPE_COMPACT));
//    }
//
//    public void setupListAdapter(BusTiming busTiming) {
//      loadedInfo.put(currentListPosition, busTiming.getServices());
//
//      resultView.get().setAdapter(new BusInfoAdapter(context.get(), busTiming.getServices()));
//    }
//  }
}
