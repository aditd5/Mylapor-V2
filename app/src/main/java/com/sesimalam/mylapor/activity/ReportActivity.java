package com.sesimalam.mylapor.activity;

import androidx.appcompat.app.AppCompatActivity;

import static com.sesimalam.mylapor.MyLapor.db;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.sesimalam.mylapor.HistoryActivity;
import com.sesimalam.mylapor.HomeActivity;
import com.sesimalam.mylapor.R;
import com.sesimalam.mylapor.room.Laporan;

public class ReportActivity extends AppCompatActivity {

    private Button insertData;
    private ImageView btnBack;
    private EditText etNama;
    private EditText etKerusakan;
    private EditText etLokasi;
    private EditText etCatatan;
    Laporan laporan;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        insertData = findViewById(R.id.btnKirim);
        btnBack = findViewById(R.id.btnBack);
        etNama = findViewById(R.id.etNama);
        etKerusakan = findViewById(R.id.etKerusakan);
        etLokasi = findViewById(R.id.etLokasi);
        etCatatan = findViewById(R.id.etCatatan);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(ReportActivity.this, HomeActivity.class);
            startActivity(intent);
        });


        insertData.setOnClickListener(view -> {
            if
            (!etNama.getText().toString().isEmpty() && !etKerusakan.getText().toString().isEmpty()&&
                    !etLokasi.getText().toString().isEmpty()) {

                laporan = new Laporan();
                laporan.setNama(etNama.getText().toString());
                laporan.setKerusakan(etKerusakan.getText().toString());
                laporan.setLokasi(etLokasi.getText().toString());
                laporan.setCatatan(etCatatan.getText().toString());

                db.userDao().insertAll(laporan);

                Toast.makeText(getApplicationContext(), "Laporan Anda Telah Diterima",
                        Toast.LENGTH_SHORT).show();

                startActivity(new Intent(ReportActivity.this, HistoryActivity.class));
            } else {
                Toast.makeText(getApplicationContext(),"Mohon Isi Semua Data",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}