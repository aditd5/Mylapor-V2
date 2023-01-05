package com.sesimalam.mylapor.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Laporan.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LaporanDao userDao();
}
