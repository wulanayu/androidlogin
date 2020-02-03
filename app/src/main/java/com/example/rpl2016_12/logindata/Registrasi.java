package com.example.rpl2016_12.logindata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Registrasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        final EditText username = findViewById(R.id.txtusername);
        final EditText password = findViewById(R.id.txtpassword);
        final Button Login = findViewById(R.id.btnlogin);
        final TextView Register = findViewById(R.id.daftar);

                    Login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AndroidNetworking.post("http://192.168.6.96/Diyah/insertdata.php")
                                    .addBodyParameter("username", username.getText().toString())
                                    .addBodyParameter("password", password.getText().toString())
                                    .setTag("test")
                                    .setPriority(Priority.MEDIUM)
                                    .build()
                                    .getAsJSONObject(new JSONObjectRequestListener() {
                                        @Override
                                        public void onResponse(JSONObject response) {
                                            try {
                                                JSONObject hasil = response.getJSONObject("hasil");
                                                boolean respon = hasil.getBoolean("respon");
                                                if (respon) {
                                                    Toast.makeText(getApplicationContext(), "sukses daftar", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_LONG).show();
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }

                                        }

                                        @Override
                                        public void onError(ANError anError) {
                                            Toast.makeText(getApplicationContext(), "server eror", Toast.LENGTH_LONG).show();

                                        }
                                    });
                        }
                    });

                }
            }