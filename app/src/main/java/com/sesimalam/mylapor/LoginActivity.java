package com.sesimalam.mylapor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sesimalam.mylapor.util.PreferencesHelper;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText etEmail;
    private EditText etPassword;
    PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferencesHelper = PreferencesHelper.getINSTANCE(getApplicationContext());

        btnLogin = findViewById(R.id.btnLogin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(view -> {
            preferencesHelper.setLogin(true);
            preferencesHelper.setEmail(etEmail.getText().toString());
            preferencesHelper.setPassword(etPassword.getText().toString());

            if (!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                Toast.makeText(getApplicationContext(),"Selamat Datang",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),"Mohon Masukkan Email & Password Anda",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}