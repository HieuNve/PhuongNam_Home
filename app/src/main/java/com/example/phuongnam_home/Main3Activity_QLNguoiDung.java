package com.example.phuongnam_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main3Activity_QLNguoiDung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3__them_nguoi_dung);
    }

    public void DoiMatKhau(View view) {
        Intent intent = null;
        intent = new Intent(Main3Activity_QLNguoiDung.this,Main3Activity_DoiMatKhau.class);
        startActivity(intent);
    }

    public void ChinhSuaTT(View view) {
        Intent intent = null;
        intent = new Intent(Main3Activity_QLNguoiDung.this,Main3Activity_SuaThongTin.class);
        startActivity(intent);
    }
}
