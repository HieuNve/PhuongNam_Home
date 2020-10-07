package com.example.phuongnam_home.Database_PhuongNam;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.phuongnam_home.Model.HoaDon;
import com.example.phuongnam_home.Model.TaiKhoan;

import java.util.ArrayList;
import java.util.List;

public class HoaDon_DAO {
    private SQlite_PhuongNam mysql;
    SQLiteDatabase db;

    public HoaDon_DAO(SQlite_PhuongNam mysql, SQLiteDatabase db) {
        this.mysql = mysql;
        this.db = db;
    }

    public boolean addHD(HoaDon hoaDon) {
        //xin quyền
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHoaDon", hoaDon.getMaHoaDon());
        contentValues.put("ngayMua", hoaDon.getNgaytao());
        contentValues.put("KhachHang", hoaDon.getIdKhachhang());
        contentValues.put("NguoiTao", hoaDon.getIdNguoiTao());
        contentValues.put("Sach", hoaDon.getTenSach());
        contentValues.put("DonGia", hoaDon.getDonGia());
        contentValues.put("SoLuong", hoaDon.getSoLuong());
        contentValues.put("TongTien", hoaDon.getTongTien());

        long kq = db.insert("table_hoa_don", null, contentValues);

        if (kq > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean updateHD(HoaDon hoaDon, String maHD) {
        //xin quyền
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHoaDon", hoaDon.getMaHoaDon());
        contentValues.put("ngayMua", hoaDon.getNgaytao());
        contentValues.put("KhachHang", hoaDon.getIdKhachhang());
        contentValues.put("NguoiTao", hoaDon.getIdNguoiTao());
        contentValues.put("Sach", hoaDon.getTenSach());
        contentValues.put("DonGia", hoaDon.getDonGia());
        contentValues.put("SoLuong", hoaDon.getSoLuong());
        contentValues.put("TongTien", hoaDon.getTongTien());

        long kq = db.update("table_hoa_don", contentValues, "maHoaDon=?", new String[]{maHD});

        if (kq > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean deteleHD(HoaDon hoaDon, String maHD) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHoaDon", hoaDon.getMaHoaDon());
        contentValues.put("ngayMua", hoaDon.getNgaytao());
        contentValues.put("KhachHang", hoaDon.getIdKhachhang());
        contentValues.put("NguoiTao", hoaDon.getIdNguoiTao());
        contentValues.put("Sach", hoaDon.getTenSach());
        contentValues.put("DonGia", hoaDon.getDonGia());
        contentValues.put("SoLuong", hoaDon.getSoLuong());
        contentValues.put("TongTien", hoaDon.getTongTien());

        long kq = db.delete("table_hoa_don", "maHoaDon=?", new String[]{maHD});

        if (kq > 0) {
            return true;
        } else {
            return false;
        }

    }

    public List<HoaDon> getAllHD() {
        List<HoaDon> Hoadonlist = new ArrayList<>();
        String sql = "SELECT * FROM table_hoa_don";
        Cursor cursor = mysql.getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String maHoaDon = cursor.getString(0);
                String NgayMua = cursor.getString(1);
                String KhachHang = cursor.getString(2);
                String NguoiTao = cursor.getString(3);
                String sach = cursor.getString(4);
                double donGia = cursor.getDouble(5);
                int SoLuong = cursor.getInt(6);
                double TongTien = cursor.getDouble(7);


                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(maHoaDon);
                hoaDon.setIdKhachhang(KhachHang);
                hoaDon.setNgaytao(NgayMua);
                hoaDon.setIdNguoiTao(NguoiTao);
                hoaDon.setTenSach(sach);
                hoaDon.setDonGia(donGia);
                hoaDon.setSoLuong(SoLuong);
                hoaDon.setTongTien(TongTien);
                Hoadonlist.add(hoaDon);
                cursor.moveToNext();
            }
        }

        return Hoadonlist;
    }


    public List<HoaDon> timKiemUsername(String TimHD) {
        List<HoaDon> Hoadonlist = new ArrayList<>();
        String sql = "SELECT * FROM table_hoa_don WHERE maHoaDon LIKE '%" + TimHD + "%'";
        Cursor cursor = mysql.getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String maHoaDon = cursor.getString(0);
                String NgayMua = cursor.getString(1);
                String KhachHang = cursor.getString(2);
                String NguoiTao = cursor.getString(3);
                String sach = cursor.getString(4);
                double donGia = cursor.getDouble(5);
                int SoLuong = cursor.getInt(6);
                double TongTien = cursor.getDouble(7);


                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(maHoaDon);
                hoaDon.setIdKhachhang(KhachHang);
                hoaDon.setNgaytao(NgayMua);
                hoaDon.setIdNguoiTao(NguoiTao);
                hoaDon.setTenSach(sach);
                hoaDon.setDonGia(donGia);
                hoaDon.setSoLuong(SoLuong);
                hoaDon.setTongTien(TongTien);

                Hoadonlist.add(hoaDon);
                cursor.moveToNext();
            }
        }

        return Hoadonlist;
    }
}
