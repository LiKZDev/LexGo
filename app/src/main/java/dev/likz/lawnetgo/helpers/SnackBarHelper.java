package dev.likz.lawnetgo.helpers;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class SnackBarHelper {

  View parentLayout;

  public SnackBarHelper(View parentLayout) {
    this.parentLayout = parentLayout;
  }

  public void showShortSnackBar(String message){
    Snackbar.make(parentLayout, message, Snackbar.LENGTH_SHORT)
            .show();
  }


}
