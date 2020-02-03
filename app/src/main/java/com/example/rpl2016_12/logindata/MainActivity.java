package com.example.rpl2016_12.logindata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(getApplicationContext());
        final EditText Username = findViewById(R.id.username);
        final EditText Password = findViewById(R.id.password);
        final Button Login = findViewById(R.id.login);
        final TextView Register = findViewById(R.id.daftar);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AndroidNetworking.post("http://192.168.43.252/Diyah/login.php")
                        .addBodyParameter("username", Username.getText().toString())
                        .addBodyParameter("password", Password.getText().toString())
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d("suksess", "onResponse: " + response);
                                try {
                                    JSONObject hasil = response.getJSONObject("hasil");
                                    if (hasil.getBoolean("sukses")) {
                                        Toast.makeText(MainActivity.this, "sukses", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(getApplicationContext(), MainMenu.class);
                                        startActivity(i);
                                    } else {
                                        Toast.makeText(MainActivity.this, "Password atau username salah", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(MainActivity.this, "password atau username salah", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(ANError error) {
                                Log.d("errorr", "onResponse: " + error);
                                Toast.makeText(MainActivity.this, "eror", Toast.LENGTH_SHORT).show();
                            }
                        });
                Register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(MainActivity.this, Registrasi.class);
                        startActivity(i);
                    }
                });


            }


        });


    }
}