package com.sesimalam.mylapor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.sesimalam.mylapor.activity.ReportActivity;

public class HomeActivity extends AppCompatActivity {

    private CardView cvLaporan, cvHistory;
    private ImageView profile;
    private TextView tvProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cvLaporan = findViewById(R.id.cvLaporan);
        cvHistory = findViewById(R.id.cvHistory);
        profile = findViewById(R.id.profile);
        tvProfile = findViewById(R.id.tvProfile);

        cvLaporan.setOnClickListener(view -> {
            Intent homeIntent = new Intent(HomeActivity.this, ReportActivity.class);
            startActivity(homeIntent);
        });

        cvHistory.setOnClickListener(view -> {
            Intent homeIntent = new Intent(HomeActivity.this, HistoryActivity.class);
            startActivity(homeIntent);
        });

        profile.setOnClickListener(view -> {
            Intent homeIntent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(homeIntent);
        });

        tvProfile.setOnClickListener(view -> {
            Intent homeIntent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(homeIntent);
        });
    }
}