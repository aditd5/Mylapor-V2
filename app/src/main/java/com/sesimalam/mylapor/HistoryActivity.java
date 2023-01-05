package com.sesimalam.mylapor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import static com.sesimalam.mylapor.MyLapor.db;

import android.os.Bundle;
import android.util.Log;

import com.sesimalam.mylapor.activity.RecycleViewUserAdapter;
import com.sesimalam.mylapor.room.AppDatabase;
import com.sesimalam.mylapor.room.Laporan;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecycleViewUserAdapter recycleAdapter;
    List<Laporan> listLaporans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.recycleView);
        fetchDataFromRoom();
        initRecycleView();
        setAdapter();
    }
    private void fetchDataFromRoom() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "laporan").allowMainThreadQueries().build();
        listLaporans = db.userDao().getAll();

        for (int i = 0 ; i <listLaporans.size();i++){
            Log.e("Aplikasi", listLaporans.get(i).getNama()+i);
            Log.e("Aplikasi", listLaporans.get(i).getKerusakan()+i);
            Log.e("Aplikasi", listLaporans.get(i).getLokasi()+i);
            Log.e("Aplikasi", listLaporans.get(i).getCatatan()+i);
        }
        Log.e("cek list",""+listLaporans.size());
    }

    private void initRecycleView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recycleAdapter = new RecycleViewUserAdapter(this,listLaporans);
    }

    private void setAdapter() {
        recyclerView.setAdapter(recycleAdapter);
    }

}