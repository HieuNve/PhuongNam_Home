package com.example.phuongnam_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity_DangNhap extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DangNhap(View view) {
        Intent intent = null;
          intent = new Intent(MainActivity_DangNhap.this,Main2Activity_Home.class);
        startActivity(intent);
    }

    public void DangKy(View view) {
        Intent intent = null;
        intent = new Intent(MainActivity_DangNhap.this,Main2Activity_DangKy.class);
        startActivity(intent);
    }
}
