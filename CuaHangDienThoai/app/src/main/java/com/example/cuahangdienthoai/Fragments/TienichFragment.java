package com.example.cuahangdienthoai.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cuahangdienthoai.API.ApiService;
import com.example.cuahangdienthoai.Activity.MapsActivity;
import com.example.cuahangdienthoai.Activity.ThanhToanActivity;
import com.example.cuahangdienthoai.Adapters.GioHangAdapter;
import com.example.cuahangdienthoai.Adapters.HoaDonAdapter;
import com.example.cuahangdienthoai.Models.HoaDon;
import com.example.cuahangdienthoai.R;
import com.example.cuahangdienthoai.Utils.Common;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TienichFragment extends Fragment {
    EditText edtngay;
    ListView lvhoadon;
    Button btnthongke;
    List<HoaDon> listhd;
    HoaDonAdapter adapter;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate( R.layout.activity_thong_ke_doan_thu, container, false);
        anhxa();
        btnthongke.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String ngay = edtngay.getText ().toString ().trim ();
                thongke(ngay);
            }
        } );
        return view;
    }

    private void thongke(String ngay) {
        ApiService.api.getHoadon (ngay).enqueue ( new Callback<List<HoaDon>> () {
            @Override
            public void onResponse(Call<List<HoaDon>> call , Response<List<HoaDon>> response) {
                listhd = response.body();
                if(listhd != null){
                    adapter = new HoaDonAdapter ( getActivity (),R.layout .item_hoadon,listhd );
                    lvhoadon.setAdapter (adapter);
                }
                else{
                    Toast.makeText ( getActivity () , "Không có hoá đơn cần tìm" , Toast.LENGTH_SHORT ).show ();
                }
            }

            @Override
            public void onFailure(Call<List<HoaDon>> call , Throwable t) {

            }
        } );
    }

    private void anhxa() {
        edtngay = view.findViewById ( R.id.edtngay );
        lvhoadon = view.findViewById ( R.id.lv_hoa_don);
        btnthongke = view.findViewById ( R.id.btnthongke );
    }

}
