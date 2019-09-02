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
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aplikasi2.Model.Ms_Customers;
import com.example.aplikasi2.Model.Ms_Vehicles;
import com.example.aplikasi2.R;
import com.example.aplikasi2.loginbstk.ApiClient;
import com.example.aplikasi2.loginbstk.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Input extends Fragment  {
    public Model model = new Model();
    ApiInterface apiservice;
    Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment__input, container, false);

        final Spinner spinner_customer = (Spinner) view.findViewById(R.id.spinner_cus);
        final Spinner spinner_no_plat = (Spinner) view.findViewById(R.id.spinner_noplat);
        mContext = this.getActivity();
//
//        ArrayAdapter<CharSequence> adapter_no_plat = ArrayAdapter.createFromResource(mContext,
//                R.array.string_no_plat, android.R.layout.simple_spinner_item);
//
//        spinner_no_plat.setAdapter(adapter_no_plat);
//
//        if (model.Nomor_Plat_Kendaraan!=null){
//            int spinnerPosition = adapter_no_plat.getPosition(model.Nomor_Plat_Kendaraan);
//            spinner_no_plat.setSelection(spinnerPosition);
//        }


        ImageButton button1 = (ImageButton) view.findViewById(R.id.button_next);

        apiservice = ApiClient.getClient().create(ApiInterface.class);
        apiservice.GetCustomer().enqueue(new Callback<List<Ms_Customers>>() {
            @Override
            public void onResponse(Call<List<Ms_Customers>> call, Response<List<Ms_Customers>> response) {
                List<Ms_Customers> customers = response.body();

                try {
                    List<String> list = new ArrayList<String>();

//                  masukin ke adapter
                    for (Ms_Customers customer : customers){
                        list.add(customer.Company_Name.toString());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, list);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_customer.setAdapter(adapter);


                    if (model.Nama_Customer!=null){
                        int spinnerPosition = adapter.getPosition(model.Nama_Customer);
                        spinner_customer.setSelection(spinnerPosition);
                    }
                } catch (Exception e) {
                    Toast.makeText(getContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Ms_Customers>> call, Throwable t) {
                Toast.makeText(getContext(),t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        apiservice.GetVehicle().enqueue(new Callback<List<Ms_Vehicles>>() {
            @Override
            public void onResponse(Call<List<Ms_Vehicles>> call, Response<List<Ms_Vehicles>> response) {
                List<Ms_Vehicles> vehicles = response.body();

                try {

                    List<String> list = new ArrayList<String>();

//                  masukin ke adapter
                    for (Ms_Vehicles vehicle : vehicles){
                        if(!TextUtils.isEmpty(vehicle.license_no)){
                            list.add(vehicle.license_no.toString());
                        }
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, list);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_no_plat.setAdapter(adapter);


                    if (model.Nomor_Plat_Kendaraan!=null){
                        int spinnerPosition = adapter.getPosition(model.Nomor_Plat_Kendaraan);
                        spinner_no_plat.setSelection(spinnerPosition);
                    }
                } catch (Exception e) {
                    Toast.makeText(getContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Ms_Vehicles>> call, Throwable t) {
                Toast.makeText(getContext(),t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.Nama_Customer = spinner_customer.getSelectedItem().toString();
                model.Nomor_Plat_Kendaraan = spinner_no_plat.getSelectedItem().toString();
                next_Fragment(model); }
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
