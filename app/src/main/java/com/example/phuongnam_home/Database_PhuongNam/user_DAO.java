package com.example.phuongnam_home.Database_PhuongNam;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;

import com.example.phuongnam_home.Model.TaiKhoan;

public class user_DAO {
    private SQlite_PhuongNam mysql;
    SQLiteDatabase db;

    public user_DAO(SQlite_PhuongNam mysql) {
        this.mysql = mysql;
        db = mysql.getWritableDatabase();
    }

    public boolean addUser(TaiKhoan taiKhoan) {
        //xin quyền
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", taiKhoan.getUseName());
        contentValues.put("Name", taiKhoan.getTenNguoiDubg());
        contentValues.put("password", taiKhoan.getPassWord());
        contentValues.put("sdt", taiKhoan.getSoDienThoai());
        contentValues.put("email", taiKhoan.getEmail());
        contentValues.put("NgaySinh", taiKhoan.getNgaySinh());
        contentValues.put("GioiTinh", taiKhoan.getGioiTinh());

        long kq = db.insert("table_user", null, contentValues);

        if (kq > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean updateUserName(TaiKhoan taiKhoan, String userName) {
        //xin quyền
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", taiKhoan.getUseName());
        contentValues.put("Name", taiKhoan.getTenNguoiDubg());
        contentValues.put("password", taiKhoan.getPassWord());
        contentValues.put("sdt", taiKhoan.getSoDienThoai());
        contentValues.put("email", taiKhoan.getEmail());
        contentValues.put("NgaySinh", taiKhoan.getNgaySinh());
        contentValues.put("GioiTinh", taiKhoan.getGioiTinh());

        long kq = db.update("table_user", contentValues, "userName=?", new String[]{userName});

        if (kq > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean DeteleUsername(TaiKhoan taiKhoan, String userName) {
        //xin quyền
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", taiKhoan.getUseName());
        contentValues.put("Name", taiKhoan.getTenNguoiDubg());
        contentValues.put("password", taiKhoan.getPassWord());
        contentValues.put("sdt", taiKhoan.getSoDienThoai());
        contentValues.put("email", taiKhoan.getEmail());
        contentValues.put("NgaySinh", taiKhoan.getNgaySinh());
        contentValues.put("GioiTinh", taiKhoan.getGioiTinh());

        long kq = db.delete("table_user", "userName=?", new String[]{userName});

        if (kq > 0) {
            return true;
        } else {
            return false;
        }

    }

    public List<TaiKhoan> getAllUsers() {
        List<TaiKhoan> nguoiDungList = new ArrayList<>();
        String sql = "SELECT * FROM table_user";
        Cursor cursor = mysql.getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(0);
                String username = cursor.getString(1);
                String password = cursor.getString(2);
                String std = cursor.getString(3);
                String email = cursor.getString(4);
                String ngaysinh = cursor.getString(5);
                String GioiTinh = cursor.getString(6);


                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setUseName(username);
                taiKhoan.setTenNguoiDubg(name);
                taiKhoan.setPassWord(password);
                taiKhoan.setSoDienThoai(std);
                taiKhoan.setEmail(email);
                taiKhoan.setNgaySinh(ngaysinh);
                taiKhoan.setGioiTinh(GioiTinh);

                nguoiDungList.add(taiKhoan);
                cursor.moveToNext();
            }
        }

        return nguoiDungList;
    }


    public List<TaiKhoan> timKiemUsername(String TimUsername) {
        List<TaiKhoan> nguoiDungList = new ArrayList<>();
        String sql = "SELECT * FROM USER WHERE userName LIKE '%" + TimUsername + "%'";
        Cursor cursor = mysql.getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(0);
                String username = cursor.getString(1);
                String password = cursor.getString(2);
                String std = cursor.getString(3);
                String email = cursor.getString(4);
                String ngaysinh = cursor.getString(5);
                String GioiTinh = cursor.getString(6);


                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setUseName(username);
                taiKhoan.setTenNguoiDubg(name);
                taiKhoan.setPassWord(password);
                taiKhoan.setSoDienThoai(std);
                taiKhoan.setEmail(email);
                taiKhoan.setNgaySinh(ngaysinh);
                taiKhoan.setGioiTinh(GioiTinh);

                nguoiDungList.add(taiKhoan);
                cursor.moveToNext();
            }
        }

        return nguoiDungList;
    }

    //thêm


    //sưa


    //xoa


    //getall
}
