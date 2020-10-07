package com.example.phuongnam_home.Database_PhuongNam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.phuongnam_home.Model.TaiKhoan;
import com.example.phuongnam_home.Model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TheLoai_DAO {
    private SQlite_PhuongNam mysql;
    SQLiteDatabase db;
    Context context;

    public TheLoai_DAO(Context context) {
         this.context = context;
        this.mysql = new SQlite_PhuongNam(context);
        db = mysql.getWritableDatabase();
    }

    public boolean addTheLoai(TheLoai TheLoai) {
        //xin quyền
        ContentValues contentValues = new ContentValues();
        contentValues.put("maTheLoai", TheLoai.getMaTheLoai());
        contentValues.put("tenTheLoai", TheLoai.getTenTheLoai());

        long kq = db.insert("table_the_loai", null, contentValues);

        if (kq > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean updateTheLoai(TheLoai theLoai, String matheloai) {
        //xin quyền
        ContentValues contentValues = new ContentValues();
        contentValues.put("maTheLoai", theLoai.getMaTheLoai());
        contentValues.put("tenTheLoai", theLoai.getTenTheLoai());

        long kq = db.update("table_the_loai", contentValues, "maTheLoai=?", new String[]{matheloai});

        if (kq > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean DeteleUsername(TheLoai theLoai, String matheloai) {
        //xin quyền
        ContentValues contentValues = new ContentValues();
        contentValues.put("maTheLoai", theLoai.getMaTheLoai());
        contentValues.put("tenTheLoai", theLoai.getTenTheLoai());

        long kq = db.delete("table_the_loai", "maTheLoai=?", new String[]{matheloai});

        if (kq > 0) {
            return true;
        } else {
            return false;
        }

    }

    public List<String> getAlltheloai() {
        List<String> theLoais = new ArrayList<>();
        String sql = "SELECT * FROM table_the_loai";
        Cursor cursor = db.query("table_the_loai",null,null,null,null,null,null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String MaTheLoai = cursor.getString(0);
                String tehTheLoai = cursor.getString(1);
                theLoais.add(MaTheLoai + " : " + tehTheLoai);
                cursor.moveToNext();
            }
        }
        cursor.close();

        return theLoais;
    }


    public List<TheLoai> timKiemTL(String TimTL) {
        List<TheLoai> theLoaiList = new ArrayList<>();
        String sql = "SELECT * FROM table_the_loai WHERE maTheLoai LIKE '%" + TimTL + "%'";
        Cursor cursor = mysql.getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String MaTheLoai = cursor.getString(0);
                String tehTheLoai = cursor.getString(1);


                TheLoai theLoai = new TheLoai();
                theLoai.setMaTheLoai(MaTheLoai);
                theLoai.setTenTheLoai(tehTheLoai);
                theLoaiList.add(theLoai);
                cursor.moveToNext();
            }
        }

        return theLoaiList;
    }
}
