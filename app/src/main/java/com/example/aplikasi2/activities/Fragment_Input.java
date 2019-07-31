package com.example.aplikasi2.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.aplikasi2.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Fragment_Input extends Fragment  {
    public Model model = new Model();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment__input, container, false);

        Spinner spinner_customer = (Spinner) view.findViewById(R.id.spinner_cus);
        Spinner spinner_no_plat = (Spinner) view.findViewById(R.id.spinner_noplat);

        ArrayAdapter<CharSequence> adapter_customer = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.string_customer, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_no_plat = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.string_no_plat, android.R.layout.simple_spinner_item);

        adapter_customer.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_no_plat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner_customer.setAdapter(adapter_customer);
        spinner_no_plat.setAdapter(adapter_no_plat);

        if (model.Nama_Customer!=null){
            int spinnerPosition = adapter_customer.getPosition(model.Nama_Customer);
            spinner_customer.setSelection(spinnerPosition);
        }
        if (model.Nomor_Plat_Kendaraan!=null){
            int spinnerPosition = adapter_no_plat.getPosition(model.Nomor_Plat_Kendaraan);
            spinner_no_plat.setSelection(spinnerPosition);
        }


        ImageButton button1 = (ImageButton) view.findViewById(R.id.button_next);
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
