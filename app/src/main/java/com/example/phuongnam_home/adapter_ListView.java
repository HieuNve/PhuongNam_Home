package com.example.phuongnam_home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.phuongnam_home.Model.Sach;

import java.util.List;

public class adapter_ListView  extends ArrayAdapter<Sach> {
    private Context context;
    private int layout;
    private List<Sach> lsSach;
    private LayoutInflater inflater;


    public adapter_ListView(Context context, int resource,List<Sach> objects) {
        super(context, resource,objects);
        this.context = context;
        this.layout = resource;
        this.lsSach = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHoder hoder = new ViewHoder();
        if (convertView == null){
            convertView = inflater.inflate(R.layout.custom_list_sach,null);
            hoder.tvMa = convertView.findViewById(R.id.MaSach);
            hoder.Tvname = convertView.findViewById(R.id.tvName);
            hoder.TvGia = convertView.findViewById(R.id.DonGia);
            hoder.TvtheLoai = convertView.findViewById(R.id.tvTHeLoai);
            hoder.TvNgayNhap = convertView.findViewById(R.id.NgayNhap);
            hoder.tvTacGia = convertView.findViewById(R.id.TacGia);
            hoder.tvNhaXuatBan = convertView.findViewById(R.id.NhaXuatBan);
            hoder.tvSoLuong = convertView.findViewById(R.id.SoLuong);
        }else {
             hoder = (ViewHoder) convertView.getTag();
        }

        Sach sach = lsSach.get(position);
//        hoder.tvMa.setText(sach.getMaSach());
        hoder.Tvname.setText(sach.getTenSach());
        hoder.TvGia.setText(String.valueOf(sach.getGia()));
        hoder.TvtheLoai.setText(sach.getTheLoai());
        hoder.TvNgayNhap.setText(sach.getNgayNhap());
        hoder.tvTacGia.setText(sach.getTacGia());
        hoder.tvNhaXuatBan.setText(sach.getNhaXuatBan());
        hoder.tvSoLuong.setText(String.valueOf(sach.getSoLuong()));
        return convertView;
    }

    public class ViewHoder{
        TextView tvMa,Tvname,TvGia,TvtheLoai,TvNgayNhap,tvTacGia,tvNhaXuatBan,tvSoLuong;
    }
}
