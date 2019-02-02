package dev.likz.lawnetgo.databases.tables;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import dev.likz.lawnetgo.databases.dao.DAOManager;

public class RecommendedCasesTable {
  public static final String TABLE_RECOMMENDE_CASE = "recommended_case_table";
  public static final String COLUMN_ID = "id";
  public static final String COLUMN_TITLE = "title";
  public static final String COLUMN_CASE_NUMBER = "caseNumber";
  public static final String COLUMN_DECISION_DATE = "decisionDate";
  public static final String COLUMN_TRIBUNAL_COURT = "tribunalCourt";
  public static final String COLUMN_CORAM = "coram";
  public static final String COLUMN_COUNSEL_NAMES = "counselNames";
  public static final String COLUMN_PARTIES = "parties";
  public static final String COLUMN_CONTENT_1 = "content1";
  public static final String COLUMN_CONTENT_2 = "content2";
  public static final String COLUMN_CONTENT_3 = "content3";
  public static final String COLUMN_CONTENT_4 = "content4";
  public static final String COLUMN_CONTENT_5 = "content5";
  public static final String COLUMN_CONTENT_6 = "content6";
  public static final String COLUMN_CONTENT_7 = "content7";
  public static final String COLUMN_CONTENT_8 = "content8";
  public static final String COLUMN_CONTENT_9 = "content9";
  public static final String COLUMN_CONTENT_10 = "content10";
  public static final String COLUMN_SNIPPETS = "snippets";
  public static final String COLUMN_FOLLOWING = "following";
  public static final String COLUMN_REFERRING = "referring";
  public static final String COLUMN_FAVORITE = "favorite";

  // Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
          + TABLE_RECOMMENDE_CASE
          + "("
          + COLUMN_ID + " integer primary key autoincrement, "
          + COLUMN_TITLE + ","
          + COLUMN_CASE_NUMBER + ","
          + COLUMN_DECISION_DATE + ","
          + COLUMN_TRIBUNAL_COURT + ","
          + COLUMN_CORAM + ","
          + COLUMN_COUNSEL_NAMES + ","
          + COLUMN_PARTIES + ","
          + COLUMN_CONTENT_1 + " TEXT ,"
          + COLUMN_CONTENT_2 + " TEXT ,"
          + COLUMN_CONTENT_3 + " TEXT ,"
          + COLUMN_CONTENT_4 + " TEXT ,"
          + COLUMN_CONTENT_5 + " TEXT ,"
          + COLUMN_CONTENT_6 + " TEXT ,"
          + COLUMN_CONTENT_7 + " TEXT ,"
          + COLUMN_CONTENT_8 + " TEXT ,"
          + COLUMN_CONTENT_9 + " TEXT ,"
          + COLUMN_CONTENT_10 + "  TEXT ,"
          + COLUMN_SNIPPETS + ","
          + COLUMN_FOLLOWING + " integer,"
          + COLUMN_REFERRING + " integer,"
          + COLUMN_FAVORITE + " integer);";

  public static void onCreate(SQLiteDatabase database) {
    Log.d(DAOManager.LOG_TAG, "Recent Creating db");
    database.execSQL(DATABASE_CREATE);
    Log.d(DAOManager.LOG_TAG, "Recent Success");
  }

  public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w(DAOManager.LOG_TAG,
            "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECOMMENDE_CASE);
    onCreate(db);
  }

}