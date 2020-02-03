package com.example.rpl2016_12.logindata;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private ArrayList<siswa> rvData;

    public Adapter(ArrayList<siswa> rvData) {
        this.rvData = rvData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.menetapkanSiswa(rvData.get(position));
    }

    @Override
    public int getItemCount() {
        return (rvData != null) ? rvData.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNama;
        public TextView tvBuku;
        public TextView tvKodePinjam;
        public TextView tvPetugas;
        public TextView tvPeminjaman;
        public TextView tvPengembalian;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = (TextView) itemView.findViewById(R.id.nama);
            tvBuku = (TextView) itemView.findViewById(R.id.buku);
            tvKodePinjam = (TextView) itemView.findViewById(R.id.kp);
            tvPetugas = (TextView) itemView.findViewById(R.id.petugas);
            tvPeminjaman= (TextView) itemView.findViewById(R.id.peminjaman);
            tvPengembalian = (TextView) itemView.findViewById(R.id.pengembalian);
        }

        public void menetapkanSiswa(siswa siswa){
            tvNama.setText(siswa.getNama());
            tvBuku.setText(siswa.getBuku());
            tvKodePinjam.setText(siswa.getKodePinjam());
            tvPetugas.setText(siswa.getPetugas());
            tvPeminjaman.setText(siswa.getPeminjaman());
            tvPengembalian.setText(siswa.getPengembalian());
        }
    }
}
