package com.sesimalam.mylapor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.sesimalam.mylapor.util.PreferencesHelper;

public class SplashScreenActivity extends AppCompatActivity {
    public static final String TAG = "SplashScreen";

    PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        preferencesHelper = PreferencesHelper.getINSTANCE(getApplicationContext());
        int splashInterval = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!preferencesHelper.isLogin()) {
                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SplashScreenActivity.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    Toast.makeText(getApplicationContext(), "Selamat Datang",
                            Toast.LENGTH_SHORT).show();

                    startActivity(intent);
                }
            }
        }, splashInterval);
    }


    @Override
    protected void onStart() {

        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}