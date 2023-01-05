package com.sesimalam.mylapor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}