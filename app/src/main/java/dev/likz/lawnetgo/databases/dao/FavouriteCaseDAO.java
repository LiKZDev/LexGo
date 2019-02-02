package dev.likz.lawnetgo.databases.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.likz.lawnetgo.databases.tables.FavouriteCasesTable;
import dev.likz.lawnetgo.databases.tables.SearchHistoryTable;
import dev.likz.lawnetgo.entities.Case;
import dev.likz.lawnetgo.entities.CaseContent;
import dev.likz.lawnetgo.entities.SearchSuggestion;

/**
 * Created by Li on 6/4/2015.
 */
public class FavouriteCaseDAO extends DAOManager {
  private String[] ALL_COLUMNS = {
          FavouriteCasesTable.COLUMN_ID,
          FavouriteCasesTable.COLUMN_TITLE,
          FavouriteCasesTable.COLUMN_CASE_NUMBER,
          FavouriteCasesTable.COLUMN_DECISION_DATE,
          FavouriteCasesTable.COLUMN_TRIBUNAL_COURT,
          FavouriteCasesTable.COLUMN_CORAM,
          FavouriteCasesTable.COLUMN_COUNSEL_NAMES,
          FavouriteCasesTable.COLUMN_PARTIES,
          FavouriteCasesTable.COLUMN_CONTENT_1,
          FavouriteCasesTable.COLUMN_CONTENT_2,
          FavouriteCasesTable.COLUMN_CONTENT_3,
          FavouriteCasesTable.COLUMN_CONTENT_4,
          FavouriteCasesTable.COLUMN_CONTENT_5,
          FavouriteCasesTable.COLUMN_CONTENT_6,
          FavouriteCasesTable.COLUMN_CONTENT_7,
          FavouriteCasesTable.COLUMN_CONTENT_8,
          FavouriteCasesTable.COLUMN_CONTENT_9,
          FavouriteCasesTable.COLUMN_CONTENT_10,
          FavouriteCasesTable.COLUMN_SNIPPETS,
          FavouriteCasesTable.COLUMN_FOLLOWING,
          FavouriteCasesTable.COLUMN_REFERRING,
          FavouriteCasesTable.COLUMN_FAVORITE
  };

  public FavouriteCaseDAO(Context context) {
    super(context);
  }

  public boolean createFavouriteRecord(Case caseInfo) {
    openDatabase();

    if (database == null)
      return false;

    ContentValues values = new ContentValues();
    values.put(FavouriteCasesTable.COLUMN_TITLE, caseInfo.getTitle());
    values.put(FavouriteCasesTable.COLUMN_CASE_NUMBER, caseInfo.getCaseNumber());
    values.put(FavouriteCasesTable.COLUMN_DECISION_DATE, caseInfo.getDecisionDate());
    values.put(FavouriteCasesTable.COLUMN_TRIBUNAL_COURT, caseInfo.getTribunalCourt());
    values.put(FavouriteCasesTable.COLUMN_CORAM, caseInfo.getCoram());
    values.put(FavouriteCasesTable.COLUMN_COUNSEL_NAMES, caseInfo.getCounselNames());
    values.put(FavouriteCasesTable.COLUMN_PARTIES, caseInfo.getParties());
    if (caseInfo.getContent1() != null)
      values.put(FavouriteCasesTable.COLUMN_CONTENT_1, caseInfo.getContent1().toString());
    if (caseInfo.getContent2() != null)
      values.put(FavouriteCasesTable.COLUMN_CONTENT_2, caseInfo.getContent2().toString());
    if (caseInfo.getContent3() != null)
      values.put(FavouriteCasesTable.COLUMN_CONTENT_3, caseInfo.getContent3().toString());
    if (caseInfo.getContent4() != null)
      values.put(FavouriteCasesTable.COLUMN_CONTENT_4, caseInfo.getContent4().toString());
    if (caseInfo.getContent5() != null)
      values.put(FavouriteCasesTable.COLUMN_CONTENT_5, caseInfo.getContent5().toString());
    if (caseInfo.getContent6() != null)
      values.put(FavouriteCasesTable.COLUMN_CONTENT_6, caseInfo.getContent6().toString());
    if (caseInfo.getContent7() != null)
      values.put(FavouriteCasesTable.COLUMN_CONTENT_7, caseInfo.getContent7().toString());
    if (caseInfo.getContent8() != null)
      values.put(FavouriteCasesTable.COLUMN_CONTENT_8, caseInfo.getContent8().toString());
    if (caseInfo.getContent9() != null)
      values.put(FavouriteCasesTable.COLUMN_CONTENT_9, caseInfo.getContent9().toString());
    if (caseInfo.getContent10() != null)
      values.put(FavouriteCasesTable.COLUMN_CONTENT_10, caseInfo.getContent10().toString());
    values.put(FavouriteCasesTable.COLUMN_SNIPPETS, caseInfo.getSnippets());
    values.put(FavouriteCasesTable.COLUMN_FOLLOWING, caseInfo.getFollowing());
    values.put(FavouriteCasesTable.COLUMN_REFERRING, caseInfo.getReferring());
    values.put(FavouriteCasesTable.COLUMN_FAVORITE, caseInfo.getFavourite());

    database.insert(FavouriteCasesTable.TABLE_FAVOURITE_CASE, null, values);

    closeDatabase();

    return true;
  }

  public void toggleFavourite(Case caseInfo, int favourite) {
    Log.d("DBLogger", "Favourite is  " + favourite + " ID is " + caseInfo.getId());
    openDatabase();

    if (database == null)
      return;

    ContentValues values = new ContentValues();
    values.put(FavouriteCasesTable.COLUMN_FAVORITE, favourite);

    String whereClause = FavouriteCasesTable.COLUMN_ID + " =  ?";
    String[] whereArgs = new String[]{
            String.valueOf(caseInfo.getId())
    };

    int result = database.update(FavouriteCasesTable.TABLE_FAVOURITE_CASE,
            values, whereClause, whereArgs);

    Log.d("DBLogger", "Update" + result);

    closeDatabase();
  }

  public Case retrieveRecordById(String id) {
    openDatabase();

    if (database == null) {
      Log.d("DBLogger", "database is null");
      return null;
    }

    String whereClause = FavouriteCasesTable.COLUMN_ID + " =  ?";
    String[] whereArgs = new String[]{
            id
    };

    Cursor cursor = database.query(FavouriteCasesTable.TABLE_FAVOURITE_CASE,
            ALL_COLUMNS, whereClause, whereArgs, null, null, null);

    cursor.moveToFirst();

    Case caseInfo = null;

    if (!cursor.isAfterLast())
      caseInfo = cursorToNext(cursor);

    cursor.close();

    closeDatabase();

    return caseInfo;
  }


  public List<Case> getAllRecords() {
    openDatabase();

    if (database == null)
      return null;

    List<Case> caseList = new ArrayList<>();

    Cursor cursor = database.query(FavouriteCasesTable.TABLE_FAVOURITE_CASE,
            ALL_COLUMNS, null, null, null, null, null);

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

  public List<Case> getAllFavourites() {
    openDatabase();

    if (database == null)
      return null;

    String whereClause = FavouriteCasesTable.COLUMN_FAVORITE + " =  ?";
    String[] whereArgs = new String[]{
            "1"
    };

    List<Case> caseList = new ArrayList<>();

    Cursor cursor = database.query(FavouriteCasesTable.TABLE_FAVOURITE_CASE,
            ALL_COLUMNS, whereClause, whereArgs, null, null, FavouriteCasesTable.COLUMN_ID + " DESC");

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      Case cc = cursorToNext(cursor);
      caseList.add(cc);
      Log.d("DBLogger", cc.getCaseNumber());
      cursor.moveToNext();
    }

    cursor.close();

    closeDatabase();

    return caseList;
  }

  public List<Case> searchCases(String query) {
    Log.d("DBLogger", "searchCases" + query);
    openDatabase();

    if (database == null)
      return null;

    String whereClause = FavouriteCasesTable.COLUMN_TITLE + " LIKE ?";
    String[] whereArgs = new String[]{
            "%" + query + "%"
    };

    List<Case> caseList = new ArrayList<>();

    Cursor cursor = database.query(FavouriteCasesTable.TABLE_FAVOURITE_CASE,
            ALL_COLUMNS, whereClause, whereArgs, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      Case cc = cursorToNext(cursor);
      Log.d("DBLogger", "searchCases " + cc.toString());
      caseList.add(cc);
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

  public String terminateString(String s) {
    return s + "\"}";
//    Log.d("JSONExtrator", "terminateString()");
//    //Check whether or not the string contains at least four characters; if not, this method is useless
//    if (length < 2) return "Error: The provided string is not greater than four characters long.";
//    return s.substring(0, length - 4) + "\"}";
  }

}
