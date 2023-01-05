package com.sesimalam.mylapor;

import android.app.Application;

import androidx.room.Room;

import com.sesimalam.mylapor.room.AppDatabase;

public class MyLapor extends Application {

    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "laporan").allowMainThreadQueries().build();
    }
}
