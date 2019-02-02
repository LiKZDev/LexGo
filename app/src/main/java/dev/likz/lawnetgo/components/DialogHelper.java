package dev.likz.lawnetgo.components;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AlertDialog;
import dev.likz.lawnetgo.MainActivity;
import dev.likz.lawnetgo.R;
import dev.likz.lawnetgo.entities.CaseContent;
import dev.likz.lawnetgo.entities.Note;
import dev.likz.lawnetgo.entities.User;
import dev.likz.lawnetgo.helpers.APIHelper;

public class DialogHelper {
  private Context context;
  private View dialogView;

//  private TextInputEditText busStopNameEditField;
//  private TextInputEditText busStopAddressEditText;
//  private TextInputEditText alarmRepeatDaysEditText;
//  private TextInputEditText alarmTimeEditText;
//
//  private LinearLayout alarmLayout;
//
//  private ImageView busStopNameClear;
//  private ImageView alarmRepeatDaysClear;
//  private ImageView alarmTimeClear;

  //  private boolean[] checkedDays = new boolean[]{false, false, false, false, false, false, false};
  private TextInputEditText notesEditText;

  public DialogHelper(Context context) {
    this.context = context;
  }

  private void initializeLayout() {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    dialogView = inflater.inflate(R.layout.dialog_collab, null);

    notesEditText = dialogView.findViewById(R.id.notes);


//    busStopNameEditField = dialogView.findViewById(R.id.busStopName);
//    busStopAddressEditText = dialogView.findViewById(R.id.busStopAddress);
//    alarmLayout = dialogView.findViewById(R.id.alarmLayout);
//    alarmRepeatDaysEditText = dialogView.findViewById(R.id.alarmRepeatDays);
//    alarmTimeEditText = dialogView.findViewById(R.id.alarmTime);
//
//    busStopNameClear = dialogView.findViewById(R.id.busStopNameClear);
//    alarmRepeatDaysClear = dialogView.findViewById(R.id.alarmRepeatDaysClear);
//    alarmTimeClear = dialogView.findViewById(R.id.alarmTimeClear);
  }

  public void showCollabDialog(String caseId) {
    new GetNotesAsync(MainActivity.loggedInUser, caseId).execute();

    AlertDialog.Builder builder = new AlertDialog.Builder(context);

    initializeLayout();

    builder.setView(dialogView)
            .setTitle("Collaboration")
            .setPositiveButton(R.string.action_save, (dialog, which) -> {
              new SaveNotesAsync(MainActivity.loggedInUser, notesEditText.getText().toString(), caseId).execute();
            })
            .setNegativeButton(R.string.action_cancel, null);

    Dialog dialog = builder.create();

//    initializeFavouriteDialog(dialog, busRoute.getBusStopDescription(), busRoute.getFullAddress());

    dialog.show();
  }

//  public void showFavouriteBusStopDialog(BusStop busStop) {
//    AlertDialog.Builder builder = new AlertDialog.Builder(context);
//
//    initializeLayout();
//
//    builder.setView(dialogView)
//            .setTitle(busStop.getBusStopDescription())
//            .setPositiveButton(R.string.action_ok, (dialog, which) -> {
//              FavouriteBusStopDAO dao = new FavouriteBusStopDAO(context);
//              if (!dao.createBusStop(busStop))
//                ((MainActivity)context).snackBarHelper.showShortSnackBar(context.getString(R.string.standard_error));
//            })
//            .setNegativeButton(R.string.action_cancel, null)
//            .setNeutralButton(R.string.title_alarms, null);
//
//    Dialog dialog = builder.create();
//
//    initializeFavouriteDialog(dialog, busStop.getBusStopDescription(), busStop.getFullAddress());
//
//    dialog.show();
//  }
//
//  public void initializeFavouriteDialog(Dialog dialog, String busStopDescription, String fullAddress) {
//    dialog.setOnShowListener(dialogInterface -> {
//      Button neutralButton = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEUTRAL);
//      neutralButton.setOnClickListener(view -> {
//        if (alarmLayout.getVisibility() == View.VISIBLE) {
//          alarmLayout.setVisibility(View.GONE);
//        } else {
//          alarmLayout.setVisibility(View.VISIBLE);
//        }
//      });
//    });
//
//    busStopNameEditField.setText(busStopDescription);
//    busStopNameClear.bringToFront();
//    EditTextHelper.setClearable(context, busStopNameEditField, busStopNameClear);
//
//    busStopAddressEditText.setText(fullAddress);
//
//    EditTextHelper.setClearable(context, alarmRepeatDaysEditText, alarmRepeatDaysClear);
//    alarmRepeatDaysClear.setOnClickListener(v -> {
//      /* TODO: Cleanup code here */
//      checkedDays = new boolean[]{false, false, false, false, false, false, false};
//      alarmRepeatDaysEditText.getText().clear();
//      KeyboardHelper.showKeyboard(context, alarmRepeatDaysEditText);
//    });
//    alarmRepeatDaysEditText.setOnClickListener(v -> {
//      showAlarmRepeatDaysDialog();
//    });
//
//    EditTextHelper.setClearable(context, alarmTimeEditText, alarmTimeClear);
//    alarmTimeEditText.setOnClickListener(v -> {
//      showAlarmTimeDialog();
//    });
//  }
//
//  public void showAlarmRepeatDaysDialog() {
//    AlertDialog.Builder builder = new AlertDialog.Builder(context);
//    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//    dialogView = inflater.inflate(R.layout.dialog_favourite, null);
//
//    builder.setMultiChoiceItems(R.array.repeatDays, checkedDays, (dialog, which, isChecked) -> checkedDays[which] = isChecked)
//            .setTitle(R.string.input_repeat_days)
//            .setPositiveButton(R.string.action_ok, (dialog, id) -> {
//              alarmRepeatDaysEditText.setText(getSelectedDaysText());
//            })
//            .setNegativeButton(R.string.action_cancel, (dialog, id) -> {
//            });
//
//    Dialog dialog = builder.create();
//
//    dialog.show();
//  }
//
//  public void showAlarmTimeDialog() {
//    final Calendar c = Calendar.getInstance();
//    int mHour = c.get(Calendar.HOUR_OF_DAY);
//    int mMinute = c.get(Calendar.MINUTE);
//
//    TimePickerDialog timePickerDialog = new TimePickerDialog(context,
//            (view, hourOfDay, minute) -> alarmTimeEditText.setText(getTime24Hours(hourOfDay, minute)), mHour, mMinute, false);
//    timePickerDialog.show();
//  }
//
//  public String getSelectedDaysText() {
//    String[] daysName = new String[]{
//            "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
//    };
//    List<String> days = new ArrayList<>();
//
//    for (int i = 0; i < checkedDays.length; i++) {
//      if (checkedDays[i]) {
//        days.add(daysName[i]);
//      }
//    }
//    return TextUtils.join(", ", days);
//  }
//
//  public String getTime24Hours(int hourOfDay, int minutes) {
//    String postFix = "am";
//
//    if (hourOfDay == 0) {
//      hourOfDay = 12;
//    } else if (hourOfDay >= 12) {
//      postFix = "pm";
//      if (hourOfDay > 12)
//        hourOfDay -= 12;
//    }
//
//    return hourOfDay + ":" + String.format("%02d", minutes) + " " + postFix;
//  }

  public class SaveNotesAsync extends AsyncTask<String, Void, Boolean> {
    private User user;
    private String notes;
    private String caseId;

    SaveNotesAsync(User user, String notes, String caseId) {
      this.user = user;
      this.notes = notes;
      this.caseId = caseId;
    }

    @Override
    protected Boolean doInBackground(String... sNum) {
      final String BASE_URL = "http://54.255.234.45/CreateNotes.php?";
      APIHelper apiManager = new APIHelper();

      Map<String, String> params = new HashMap<>();
      params.put("content", notes);
      params.put("company", user.getCompany());
      params.put("department", user.getDepartment());
      params.put("team", user.getTeam());
      params.put("username", user.getUsername());
      params.put("cases", caseId);
      params.put("id", "0");

      apiManager.call(BASE_URL, params);

      return true;
    }

    @Override
    protected void onPostExecute(Boolean success) {
    }
  }

  public class GetNotesAsync extends AsyncTask<String, Void, String> {
    private User user;
    private String caseId;

    GetNotesAsync(User user, String caseId) {
      this.user = user;
      this.caseId = caseId;
    }

    @Override
    protected String doInBackground(String... sNum) {
      final String BASE_URL = "http://54.255.234.45/RetrieveNotes.php?";
      APIHelper apiManager = new APIHelper();

      Map<String, String> params = new HashMap<>();
      params.put("company", user.getCompany());
      params.put("department", user.getDepartment());
      params.put("team", user.getTeam());
      params.put("cases", caseId);

      String jsonStr = apiManager.call(BASE_URL, params);

      return jsonStr;
    }

    @Override
    protected void onPostExecute(String jsonStr) {
      Gson gson = new Gson();
      Note note = gson.fromJson(jsonStr, new TypeToken<Note>() {
      }.getType());

      notesEditText.setText(note.getContent());
    }
  }


}
