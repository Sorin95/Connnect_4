package com.example.Connnect4;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;


public class Menu extends Fragment implements View.OnClickListener {

    TextView name, mail;
    Button logout;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mview = inflater.inflate(R.layout.menu_view, container, false);

        logout = (Button)mview.findViewById(R.id.log_out_button);
        name = mview.findViewById(R.id.name);
        mail = mview.findViewById(R.id.mail);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(getContext());
        if(signInAccount != null)
        {
            name.setText(signInAccount.getDisplayName());
            mail.setText(signInAccount.getEmail());
        }


        logout.setOnClickListener(this);

        return mview;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.log_out_button:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(),Menu.class);
                startActivity(intent);
                break;
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu.this)
                        .navigate(R.id.action_Menu_to_Game);
            }
        });
    }
}