package com.example.rpl2016_12.logindata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListData extends AppCompatActivity {
        RecyclerView recyclerView;
        private Adapter adapter;
        private ArrayList<siswa> rvData;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_data);

            initDataset();

            recyclerView = findViewById(R.id.recyclerView);
              adapter = new Adapter(rvData);

             RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
             recyclerView.setLayoutManager(layoutManager);
             recyclerView.setAdapter(adapter);
            // get data online
            AndroidNetworking.get(BaseURL.url+"ambildata.php")
                    .setTag("test")
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // do anything with response
                            Log.d(" respondatabase","onResponse:"+response.toString());

                            rvData = new ArrayList<>();
                            try {
                                Log.d("hasiljson", "onResponse: "+response.toString());
                                JSONArray jsonArray = response.getJSONArray("result");
                                Log.d("hasiljson2", "onResponse: "+jsonArray.toString());
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    siswa siswa = new siswa(
                                            jsonObject.getString("No"),
                                            jsonObject.getString("Nama"),
                                            jsonObject.getString("Buku"),
                                            jsonObject.getString("KodePinjam"),
                                            jsonObject.getString("Petugas"),
                                            jsonObject.getString("Peminjaman"),
                                            jsonObject.getString("Pengembalian")
                                    );
                                    rvData.add(siswa);
                                }

                                adapter = new Adapter(rvData);
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListData.this);
                                recyclerView.setLayoutManager(layoutManager);
                                recyclerView.setAdapter(adapter);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            // hadle error

                        }
                    });
        }

        private void initDataset(){


//            siswa siswa1 = new siswa();
//            siswa1.setNama("Diyah");
//            siswa1.setKelas("12");
//            siswa1.setAlamat("Nalumsari");
//            rvData.add(siswa1);
//
//            siswa siswa2 = new siswa();
//            siswa2.setNama("Naela");
//            siswa2.setKelas("12");
//            siswa2.setAlamat("Sendang");
//            rvData.add(siswa2);
//
//            siswa siswa3 = new siswa();
//            siswa3.setNama("Meilisa");
//            siswa3.setKelas("12");
//            siswa3.setAlamat("Mijen");
//            rvData.add(siswa3);
        }
    }

