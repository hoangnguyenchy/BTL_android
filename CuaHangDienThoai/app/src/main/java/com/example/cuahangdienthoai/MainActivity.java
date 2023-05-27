package com.example.cuahangdienthoai;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cuahangdienthoai.Activity.DangNhapActivity;
import com.example.cuahangdienthoai.Models.SanPham;

import javax.security.auth.callback.Callback;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(getApplicationContext(), DangNhapActivity.class));
        finish();
    }
}