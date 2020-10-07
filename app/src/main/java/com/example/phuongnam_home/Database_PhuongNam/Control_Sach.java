package com.example.phuongnam_home.Database_PhuongNam;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import com.example.phuongnam_home.Model.Sach;
import java.util.ArrayList;
import java.util.List;

public class Control_Sach {
    private SQlite_PhuongNam mySql;
    SQLiteDatabase db;

    public Control_Sach() {
        this.mySql = mySql;
        db = mySql.getWritableDatabase();
    }


    public void insert(Sach sach) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("maSach", sach.getMaSach());
        contentValues.put("tenSach", sach.getTenSach());
        contentValues.put("soLuong", sach.getSoLuong());
        contentValues.put("gia", sach.getGia());
        contentValues.put("theLoai", sach.getTheLoai());
        contentValues.put("nxb", sach.getNhaXuatBan());
        contentValues.put("NgayNhap", sach.getNgayNhap());
        db.insert("table_sach", null, contentValues);
    }

    public List<Sach> getData() {
        List<Sach> sachList = new ArrayList<>();
        Cursor cursor = db.query("table_sach", null, null, null, null, null, null);
        String ma, ten, theLoai,nxb,ngayNhap;
        double gia;
        int soLuong;
        while (cursor.moveToNext()) {
            ma = cursor.getString(cursor.getColumnIndex("maSach"));
            ten = cursor.getString(cursor.getColumnIndex("tenSach"));
            soLuong = cursor.getInt(cursor.getColumnIndex("soLuong"));
            gia = cursor.getDouble(cursor.getColumnIndex("gia"));
            theLoai = cursor.getString(cursor.getColumnIndex("theloai"));
            nxb = cursor.getString(cursor.getColumnIndex("nhaxuatban"));
            ngayNhap = cursor.getString(cursor.getColumnIndex("NgayNhap"));
            sachList.add(new Sach(ma,ten,soLuong,ngayNhap,gia,nxb,theLoai));
        }
        cursor.close();
        return sachList;
    }

    public void delete(String maSach){
        db.delete("table_sach","maSach=?",new String[]{maSach});
    }

    public void update(Sach sach,String maSach){
        ContentValues values = new ContentValues();
        values.put("maSach",sach.getMaSach());
        values.put("tenSach",sach.getTenSach());
        values.put("soLuong",sach.getSoLuong());
        values.put("gia",sach.getGia());
        values.put("theloai",sach.getTheLoai());
        values.put("nxb", sach.getNhaXuatBan());
        values.put("NgayNhap" ,sach.getNgayNhap());
        db.update("table_sach",values,"maSach=?",new String[]{maSach});

    }

    public void updateTheLoai(String maSach,String theLoaiMoi){
        ContentValues values = new ContentValues();
        values.put("theloai",theLoaiMoi);
        db.update("table_sach",values,"maSach=?",new String[]{maSach});
    }
}
