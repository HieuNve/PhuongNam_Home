
package com.example.phuongnam_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main3Activity_HoaDon_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3__hoa_don__home);
    }

    public void ThemHoaDon(View view) {
        Intent intent = null;
        intent = new Intent(Main3Activity_HoaDon_Home.this,Main3Activity_ThemHoaDon.class);
        startActivity(intent);
    }

    public void XoaHoaDon(View view) {
        Intent intent = null;
        intent = new Intent(Main3Activity_HoaDon_Home.this,Main3Activity_XoaHoaDon.class);
        startActivity(intent);

    }

    public void SuaHoaDon(View view) {
        Intent intent = null;
        intent = new Intent(Main3Activity_HoaDon_Home.this,Main3Activity_SuaHoaDon.class);
        startActivity(intent);
    }

    public void TimHoaDon(View view) {
        Intent intent = null;
        intent = new Intent(Main3Activity_HoaDon_Home.this,Main3Activity_TimKiemHoaDon.class);
        startActivity(intent);
    }
}
