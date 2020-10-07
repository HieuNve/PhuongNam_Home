package com.example.phuongnam_home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import com.example.phuongnam_home.Database_PhuongNam.Control_Sach;
import com.example.phuongnam_home.Database_PhuongNam.TheLoai_DAO;
import com.example.phuongnam_home.Model.Sach;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main4Activity_TheSuaXoa_Sach extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    Control_Sach control_sach;
    ListView listView;
    List<String> Sachlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4__the_sua_xoa__sach);
        floatingActionButton = findViewById(R.id.floatingActionButton2);
        listView = findViewById(R.id.lv_sach);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Main4Activity_TheSuaXoa_Sach.this);
                dialog.setContentView(R.layout.dialog_them_sach);
                dialog.setCancelable(false);
                Button btnThem, btnHuy;
                final TextInputLayout tvMa, tvTen, tvDonGia, tvNXB, tvSL, tvNgayNhap, tvTL;
                btnThem = dialog.findViewById(R.id.btnThemSach);
                btnHuy = dialog.findViewById(R.id.btnHuySach);
                tvMa = dialog.findViewById(R.id.tvMa);
                tvTen = dialog.findViewById(R.id.tvTen);
                tvDonGia = dialog.findViewById(R.id.tvDonGia);
                tvNXB = dialog.findViewById(R.id.tvNXB);
                tvSL = dialog.findViewById(R.id.tvSL);
                tvNgayNhap = dialog.findViewById(R.id.tvNgayNhap);
                tvTL = dialog.findViewById(R.id.tvTL);

                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                Calendar calendar = Calendar.getInstance();
                final int y = calendar.get(Calendar.YEAR);
                final int m = calendar.get(Calendar.MONTH);
                final int d = calendar.get(Calendar.DAY_OF_MONTH);

                tvNgayNhap.getEditText().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog datePickerDialog = new DatePickerDialog(Main4Activity_TheSuaXoa_Sach.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                tvNgayNhap.getEditText().setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        }, y, m, d);
                        datePickerDialog.show();
                    }
                });



                btnThem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String maS = tvMa.getEditText().getText().toString().trim();
                        String TenS = tvTen.getEditText().getText().toString().trim();
                        String DonGia = tvDonGia.getEditText().getText().toString().trim();
                        String NXB = tvNXB.getEditText().getText().toString().trim();
                        String NgayNhap = tvNgayNhap.getEditText().getText().toString().trim();
                        String TheLoai = tvTL.getEditText().getText().toString().trim();
                        String soLuong = tvSL.getEditText().getText().toString().trim();

                        if (maS.equals("") || TenS.equals("") || DonGia.equals("") || NXB.equals("") || NgayNhap.equals("") || TheLoai.equals("") || soLuong.equals("")) {
                            Toast.makeText(Main4Activity_TheSuaXoa_Sach.this, "Bạn Không Được Để Trống", Toast.LENGTH_SHORT).show();

                        }else {
                            Pattern pattern = Pattern.compile(".*\\D.");
                            Matcher matcher = pattern.matcher(tvDonGia.getEditText().getText().toString());
                            if (matcher.matches()){
                                tvDonGia.setError("Bạn Phải Nhập Vào 1 Số");
                            }else {
                                tvDonGia.setError(null);
                            }
//                            Sach sach = new Sach();
//                            sach.setMaSach(maS);
//                            sach.setTenSach(TenS);
//                            sach.setGia(Double.valueOf(DonGia));
//                            sach.
                        }
                    }
                });

                dialog.show();
            }
        });
    }

//    public boolean isValuedateDecimalNumber(CharSequence e) {
//        return !TextUtils.isEmpty(e) && Patterns.EMAIL_ADDRESS.matcher(e).matches();// kieerm tra email
//    }
}
