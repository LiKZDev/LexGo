package dev.likz.lawnetgo.databases.tables;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import dev.likz.lawnetgo.databases.dao.DAOManager;

public class SearchHistoryTable {
    public static final String TABLE_SEARCH_HISTORY = "search_table";
    public static final String COLUMN_ID = "searchId";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_SEARCH_HISTORY
            + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_NAME + ","
            + COLUMN_DESCRIPTION + ");";

    public static void onCreate(SQLiteDatabase database) {
        Log.d(DAOManager.LOG_TAG, "Search History Creating db");
        database.execSQL(DATABASE_CREATE);
        Log.d(DAOManager.LOG_TAG, "Search History Success");
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DAOManager.LOG_TAG,
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SEARCH_HISTORY);
        onCreate(db);
    }

}