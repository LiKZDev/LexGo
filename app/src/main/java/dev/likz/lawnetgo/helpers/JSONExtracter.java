package dev.likz.lawnetgo.helpers;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.amitshekhar.DebugDB;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import dev.likz.lawnetgo.databases.dao.FavouriteCaseDAO;
import dev.likz.lawnetgo.entities.Case;
import dev.likz.lawnetgo.entities.CaseContent;

public class JSONExtracter {

  public void extractData(Context context) {
    Gson gson = new Gson();
    FavouriteCaseDAO dao = new FavouriteCaseDAO(context);

//    writeToFile("ABC", context);
//    List<Case> caseList = dao.getAllRecords();
//    Log.d("JSONExtrator", "Size is " + caseList.size());

//    for (int i = 1; i < 1693; i++) {
//      String fileName = String.format("json%s.txt", i);
//      Case caseInfo = gson.fromJson(readFromFile(context, fileName), new TypeToken<Case>() {
//      }.getType());
////
////    Log.d("JsonExtrator", "IP Address is " + DebugDB.getAddressLog());
//      dao.createFavouriteRecord(caseInfo);
//    }

//    List<Case> caseList2 = dao.getAllRecords();
//    Log.d("JSONExtrator", "Size is " + caseList2.size());

//    String sample = "{\"title\":\"Grounds of Decision\", \"content\": \"\"}";
//    gson.fromJson(sample, new TypeToken<CaseContent>() {
//    }.getType());

//
//
//    Log.d("JSONExtrator", "=====================");
//    Log.d("JSONExtrator", caseInfo.toString());

  }

  private void writeToFile(String data, Context context) {
    String content = "hello world fasjhfdksj ahdfsjkah fdsjaklhfd kaljshfdkjlsah dfasjklhfd asjkhfdlkajh asdf";
    File file;
    FileOutputStream outputStream;

    try {//      Log.d("JSONExtrator", ">>>>>" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath());
      file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/lawnet/", "LAWNETFILE.txt");

      outputStream = new FileOutputStream(file);
      outputStream.write(content.getBytes());
      outputStream.close();
    } catch (IOException e) {
//      Log.d("JSONExtrator", e.toString());
      e.printStackTrace();
    }
  }

  private String readFromFile(Context context, String fileName) {
    String ret = "";

    try {
      File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/lawnet/case_JSON_backup/", fileName);

      BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
      String line;
      StringBuffer buffer = new StringBuffer();
      while ((line = input.readLine()) != null) {
        buffer.append(line);
      }

      ret = buffer.toString();
//      Log.d("JSONExtrator", buffer.toString());
    } catch (IOException e) {
      Log.d("JSONExtrator", e.toString());
      e.printStackTrace();
    }

    return ret;
  }

}
