package com.example.aplikasi2.loginbstk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasi2.Model.Globals;
import com.example.aplikasi2.Model.UserNew;
import com.example.aplikasi2.R;
import com.example.aplikasi2.homebstk.MenuUtama;
//import com.example.aplikasi2.utils.SessionManager;


import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ApiInterface apiservice;
    private  static final String TAG = "MainActivity";

    EditText input_username;
    EditText input_password;
    Button btn_Login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        input_username = (EditText) findViewById(R.id.input_username);
        input_password = (EditText) findViewById(R.id.input_password);
        btn_Login = (Button)findViewById(R.id.btn_login);

        apiservice = ApiClient.getClient().create(ApiInterface.class);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginUser();

            }
        });
    }

    private void loginUser(){
        String username = input_username.getText().toString();
        String password = input_password.getText().toString();

        UserNew user = new UserNew();
        user.User_Name = username;
        user.Password = password;

        apiservice.MainRequest(username,password).enqueue(new Callback<ResponLogin>() {
            @Override
            public void onResponse(Call<ResponLogin> call, Response<ResponLogin> response) {

                String stat = response.body().getStatus();
                if (stat.equals("Success")) {
//                    Intent intent = new Intent(MainActivity.this, MenuUtama.class);
                    Intent intent = new Intent(MainActivity.this, MenuUtama.class);
                    startActivity(intent);
                    Globals g = (Globals)getApplication();
                    g.setUser_Name(username);
                    g.setUser_ID(response.body().getValue());
                    finish();

                } else if (stat.equals("Error")) {
                    Toast.makeText(MainActivity.this, "Username/Password tidak sesuai", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponLogin> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getLocalizedMessage());
                //Toast.makeText(MainActivity.this,"Gagal Terhubung ke server", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}

