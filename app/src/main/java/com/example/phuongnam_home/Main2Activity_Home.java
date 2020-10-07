package com.example.phuongnam_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main2Activity_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__home);
    }


    public void QlySach(View view) {
        Intent intent = null;
        intent = new Intent(Main2Activity_Home.this,Main3Activity_QLySach_Home.class);
        startActivity(intent);
    }

    public void QlyTheLoai(View view) {
        Intent intent = null;
        intent = new Intent(Main2Activity_Home.this,Main2Activity_QLTheLoai.class);
        startActivity(intent);
    }

    public void QlyHoaDon(View view) {
        Intent intent = null;
        intent = new Intent(Main2Activity_Home.this,Main3Activity_HoaDon_Home.class);
        startActivity(intent);
    }

    public void ThongKe(View view) {
        Intent intent = null;
        intent = new Intent(Main2Activity_Home.this,Main3Activity_ThongKe.class);
        startActivity(intent);
    }

    public void QlySachBanChay(View view) {
        Intent intent = null;
        intent = new Intent(Main2Activity_Home.this,Main3Activity_ThongKeSachBanChay.class);
        startActivity(intent);
    }

    public void QlyTaiKhoan(View view) {
        Intent intent = null;
        intent = new Intent(Main2Activity_Home.this,Main3Activity_QLNguoiDung.class);
        startActivity(intent);
    }
}
