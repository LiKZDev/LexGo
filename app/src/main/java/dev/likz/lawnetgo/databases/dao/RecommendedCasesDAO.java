package dev.likz.lawnetgo.databases.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import dev.likz.lawnetgo.databases.tables.RecommendedCasesTable;
import dev.likz.lawnetgo.entities.Case;
import dev.likz.lawnetgo.entities.CaseContent;

/**
 * Created by Li on 6/4/2015.
 */
public class RecommendedCasesDAO extends DAOManager {
  private String[] ALL_COLUMNS = {
          RecommendedCasesTable.COLUMN_ID,
          RecommendedCasesTable.COLUMN_TITLE,
          RecommendedCasesTable.COLUMN_CASE_NUMBER,
          RecommendedCasesTable.COLUMN_DECISION_DATE,
          RecommendedCasesTable.COLUMN_TRIBUNAL_COURT,
          RecommendedCasesTable.COLUMN_CORAM,
          RecommendedCasesTable.COLUMN_COUNSEL_NAMES,
          RecommendedCasesTable.COLUMN_PARTIES,
          RecommendedCasesTable.COLUMN_CONTENT_1,
          RecommendedCasesTable.COLUMN_CONTENT_2,
          RecommendedCasesTable.COLUMN_CONTENT_3,
          RecommendedCasesTable.COLUMN_CONTENT_4,
          RecommendedCasesTable.COLUMN_CONTENT_5,
          RecommendedCasesTable.COLUMN_CONTENT_6,
          RecommendedCasesTable.COLUMN_CONTENT_7,
          RecommendedCasesTable.COLUMN_CONTENT_8,
          RecommendedCasesTable.COLUMN_CONTENT_9,
          RecommendedCasesTable.COLUMN_CONTENT_10,
          RecommendedCasesTable.COLUMN_SNIPPETS,
          RecommendedCasesTable.COLUMN_FOLLOWING,
          RecommendedCasesTable.COLUMN_REFERRING,
          RecommendedCasesTable.COLUMN_FAVORITE
  };

  public RecommendedCasesDAO(Context context) {
    super(context);
  }

  public boolean createRecommendedRecord(Case caseInfo) {
    openDatabase();

    if (database == null)
      return false;

    ContentValues values = new ContentValues();
    values.put(RecommendedCasesTable.COLUMN_TITLE, caseInfo.getTitle());
    values.put(RecommendedCasesTable.COLUMN_CASE_NUMBER, caseInfo.getCaseNumber());
    values.put(RecommendedCasesTable.COLUMN_DECISION_DATE, caseInfo.getDecisionDate());
    values.put(RecommendedCasesTable.COLUMN_TRIBUNAL_COURT, caseInfo.getTribunalCourt());
    values.put(RecommendedCasesTable.COLUMN_CORAM, caseInfo.getCoram());
    values.put(RecommendedCasesTable.COLUMN_COUNSEL_NAMES, caseInfo.getCounselNames());
    values.put(RecommendedCasesTable.COLUMN_PARTIES, caseInfo.getParties());
    if (caseInfo.getContent1() != null)
      values.put(RecommendedCasesTable.COLUMN_CONTENT_1, caseInfo.getContent1().toString());
    if (caseInfo.getContent2() != null)
      values.put(RecommendedCasesTable.COLUMN_CONTENT_2, caseInfo.getContent2().toString());
    if (caseInfo.getContent3() != null)
      values.put(RecommendedCasesTable.COLUMN_CONTENT_3, caseInfo.getContent3().toString());
    if (caseInfo.getContent4() != null)
      values.put(RecommendedCasesTable.COLUMN_CONTENT_4, caseInfo.getContent4().toString());
    if (caseInfo.getContent5() != null)
      values.put(RecommendedCasesTable.COLUMN_CONTENT_5, caseInfo.getContent5().toString());
    if (caseInfo.getContent6() != null)
      values.put(RecommendedCasesTable.COLUMN_CONTENT_6, caseInfo.getContent6().toString());
    if (caseInfo.getContent7() != null)
      values.put(RecommendedCasesTable.COLUMN_CONTENT_7, caseInfo.getContent7().toString());
    if (caseInfo.getContent8() != null)
      values.put(RecommendedCasesTable.COLUMN_CONTENT_8, caseInfo.getContent8().toString());
    if (caseInfo.getContent9() != null)
      values.put(RecommendedCasesTable.COLUMN_CONTENT_9, caseInfo.getContent9().toString());
    if (caseInfo.getContent10() != null)
      values.put(RecommendedCasesTable.COLUMN_CONTENT_10, caseInfo.getContent10().toString());
    values.put(RecommendedCasesTable.COLUMN_SNIPPETS, caseInfo.getSnippets());
    values.put(RecommendedCasesTable.COLUMN_FOLLOWING, caseInfo.getFollowing());
    values.put(RecommendedCasesTable.COLUMN_REFERRING, caseInfo.getReferring());
    values.put(RecommendedCasesTable.COLUMN_FAVORITE, caseInfo.getFavourite());

    database.insert(RecommendedCasesTable.TABLE_RECOMMENDE_CASE, null, values);

    closeDatabase();

    return true;
  }

  private void deleteRecommended(int id) {
    database.delete(RecommendedCasesTable.TABLE_RECOMMENDE_CASE, RecommendedCasesTable.COLUMN_ID
            + " = '" + id + "'", null);
  }

  public List<Case> getAllRecommended() {
    openDatabase();

    if (database == null)
      return null;

    List<Case> caseList = new ArrayList<>();

    Cursor cursor = database.query(RecommendedCasesTable.TABLE_RECOMMENDE_CASE,
            ALL_COLUMNS, null, null, null, null, RecommendedCasesTable.COLUMN_ID + " DESC");

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      Case cc = cursorToNext(cursor);
      caseList.add(cc);
      Log.d("DBLogger", cc.toString());
      cursor.moveToNext();
    }

    cursor.close();

    closeDatabase();

    return caseList;
  }

  @Override
  public Case cursorToNext(Cursor cursor) {

    Case caseInfo = new Case();

    Gson gson = new Gson();

    caseInfo.setId(cursor.getInt(0));
    caseInfo.setTitle(cursor.getString(1));
    caseInfo.setCaseNumber(cursor.getString(2));
    caseInfo.setDecisionDate(cursor.getString(3));
    caseInfo.setTribunalCourt(cursor.getString(4));
    caseInfo.setCoram(cursor.getString(5));
    caseInfo.setCounselNames(cursor.getString(6));
    caseInfo.setParties(cursor.getString(7));
//    try {
//    if(caseInfo.getTitle().equals("547")) {
//      caseInfo
//    }
    Log.d("JSONExtrator", caseInfo.getId() + caseInfo.getTitle() + " " + (cursor.getString(8)));
    caseInfo.setContent1(gson.fromJson(cursor.getString(8).replaceAll("\\\\", ""), new TypeToken<CaseContent>() {
    }.getType()));
//    } catch (Exception e){
//      caseInfo.setContent1(gson.fromJson(terminateString(cursor.getString(8)), new TypeToken<CaseContent>() {
//      }.getType()));
//    }
    try {
      caseInfo.setContent2(gson.fromJson(cursor.getString(9), new TypeToken<CaseContent>() {
      }.getType()));
    } catch (Exception e) {
      caseInfo.setContent2(gson.fromJson(terminateString(cursor.getString(9)), new TypeToken<CaseContent>() {
      }.getType()));
    }
    try {
      caseInfo.setContent3(gson.fromJson(cursor.getString(10), new TypeToken<CaseContent>() {
      }.getType()));
    } catch (Exception e) {
      caseInfo.setContent3(gson.fromJson(terminateString(cursor.getString(10)), new TypeToken<CaseContent>() {
      }.getType()));
    }
    try {
      caseInfo.setContent4(gson.fromJson(cursor.getString(11), new TypeToken<CaseContent>() {
      }.getType()));
    } catch (Exception e) {
      caseInfo.setContent4(gson.fromJson(terminateString(cursor.getString(11)), new TypeToken<CaseContent>() {
      }.getType()));
    }
    try {
      caseInfo.setContent5(gson.fromJson(cursor.getString(12), new TypeToken<CaseContent>() {
      }.getType()));
    } catch (Exception e) {
      caseInfo.setContent5(gson.fromJson(terminateString(cursor.getString(12)), new TypeToken<CaseContent>() {
      }.getType()));
    }
    try {
      caseInfo.setContent6(gson.fromJson(cursor.getString(13), new TypeToken<CaseContent>() {
      }.getType()));
    } catch (Exception e) {
      caseInfo.setContent6(gson.fromJson(terminateString(cursor.getString(13)), new TypeToken<CaseContent>() {
      }.getType()));
    }
    try {
      caseInfo.setContent7(gson.fromJson(cursor.getString(14), new TypeToken<CaseContent>() {
      }.getType()));
    } catch (Exception e) {
      caseInfo.setContent7(gson.fromJson(terminateString(cursor.getString(14)), new TypeToken<CaseContent>() {
      }.getType()));
    }
    try {
      caseInfo.setContent8(gson.fromJson(cursor.getString(15), new TypeToken<CaseContent>() {
      }.getType()));
    } catch (Exception e) {
      caseInfo.setContent8(gson.fromJson(terminateString(cursor.getString(15)), new TypeToken<CaseContent>() {
      }.getType()));
    }
    try {
      caseInfo.setContent9(gson.fromJson(cursor.getString(16), new TypeToken<CaseContent>() {
      }.getType()));
    } catch (Exception e) {
      caseInfo.setContent9(gson.fromJson(terminateString(cursor.getString(16)), new TypeToken<CaseContent>() {
      }.getType()));
    }
    try {
      caseInfo.setContent10(gson.fromJson(cursor.getString(17), new TypeToken<CaseContent>() {
      }.getType()));
    } catch (Exception e) {
      caseInfo.setContent10(gson.fromJson(terminateString(cursor.getString(17)), new TypeToken<CaseContent>() {
      }.getType()));
    }

    caseInfo.setSnippets(cursor.getString(18));
    caseInfo.setFollowing(cursor.getInt(19));
    caseInfo.setReferring(cursor.getInt(20));
    caseInfo.setFavourite(cursor.getInt(21));

    return caseInfo;
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

  public String terminateString(String s) {
    return s + "\"}";
//    Log.d("JSONExtrator", "terminateString()");
//    //Check whether or not the string contains at least four characters; if not, this method is useless
//    if (length < 2) return "Error: The provided string is not greater than four characters long.";
//    return s.substring(0, length - 4) + "\"}";
  }

}
