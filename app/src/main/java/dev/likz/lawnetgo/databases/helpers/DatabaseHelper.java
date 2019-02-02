package dev.likz.lawnetgo.databases.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import dev.likz.lawnetgo.databases.tables.FavouriteCasesTable;
import dev.likz.lawnetgo.databases.tables.RecentCasesTable;
import dev.likz.lawnetgo.databases.tables.SearchHistoryTable;


/**
 * Created by Li on 6/4/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
  private static final String DATABASE_NAME = "lexgodatabase.db";
  private static final int DATABASE_VERSION = 4;

  public DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
    SearchHistoryTable.onCreate(database);
    FavouriteCasesTable.onCreate(database);
    RecentCasesTable.onCreate(database);
  }

  @Override
  public void onUpgrade(SQLiteDatabase database, int oldVersion,
                        int newVersion) {
    SearchHistoryTable.onUpgrade(database, oldVersion, newVersion);
    FavouriteCasesTable.onUpgrade(database, oldVersion, newVersion);
    RecentCasesTable.onUpgrade(database, oldVersion, newVersion);
  }

}
