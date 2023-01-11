package com.sesimalam.mylapor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.sesimalam.mylapor.util.PreferencesHelper;

public class ProfileActivity extends AppCompatActivity {

    private Button btnLogout;
    PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        preferencesHelper=PreferencesHelper.getINSTANCE(getApplicationContext());

        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(view -> {
            preferencesHelper.setLogin(false);
            startActivity(new Intent(ProfileActivity.this, LoginActivity.class));

            Toast.makeText(getApplicationContext(),"Anda telah Logout",
                    Toast.LENGTH_SHORT).show();
        });
    }
}