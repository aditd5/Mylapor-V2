package com.sesimalam.mylapor.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {
    private static PreferencesHelper INSTANCE;
    private SharedPreferences sharedPreferences;


    private PreferencesHelper(Context context) {
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences("com.sesimalam.mylapor", Context.MODE_PRIVATE);
    }

    public static PreferencesHelper getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new PreferencesHelper(context);
        }
        return INSTANCE;
    }

    public SharedPreferences preferences() {
        return sharedPreferences;
    }

    public void setLogin(boolean isLogin) {
        sharedPreferences.edit().putBoolean("isLogin", isLogin).apply();
    }

    public Boolean isLogin() {
        return sharedPreferences.getBoolean("isLogin", false);
    }

    public void setEmail(String email) {
        sharedPreferences.edit().putString("email", email).apply();
    }

    public String getEmail() {
        return sharedPreferences.getString("email", "example@example.com");
    }

    public void setPassword(String password) {
        sharedPreferences.edit().putString("password", password).apply();
    }

    public String getPassword() {
        return sharedPreferences.getString("password", "example@example.com");
    }

}
