package com.example.phuongnam_home.Model;

public class TaiKhoan {
    private  String TenNguoiDubg;
    private String UseName;
    private String PassWord;
    private String SoDienThoai;
    private String NgaySinh;
    private  String GioiTinh;
    private String Email;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenNguoiDubg, String useName, String passWord, String soDienThoai, String ngaySinh, String gioiTinh, String email) {
        TenNguoiDubg = tenNguoiDubg;
        UseName = useName;
        PassWord = passWord;
        SoDienThoai = soDienThoai;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        Email = email;
    }

    public String getTenNguoiDubg() {
        return TenNguoiDubg;
    }

    public void setTenNguoiDubg(String tenNguoiDubg) {
        TenNguoiDubg = tenNguoiDubg;
    }

    public String getUseName() {
        return UseName;
    }

    public void setUseName(String useName) {
        UseName = useName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
