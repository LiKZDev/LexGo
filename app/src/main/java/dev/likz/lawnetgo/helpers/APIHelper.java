package dev.likz.lawnetgo.helpers;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class APIHelper {

  public String call(String uri, Map<String, String> params) {
    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String JSONStr = null;

    Uri builtUri = getURL(uri, params).build();

    try {
      URL url = new URL(builtUri.toString());
      urlConnection = (HttpURLConnection) url.openConnection();
      urlConnection.connect();

      // Read the input stream into a String
      InputStream inputStream = urlConnection.getInputStream();
      StringBuffer buffer = new StringBuffer();
      if (inputStream == null) {
        // Nothing to do.
        return null;
      }
      reader = new BufferedReader(new InputStreamReader(inputStream));

      String line;
      while ((line = reader.readLine()) != null) {
        buffer.append(line + "\n");
      }

      if (buffer.length() == 0) {
        return null;
      }

      JSONStr = buffer.toString();

      return JSONStr;
    } catch (MalformedURLException e) {
      Log.d("APIHelper", e.toString());
      e.printStackTrace();
    } catch (IOException e) {
      Log.d("APIHelper", e.toString());
      e.printStackTrace();
    } finally {
      if (urlConnection != null) {
        urlConnection.disconnect();
      }
      if (reader != null) {
        try {
          reader.close();
        } catch (final IOException e) {
        }
      }
    }

    Log.d("APIHelper", "success");
    return null;
  }

  public Uri.Builder getURL(String uri, Map<String, String> params) {
    Uri.Builder uriBuilder = Uri.parse(uri).buildUpon();
    if (params != null) {
      for (Map.Entry<String, String> entry : params.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
        uriBuilder.appendQueryParameter(key, value);
      }
    }
    return uriBuilder;
  }
}
