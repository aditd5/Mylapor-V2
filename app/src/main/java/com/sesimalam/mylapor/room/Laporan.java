package com.sesimalam.mylapor.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Laporan {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "nama")
    String nama;

    @ColumnInfo(name = "kerusakan")
    String kerusakan;

    @ColumnInfo(name = "lokasi")
    String lokasi;

    @ColumnInfo(name = "catatan")
    String catatan;

    @ColumnInfo(name = "email")
    String email;

    @ColumnInfo(name = "password")
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKerusakan() {
        return kerusakan;
    }

    public void setKerusakan(String kerusakan) {
        this.kerusakan = kerusakan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
