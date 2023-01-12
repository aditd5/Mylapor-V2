package com.sesimalam.mylapor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import static com.sesimalam.mylapor.MyLapor.db;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.sesimalam.mylapor.activity.RecycleViewUserAdapter;
import com.sesimalam.mylapor.activity.ReportActivity;
import com.sesimalam.mylapor.room.AppDatabase;
import com.sesimalam.mylapor.room.Laporan;
import com.sesimalam.mylapor.room.LaporanDao;
import com.sesimalam.mylapor.util.OnClickAdapterItem;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private ImageView btnback;
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

        btnback = findViewById(R.id.btnBack);

        btnback.setOnClickListener(view -> {
            Intent intent = new Intent(HistoryActivity.this, HomeActivity.class);
            startActivity(intent);
        });
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
        recycleAdapter.OnClickAdapterItem(new OnClickAdapterItem() {
            @Override
            public void clickItem(int id, int position) {
                new AlertDialog.Builder(HistoryActivity.this)
                        .setTitle("Hapus Data")
                        .setMessage("Anda yakin ingin menghapus data ini?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listLaporans.remove(position);
                                recycleAdapter.notifyItemChanged(position);
                                db.userDao().deleteUsers(db.userDao().findByID(id));
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(R.drawable.ic_baseline_delete_24)
                        .show();
            }
        });
    }

    private void setAdapter() {
        recyclerView.setAdapter(recycleAdapter);
    }

}