package com.example.aplikasi2.inputbstk_sesudah;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aplikasi2.Model.Globals;
import com.example.aplikasi2.Model.Ms_Customers;
import com.example.aplikasi2.Model.Ts_BSTKBefores;
import com.example.aplikasi2.R;
import com.example.aplikasi2.loginbstk.ApiClient;
import com.example.aplikasi2.loginbstk.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inputbstk extends Fragment {
    public Modelbstk model = new Modelbstk();
    ApiInterface apiservice;
    Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inputbstk, container, false);

        final Spinner spinner_no_plat = (Spinner) view.findViewById(R.id.spinner_noplat);
        mContext = this.getActivity();
        Globals g = (Globals)getActivity().getApplication();


        ImageButton button1 = (ImageButton) view.findViewById(R.id.button_next);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.Nomor_Plat_Kendaraan = spinner_no_plat.getSelectedItem().toString();
                next_Fragment(model); }
        });

        apiservice = ApiClient.getClient().create(ApiInterface.class);
        apiservice.GetBSTKBeforeForAfter(g.getUser_ID()).enqueue(new Callback<List<Ts_BSTKBefores>>() {
            @Override
            public void onResponse(Call<List<Ts_BSTKBefores>> call, Response<List<Ts_BSTKBefores>> response) {
                List<Ts_BSTKBefores> gabungan = response.body();

                try {
                    List<String> list = new ArrayList<String>();

//                  masukin ke adapter
                    for (Ts_BSTKBefores gabung : gabungan){
                        list.add(gabung.Gabungan.toString());
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
            public void onFailure(Call<List<Ts_BSTKBefores>> call, Throwable t) {
                Toast.makeText(getContext(),t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
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
