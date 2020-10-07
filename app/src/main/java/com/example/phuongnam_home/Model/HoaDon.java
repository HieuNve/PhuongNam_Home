package com.example.phuongnam_home.Model;

public class HoaDon {
    private  String MaHoaDon;
    private String idKhachhang;
    private String idNguoiTao;
    private String Ngaytao;
    private String tenSach;
    private  double DonGia;
    private int SoLuong;
    private double tongTien;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String idKhachhang, String idNguoiTao, String ngaytao, String tenSach, double donGia, int soLuong, double tongTien) {
        MaHoaDon = maHoaDon;
        this.idKhachhang = idKhachhang;
        this.idNguoiTao = idNguoiTao;
        Ngaytao = ngaytao;
        this.tenSach = tenSach;
        DonGia = donGia;
        SoLuong = soLuong;
        this.tongTien = tongTien;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        MaHoaDon = maHoaDon;
    }

    public String getIdKhachhang() {
        return idKhachhang;
    }

    public void setIdKhachhang(String idKhachhang) {
        this.idKhachhang = idKhachhang;
    }

    public String getIdNguoiTao() {
        return idNguoiTao;
    }

    public void setIdNguoiTao(String idNguoiTao) {
        this.idNguoiTao = idNguoiTao;
    }

    public String getNgaytao() {
        return Ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        Ngaytao = ngaytao;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double donGia) {
        DonGia = donGia;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getSoLuong() {
        return SoLuong;
    }


    public double getTongTien() {
        return tongTien;
    }

}
