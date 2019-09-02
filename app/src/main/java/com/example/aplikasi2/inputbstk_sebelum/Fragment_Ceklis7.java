package com.example.aplikasi2.inputbstk_sebelum;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.aplikasi2.R;

public class Fragment_Ceklis7 extends Fragment {

    public Model model = new Model();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment__ceklis7, container, false);

        RadioGroup rg_Kunci_Stir = (RadioGroup) view.findViewById(R.id.rgKunci_Stir);
        final RadioButton b_Kunci_Stir = (RadioButton) view.findViewById(R.id.b43);
        final RadioButton r_Kunci_Stir = (RadioButton) view.findViewById(R.id.r43);
        final RadioButton t_Kunci_Stir = (RadioButton) view.findViewById(R.id.t43);
        RadioGroup rg_Dongkrak = (RadioGroup) view.findViewById(R.id.rgDongkrak);
        final RadioButton b_Dongkrak = (RadioButton) view.findViewById(R.id.b44);
        final RadioButton r_Dongkrak = (RadioButton) view.findViewById(R.id.r44);
        final RadioButton t_Dongkrak = (RadioButton) view.findViewById(R.id.t44);
        RadioGroup rg_P3K = (RadioGroup) view.findViewById(R.id.rgP3K);
        final RadioButton b_P3K = (RadioButton) view.findViewById(R.id.b45);
        final RadioButton r_P3K = (RadioButton) view.findViewById(R.id.r45);
        final RadioButton t_P3K = (RadioButton) view.findViewById(R.id.t45);
        RadioGroup rg_Segitiga_Pengaman = (RadioGroup) view.findViewById(R.id.rgSegitiga_Pengaman);
        final RadioButton b_Segitiga_Pengaman = (RadioButton) view.findViewById(R.id.b46);
        final RadioButton r_Segitiga_Pengaman = (RadioButton) view.findViewById(R.id.r46);
        final RadioButton t_Segitiga_Pengaman = (RadioButton) view.findViewById(R.id.t46);
        RadioGroup rg_Lap_Kanebo = (RadioGroup) view.findViewById(R.id.rgLap_Kanebo);
        final RadioButton b_Lap_Kanebo = (RadioButton) view.findViewById(R.id.b47);
        final RadioButton r_Lap_Kanebo = (RadioButton) view.findViewById(R.id.r47);
        final RadioButton t_Lap_Kanebo = (RadioButton) view.findViewById(R.id.t47);
        final EditText te_Kunci_Stir = (EditText) view.findViewById(R.id.teKunci_Stir);
        final EditText te_Dongkrak = (EditText) view.findViewById(R.id.teDongkrak);
        final EditText te_P3K = (EditText) view.findViewById(R.id.teP3K);
        final EditText te_Segitiga_Pengaman = (EditText) view.findViewById(R.id.teSegitiga_Pengaman);
        final EditText te_Lap_Kanebo = (EditText) view.findViewById(R.id.teLap_Kanebo);

        if(model.Kunci_Stir!=null){
            te_Kunci_Stir.setText(model.Kunci_Stir_Ket);
            if(model.Kunci_Stir == "B"){
                b_Kunci_Stir.setChecked(true);
            }
            else if(model.Kunci_Stir == "R"){
                r_Kunci_Stir.setChecked(true);
            }
            else if(model.Kunci_Stir == "T"){
                t_Kunci_Stir.setChecked(true);
            }
        }
        if(model.Dongkrak!=null){
            te_Dongkrak.setText(model.Dongkrak_Ket);
            if(model.Dongkrak =="B"){
                b_Dongkrak.setChecked(true);
            }
            else if(model.Dongkrak == "R"){
                r_Dongkrak.setChecked(true);
            }
            else if(model.Dongkrak == "T"){
                t_Dongkrak.setChecked(true);
            }
        }
        if(model.P3K!=null){
            te_P3K.setText(model.P3K_Ket);
            if(model.P3K == "B"){
                b_P3K.setChecked(true);
            }
            else if(model.P3K == "R"){
                r_Dongkrak.setChecked(true);
            }
            else if(model.P3K == "T"){
                t_Dongkrak.setChecked(true);
            }
        }
        if(model.Segitiga_Pengaman!=null){
            te_Segitiga_Pengaman.setText(model.Segitiga_Pengaman_Ket);
            if(model.Segitiga_Pengaman == "B"){
                b_Segitiga_Pengaman.setChecked(true);
            }
            else if(model.Segitiga_Pengaman == "R"){
                r_Segitiga_Pengaman.setChecked(true);
            }
            else if(model.Segitiga_Pengaman == "T"){
                t_Segitiga_Pengaman.setChecked(true);
            }
        }
        if(model.Lap_Kanebo!=null){
            te_Lap_Kanebo.setText(model.Lap_Kanebo_Ket);
            if(model.Lap_Kanebo == "B"){
                b_Lap_Kanebo.setChecked(true);
            }
            else if(model.Lap_Kanebo == "R"){
                r_Lap_Kanebo.setChecked(true);
            }
            else if(model.Lap_Kanebo == "T"){
                t_Lap_Kanebo.setChecked(true);
            }
        }

        ImageButton button1 = (ImageButton) view.findViewById(R.id.button_ceklis);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.Kunci_Stir_Ket = te_Kunci_Stir.getText().toString();
                model.Dongkrak_Ket = te_Dongkrak.getText().toString();
                model.P3K_Ket = te_P3K.getText().toString();
                model.Segitiga_Pengaman_Ket = te_Segitiga_Pengaman.getText().toString();
                model.Lap_Kanebo_Ket = te_Lap_Kanebo.getText().toString();

                if(b_Kunci_Stir.isChecked()){
                    model.Kunci_Stir = "B";
                }
                else if(r_Kunci_Stir.isChecked()){
                    model.Kunci_Stir = "R";
                }
                else if(t_Kunci_Stir.isChecked()){
                    model.Kunci_Stir = "T";
                }

                if(b_Dongkrak.isChecked()){
                    model.Dongkrak = "B";
                }
                else if(r_Dongkrak.isChecked()){
                    model.Dongkrak = "R";
                }
                else if(t_Dongkrak.isChecked()){
                    model.Dongkrak = "T";
                }

                if(b_P3K.isChecked()){
                    model.P3K = "B";
                }
                else if(r_P3K.isChecked()){
                    model.P3K = "R";
                }
                else if(t_P3K.isChecked()){
                    model.P3K = "T";
                }

                if(b_Segitiga_Pengaman.isChecked()){
                    model.Segitiga_Pengaman = "B";
                }
                else if(r_Segitiga_Pengaman.isChecked()){
                    model.Segitiga_Pengaman = "R";
                }
                else if(t_Segitiga_Pengaman.isChecked()){
                    model.Segitiga_Pengaman = "T";
                }

                if(b_Lap_Kanebo.isChecked()){
                    model.Lap_Kanebo = "B";
                }
                else if(r_Lap_Kanebo.isChecked()){
                    model.Lap_Kanebo = "R";
                }
                else if(t_Lap_Kanebo.isChecked()){
                    model.Lap_Kanebo = "T";
                }

                next_Fragment(model); }
        });

        ImageButton button2 = (ImageButton) view.findViewById(R.id.button_Back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.Kunci_Stir_Ket = te_Kunci_Stir.getText().toString();
                model.Dongkrak_Ket = te_Dongkrak.getText().toString();
                model.P3K_Ket = te_P3K.getText().toString();
                model.Segitiga_Pengaman_Ket = te_Segitiga_Pengaman.getText().toString();
                model.Lap_Kanebo_Ket = te_Lap_Kanebo.getText().toString();

                if(b_Kunci_Stir.isChecked()){
                    model.Kunci_Stir = "B";
                }
                else if(r_Kunci_Stir.isChecked()){
                    model.Kunci_Stir = "R";
                }
                else if(t_Kunci_Stir.isChecked()){
                    model.Kunci_Stir = "T";
                }

                if(b_Dongkrak.isChecked()){
                    model.Dongkrak = "B";
                }
                else if(r_Dongkrak.isChecked()){
                    model.Dongkrak = "R";
                }
                else if(t_Dongkrak.isChecked()){
                    model.Dongkrak = "T";
                }

                if(b_P3K.isChecked()){
                    model.P3K = "B";
                }
                else if(r_P3K.isChecked()){
                    model.P3K = "R";
                }
                else if(t_P3K.isChecked()){
                    model.P3K = "T";
                }

                if(b_Segitiga_Pengaman.isChecked()){
                    model.Segitiga_Pengaman = "B";
                }
                else if(r_Segitiga_Pengaman.isChecked()){
                    model.Segitiga_Pengaman = "R";
                }
                else if(t_Segitiga_Pengaman.isChecked()){
                    model.Segitiga_Pengaman = "T";
                }

                if(b_Lap_Kanebo.isChecked()){
                    model.Lap_Kanebo = "B";
                }
                else if(r_Lap_Kanebo.isChecked()){
                    model.Lap_Kanebo = "R";
                }
                else if(t_Lap_Kanebo.isChecked()){
                    model.Lap_Kanebo = "T";
                }

                back_Fragment(); }
        });


        return view;
    }
    private void next_Fragment(Model model) {
        Fragment_Ceklis8 fragment = new Fragment_Ceklis8();
        fragment. model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void back_Fragment() {
        Fragment_Ceklis6 fragment = new Fragment_Ceklis6();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
