package com.example.phuongnam_home.Model;

public class Sach {

    private  String MaSach;
    private String TenSach;
    private int SoLuong;
    private String NgayNhap;
    private double Gia;
    private  String NhaXuatBan;
    private String TheLoai;
    private String TacGia;


    public Sach() {
    }

    public Sach(String maSach, String tenSach, int soLuong, String ngayNhap, double gia, String nhaXuatBan, String theLoai, String tacGia) {
        MaSach = maSach;
        TenSach = tenSach;
        SoLuong = soLuong;
        NgayNhap = ngayNhap;
        Gia = gia;
        NhaXuatBan = nhaXuatBan;
        TheLoai = theLoai;
        TacGia = tacGia;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String tacGia) {
        TacGia = tacGia;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String maSach) {
        MaSach = maSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        NgayNhap = ngayNhap;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double gia) {
        Gia = gia;
    }

    public String getNhaXuatBan() {
        return NhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        NhaXuatBan = nhaXuatBan;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }
}
