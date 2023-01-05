package com.sesimalam.mylapor.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LaporanDao {

    @Query("SELECT * FROM laporan")
    List<Laporan> getAll();

    @Insert
    void insertAll(Laporan laporan);

    @Delete
    public void deleteUsers(Laporan users);

    @Update
    public void update(Laporan laporan);

    @Delete
    public void deleteAll(Laporan user1, Laporan user2);
}
