package com.example.phuongnam_home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.phuongnam_home.Database_PhuongNam.Control_Sach;
import com.example.phuongnam_home.Database_PhuongNam.TheLoai_DAO;
import com.example.phuongnam_home.Model.Sach;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main4Activity_TheSuaXoa_Sach extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    FloatingActionButton floatingActionButton;
    Control_Sach control_sach;
    TheLoai_DAO theLoai_dao;
    ListView listView;
    List<Sach> Sachlist;
    List<String> TLList;
    String TheLoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4__the_sua_xoa__sach);
        floatingActionButton = findViewById(R.id.floatingActionButton2);
        listView = findViewById(R.id.lv_sach);
        Sachlist = new ArrayList<>();
        control_sach = new Control_Sach(Main4Activity_TheSuaXoa_Sach.this);
        theLoai_dao = new TheLoai_DAO(Main4Activity_TheSuaXoa_Sach.this);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Main4Activity_TheSuaXoa_Sach.this);
                dialog.setContentView(R.layout.dialog_them_sach);
                dialog.setCancelable(false);
                Button btnThem, btnHuy;
                Spinner tvTL;
                final TextInputLayout tvMa, tvTen, tvDonGia, tvNXB, tvSL, tvNgayNhap, tvTacGia;
                btnThem = dialog.findViewById(R.id.btnThemSach);
                btnHuy = dialog.findViewById(R.id.btnHuySach);
                tvMa = dialog.findViewById(R.id.tvMa);
                tvTen = dialog.findViewById(R.id.tvTen);
                tvDonGia = dialog.findViewById(R.id.tvDonGia);
                tvNXB = dialog.findViewById(R.id.tvNXB);
                tvSL = dialog.findViewById(R.id.tvSL);
                tvNgayNhap = dialog.findViewById(R.id.tvNgayNhap);
                tvTL = dialog.findViewById(R.id.SpinnerTL);
                tvTacGia = dialog.findViewById(R.id.tvTacGia);

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

                TLList = new ArrayList<>();
                TLList = theLoai_dao.getAlltheloai();
                tvTL.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Main4Activity_TheSuaXoa_Sach.this);
                final ArrayAdapter arrayAdapter = new ArrayAdapter(Main4Activity_TheSuaXoa_Sach.this,android.R.layout.simple_spinner_dropdown_item,TLList);
                tvTL.setAdapter(arrayAdapter);

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

                        String soLuong = tvSL.getEditText().getText().toString().trim();
                        String Tacgia = tvTacGia.getEditText().getText().toString().trim();



                        if (maS.equals("") || TenS.equals("") || DonGia.equals("") || NXB.equals("") || NgayNhap.equals("") || TheLoai.equals("") || soLuong.equals("") || Tacgia.equals("")) {
                            Toast.makeText(Main4Activity_TheSuaXoa_Sach.this, "Bạn Không Được Để Trống", Toast.LENGTH_SHORT).show();
                        } else {
                            Pattern pattern = Pattern.compile(".*\\D.");
                            Matcher matcher1 = pattern.matcher(tvDonGia.getEditText().getText().toString().trim());
                            Matcher matcher2 = pattern.matcher(tvSL.getEditText().getText().toString().trim());

                            if (matcher2.matches()) {
                                tvSL.setError("Bạn Phải Nhập Vào 1 Số");
                            } else {
                                tvSL.setError(null);
                            }

                            if (matcher1.matches()) {
                                tvDonGia.setError("Bạn Phải Nhập Vào 1 Số");
                            } else {
                                tvDonGia.setError(null);
                            }


                            Sach sach = new Sach();
                            sach.setMaSach(maS);
                            sach.setTenSach(TenS);
                            try {
                                sach.setGia(Double.parseDouble(DonGia));
                                sach.setSoLuong(Integer.parseInt(soLuong));
                            }catch (Exception e){

                            }
                            sach.setNhaXuatBan(NXB);
                            sach.setTheLoai(TheLoai);
                            sach.setNgayNhap(NgayNhap);
                            sach.setTacGia(Tacgia);
                            control_sach.insert(sach);
                            Sachlist = control_sach.getData();
                            adapter_ListView adapter_listView = new adapter_ListView(Main4Activity_TheSuaXoa_Sach.this,R.layout.custom_list_sach,Sachlist);
                            listView.setAdapter(adapter_listView);
                        }
                    }
                });

                dialog.show();
            }

        });
        Sachlist = control_sach.getData();
        adapter_ListView adapter_listView = new adapter_ListView(Main4Activity_TheSuaXoa_Sach.this,R.layout.custom_list_sach,Sachlist);
        listView.setAdapter(adapter_listView);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = String.valueOf(parent.getItemIdAtPosition(position));
        TheLoai = (String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

//    public boolean isValuedateDecimalNumber(CharSequence e) {
//        return !TextUtils.isEmpty(e) && Patterns.EMAIL_ADDRESS.matcher(e).matches();// kieerm tra email
//    }
}
