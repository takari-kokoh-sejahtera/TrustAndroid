package com.example.aplikasi2.inputbstk_sesudah;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasi2.Model.Globals;
import com.example.aplikasi2.Model.Ms_Customers;
import com.example.aplikasi2.Model.Ms_Vehicles;
import com.example.aplikasi2.Model.Ts_BSTKBefores;
import com.example.aplikasi2.R;
import com.example.aplikasi2.loginbstk.ApiClient;
import com.example.aplikasi2.loginbstk.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inputbstk extends Fragment {
    public Modelbstk model = new Modelbstk();
    ApiInterface apiservice;
    Context mContext;
    ArrayList<String> items = new ArrayList<>();
    SpinnerDialog spinnerDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inputbstk, container, false);
        final TextView tvNoPlat = (TextView) view.findViewById(R.id.tvNoPlat);
        ImageButton btnSearchNoPlat = (ImageButton) view.findViewById(R.id.btnSearchNoPlat);
        spinnerDialog = new SpinnerDialog(getActivity(), items, "Select item");

        mContext = this.getActivity();
        Globals g = (Globals)getActivity().getApplication();
        if (model.Nomor_Plat_Kendaraan != null) {
            tvNoPlat.setText(model.Nomor_Plat_Kendaraan);
        }

        ImageButton btn_next = (ImageButton) view.findViewById(R.id.button_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.Nomor_Plat_Kendaraan = tvNoPlat.getText().toString();
                next_Fragment(model); }
        });

        apiservice = ApiClient.getClient().create(ApiInterface.class);
        apiservice.GetBSTKBeforeForAfter(g.getUser_ID()).enqueue(new Callback<List<Ts_BSTKBefores>>() {
            @Override
            public void onResponse(Call<List<Ts_BSTKBefores>> call, Response<List<Ts_BSTKBefores>> response) {
                try {
                    List<Ts_BSTKBefores> vehicles = response.body();
                    for (Ts_BSTKBefores vehicle : vehicles) {
                        if (!TextUtils.isEmpty(vehicle.Gabungan)) {
                            items.add(vehicle.Gabungan.toString());
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Ts_BSTKBefores>> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        spinnerDialog = new SpinnerDialog(getActivity(), items, "Select item");
        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                tvNoPlat.setText(item);
            }
        });
        btnSearchNoPlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerDialog.showSpinerDialog();
            }
        });

        return view;
    }

    private void next_Fragment(Modelbstk model) {
        Inputbstk_1 fragment = new Inputbstk_1();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
