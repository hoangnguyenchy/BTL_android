package com.example.cuahangdienthoai.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.cuahangdienthoai.Activity.ChiTietSanPhamActivity;
import com.example.cuahangdienthoai.Models.HoaDon;
import com.example.cuahangdienthoai.Models.SanPham;
import com.example.cuahangdienthoai.R;
import com.example.cuahangdienthoai.Utils.Common;

import java.util.List;

public class HoaDonAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<HoaDon> hoaDonList;

    public HoaDonAdapter(Context context , int layout , List<HoaDon> hoaDonList) {
        this.context = context;
        this.layout = layout;
        this.hoaDonList = hoaDonList;
    }

    @Override
    public int getCount() {
        return hoaDonList.size ();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position , View convertView , ViewGroup parent) {
        convertView = LayoutInflater.from ( context ).inflate ( layout , parent , false );

        TextView mahd = convertView.findViewById ( R.id.mahoadon );
        TextView tentk = convertView.findViewById ( R.id.tentk );
        TextView ngay = convertView.findViewById ( R.id.ngay );
        TextView sdt = convertView.findViewById ( R.id.sdt );
        TextView dc = convertView.findViewById ( R.id.diachi );
        HoaDon hoaDon = hoaDonList.get ( position );
        mahd.setText ( String.valueOf ( hoaDon.getMaHD () ) );
        tentk.setText ( hoaDon.getTenTK () );
        ngay.setText ( hoaDon.getNgayBan () );
        sdt.setText ( hoaDon.getSDT () );
        dc.setText ( hoaDon.getDiaChi () );
        return convertView;
    }
}
