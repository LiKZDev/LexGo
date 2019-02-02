package dev.likz.lawnetgo.databases.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import dev.likz.lawnetgo.databases.helpers.DatabaseHelper;

public abstract class DAOManager<T> {
  public static final String LOG_TAG = "DBLogger";

  SQLiteDatabase database;
  SQLiteOpenHelper dbHelper;

  public DAOManager(Context context) {
    dbHelper = new DatabaseHelper(context);
  }

  void openDatabase() {
    Log.d(LOG_TAG, "openDatabase");
//    if (database == null || !database.isOpen()) {
      try {
        database = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "Databse is " + database.getVersion());
      } catch (Exception e) {
        Log.d(LOG_TAG, "Error getting database \n" + e.toString());
      }
//    }
  }

  void closeDatabase() {
    if (database != null)
      database.close();
    if (dbHelper != null)
      dbHelper.close();
  }

  public abstract T cursorToNext(Cursor cursor);


}
