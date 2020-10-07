package com.example.phuongnam_home.Database_PhuongNam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQlite_PhuongNam extends SQLiteOpenHelper {

    public SQlite_PhuongNam(@Nullable Context context) {
        super(context, "mydata.sql", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String table_user = "CREATE TABLE table_user (Name TEXT NOT NULL, userName TEXT primary key, password TEXT NOT NULL, sdt TEXT NOT NULL, email TEXT NOT NULL, NgaySinh TEXT, GioiTinh TEXT NOT NULL)";
        String table_sach = "CREATE TABLE table_sach (maSach TEXT primary key, tenSach TEXT NOT NULL, soLuong INTEGER, gia FLOAT NOT NULL, theloai TEXT NOT NULL, tacgia TEXT NOT NULL, nhaxuatban TEXT NOT NULL, NgayNhap TEXT)";
        String table_the_loai = "CREATE TABLE table_the_loai (maTheLoai TEXT primary key, tenTheLoai TEXT)";
        String table_hoa_don = "CREATE TABLE table_hoa_don (maHoaDon TEXT primary key, ngayMua TEXT NOT NULL, KhachHang TEXT, NguoiTao TEXT, Sach TEXT, DonGia DOUBLE, SoLuong INTEGER, TongTien DOUBLE)";
        sqLiteDatabase.execSQL(table_user);
        sqLiteDatabase.execSQL(table_sach);
        sqLiteDatabase.execSQL(table_the_loai);
        sqLiteDatabase.execSQL(table_hoa_don);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "table_the_loai" );
    }
}
