package com.sesimalam.mylapor.room;

import androidx.lifecycle.LiveData;
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

    @Query("SELECT * FROM laporan")
    LiveData<List<Laporan>> dataLaporan();

    @Query("SELECT * FROM laporan WHERE id LIKE :laporanID LIMIT 1")
    Laporan findByID(int laporanID);

   // @Query("SELECT * FROM laporan WHERE email LIKE :email ")
   // Laporan findByName(String email);

  //  @Query("SELECT * FROM laporan WHERE password LIKE :password ")
   // Laporan findByName(String password);

    @Insert
    void insertAll(Laporan laporan);

    @Delete
    public void deleteUsers(Laporan users);

    @Update
    public void update(Laporan laporan);

    @Delete
    public void deleteAll(Laporan user1, Laporan user2);
}
