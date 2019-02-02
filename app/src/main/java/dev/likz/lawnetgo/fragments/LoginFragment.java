package dev.likz.lawnetgo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import dev.likz.lawnetgo.MainActivity;
import dev.likz.lawnetgo.R;
import dev.likz.lawnetgo.entities.User;

public class LoginFragment extends Fragment {
  View rootView;
  TextInputEditText usernameEditText;
  TextInputEditText passewordEditText;
  MaterialButton loginButton;

  public LoginFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    rootView = inflater.inflate(R.layout.fragment_login, container, false);

    usernameEditText = rootView.findViewById(R.id.username);
    passewordEditText = rootView.findViewById(R.id.password);
    loginButton = rootView.findViewById(R.id.loginButton);

    loginButton.setOnClickListener(v -> {
      MainActivity.loggedInUser = new User(usernameEditText.getText().toString(), "", "Company1", "Department1", "Team2");
      ((MainActivity) getActivity()).redirectToFragment(new FavouritesFragment(),
              String.valueOf(MainActivity.FRAGMENT_FAVOURITES));
    });

    return rootView;
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override
  public void onDetach() {
    super.onDetach();
  }
}
