package com.example.phuongnam_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main3Activity_QLySach_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3__q_ly_sach__home);
    }


    public void ThemSach(View view) {
        Intent intent = null;
        intent = new Intent(Main3Activity_QLySach_Home.this,Main4Activity_TheSuaXoa_Sach.class);
        startActivity(intent);
    }

    public void TimKiemSach(View view) {
        Intent intent = null;
        intent = new Intent(Main3Activity_QLySach_Home.this,Main3Activity_TimKiemSach.class);
        startActivity(intent);
    }


}
