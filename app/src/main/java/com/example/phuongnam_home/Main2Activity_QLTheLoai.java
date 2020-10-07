package com.example.phuongnam_home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.phuongnam_home.Database_PhuongNam.SQlite_PhuongNam;
import com.example.phuongnam_home.Database_PhuongNam.TheLoai_DAO;
import com.example.phuongnam_home.Model.TheLoai;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Main2Activity_QLTheLoai extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    TheLoai_DAO theLoai_dao;
    ListView listView;
    List<String> theloaiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__q_l_the_loai);
        floatingActionButton = findViewById(R.id.floatingActionButton1);
        listView = findViewById(R.id.lvTL);
        theLoai_dao = new TheLoai_DAO(Main2Activity_QLTheLoai.this);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Main2Activity_QLTheLoai.this);
                dialog.setContentView(R.layout.dialog_add);
                dialog.setCancelable(false);
                final EditText edtMaTL, edtTenTL;
                Button btnThoat, btnThem;
                edtMaTL = dialog.findViewById(R.id.txt_MaTL);
                edtTenTL = dialog.findViewById(R.id.txt_TenTL);
                btnThem = dialog.findViewById(R.id.btnThem);
                btnThoat = dialog.findViewById(R.id.btnThoat);
                btnThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                btnThem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String maTheLoai = edtMaTL.getText().toString().trim();
                        String TenTheLoai = edtTenTL.getText().toString().trim();
                        if (maTheLoai.equals("") || TenTheLoai.equals("")) {
                            Toast.makeText(Main2Activity_QLTheLoai.this, "Bạn Không Được Để Trống", Toast.LENGTH_SHORT).show();

                        } else {
                            TheLoai theLoai = new TheLoai();
                            theLoai.setMaTheLoai(maTheLoai);
                            theLoai.setTenTheLoai(TenTheLoai);
                            theLoai_dao.addTheLoai(theLoai);
                            theloaiList = theLoai_dao.getAlltheloai();
                            ArrayAdapter adapter = new ArrayAdapter(Main2Activity_QLTheLoai.this, android.R.layout.simple_expandable_list_item_1, theloaiList);
                            listView.setAdapter(adapter);
                        }
                    }
                });
                dialog.show();
            }
        });
        theloaiList = theLoai_dao.getAlltheloai();
        ArrayAdapter adapter = new ArrayAdapter(Main2Activity_QLTheLoai.this, android.R.layout.simple_expandable_list_item_1, theloaiList);
        listView.setAdapter(adapter);

    }
}
