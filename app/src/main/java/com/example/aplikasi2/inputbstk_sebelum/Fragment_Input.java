package com.example.aplikasi2.inputbstk_sebelum;

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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasi2.Model.Ms_Customers;
import com.example.aplikasi2.Model.Ms_Vehicles;
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

public class Fragment_Input extends Fragment {
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> itemPlats = new ArrayList<>();
    public Model model = new Model();
    ApiInterface apiservice;
    Context mContext;
    SpinnerDialog spinnerDialog;
    SpinnerDialog spinnerDialogNoPlat;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment__input, container, false);

        final TextView tvCompany_Name = (TextView) view.findViewById(R.id.tvCompany_Name);
        final TextView tvNoPlat = (TextView) view.findViewById(R.id.tvNoPlat);
        mContext = this.getActivity();
        apiservice = ApiClient.getClient().create(ApiInterface.class);

        ImageButton button_next = (ImageButton) view.findViewById(R.id.button_next);
        ImageButton btnSearchCompany = (ImageButton) view.findViewById(R.id.btnSearchCompany);
        ImageButton btnSearchNoPlat = (ImageButton) view.findViewById(R.id.btnSearchNoPlat);

        if (model.Nama_Customer != null) {
            tvCompany_Name.setText(model.Nama_Customer);
        }
        if (model.Nomor_Plat_Kendaraan != null) {
            tvNoPlat.setText(model.Nomor_Plat_Kendaraan);
        }
        apiservice.GetCustomer().enqueue(new Callback<List<Ms_Customers>>() {
            @Override
            public void onResponse(Call<List<Ms_Customers>> call, Response<List<Ms_Customers>> response) {
                try {
                    List<Ms_Customers> customers = response.body();
                    for (Ms_Customers customer : customers) {
                        items.add(customer.Company_Name.toString());
                    }
                } catch (Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Ms_Customers>> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        apiservice.GetVehicle().enqueue(new Callback<List<Ms_Vehicles>>() {
            @Override
            public void onResponse(Call<List<Ms_Vehicles>> call, Response<List<Ms_Vehicles>> response) {
                try {
                    List<Ms_Vehicles> vehicles = response.body();
                    for (Ms_Vehicles vehicle : vehicles) {
                        if (!TextUtils.isEmpty(vehicle.license_no)) {
                            itemPlats.add(vehicle.license_no.toString());
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Ms_Vehicles>> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        spinnerDialog = new SpinnerDialog(getActivity(), items, "Select item");
        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                tvCompany_Name.setText(item);
            }
        });
        spinnerDialogNoPlat = new SpinnerDialog(getActivity(), itemPlats, "Select item");
        spinnerDialogNoPlat.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                tvNoPlat.setText(item);
            }
        });

        btnSearchCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerDialog.showSpinerDialog();
            }
        });
        btnSearchNoPlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerDialogNoPlat.showSpinerDialog();
            }
        });
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.Nama_Customer = tvCompany_Name.getText().toString();
                model.Nomor_Plat_Kendaraan = tvNoPlat.getText().toString();
                next_Fragment(model);
            }
        });

        return view;
    }

    private void next_Fragment(Model model) {
        Fragment_Ceklis fragment = new Fragment_Ceklis();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
