package com.sesimalam.mylapor.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sesimalam.mylapor.R;
import com.sesimalam.mylapor.room.Laporan;

import java.util.List;

public class RecycleViewUserAdapter extends RecyclerView.Adapter<RecycleViewUserAdapter.MyViewHolder> {
    private Context mContext;
    private List<Laporan> myList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNama;
        public TextView tvKerusakan;
        public TextView tvLokasi;
        public TextView tvCatatan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvKerusakan = itemView.findViewById(R.id.tvKerusakan);
            tvLokasi = itemView.findViewById(R.id.tvLokasi);
            tvCatatan = itemView.findViewById(R.id.tvCatatan);
        }
    }

    public RecycleViewUserAdapter(Context mContext, List<Laporan> albumList) {
        this.mContext = mContext;
        this.myList = albumList;
    }


    @NonNull
    @Override
    public RecycleViewUserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_history, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Laporan album = myList.get(i);
        myViewHolder.tvNama.setText(album.getNama());
        myViewHolder.tvKerusakan.setText(album.getKerusakan());
        myViewHolder.tvLokasi.setText(album.getLokasi());
        myViewHolder.tvCatatan.setText(album.getCatatan());

    }

    @Override
    public int getItemCount() {

        return myList.size();
    }
}
