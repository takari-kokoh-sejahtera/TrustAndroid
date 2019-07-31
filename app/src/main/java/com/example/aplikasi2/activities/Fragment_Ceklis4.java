package com.example.aplikasi2.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.aplikasi2.R;


public class Fragment_Ceklis4 extends Fragment {
    public Model model = new Model();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment__ceklis4, container, false);

        RadioGroup rg_Safety_Belt = (RadioGroup) view.findViewById(R.id.rgSafety_Belt);
        RadioButton b_Safety_Belt = (RadioButton) view.findViewById(R.id.b22);
        RadioButton r_Safety_Belt = (RadioButton) view.findViewById(R.id.r22);
        RadioButton t_Safety_Belt = (RadioButton) view.findViewById(R.id.t22);
        RadioGroup rg_Karpet = (RadioGroup) view.findViewById(R.id.rgKarpet);
        RadioButton b_Karpet = (RadioButton) view.findViewById(R.id.b23);
        RadioButton r_Karpet = (RadioButton) view.findViewById(R.id.r23);
        RadioButton t_Karpet = (RadioButton) view.findViewById(R.id.t23);
        RadioGroup rg_Lighter = (RadioGroup) view.findViewById(R.id.rgLighter);
        RadioButton b_Lighter = (RadioButton) view.findViewById(R.id.b24);
        RadioButton r_Lighter = (RadioButton) view.findViewById(R.id.r24);
        RadioButton t_Lighter = (RadioButton) view.findViewById(R.id.t24);
        RadioGroup rg_Asbak = (RadioGroup) view.findViewById(R.id.rgAsbak);
        RadioButton b_Asbak = (RadioButton) view.findViewById(R.id.b25);
        RadioButton r_Asbak = (RadioButton) view.findViewById(R.id.r25);
        RadioButton t_Asbak = (RadioButton) view.findViewById(R.id.t25);
        RadioGroup rg_Sarung_Jok = (RadioGroup) view.findViewById(R.id.rgSarung_Jok);
        RadioButton b_Sarung_Jok = (RadioButton) view.findViewById(R.id.b26);
        RadioButton r_Sarung_Jok = (RadioButton) view.findViewById(R.id.r26);
        RadioButton t_Sarung_Jok = (RadioButton) view.findViewById(R.id.t26);
        RadioGroup rg_Sandaran_Kepala = (RadioGroup) view.findViewById(R.id.rgSandaran_Kepala);
        RadioButton b_Sandaran_Kepala = (RadioButton) view.findViewById(R.id.b27);
        RadioButton r_Sandaran_Kepala = (RadioButton) view.findViewById(R.id.r27);
        RadioButton t_Sandaran_Kepala = (RadioButton) view.findViewById(R.id.t27);
        RadioGroup rg_Spion_Dalam = (RadioGroup) view.findViewById(R.id.rgSpion_Dalam);
        RadioButton b_Spion_Dalam = (RadioButton) view.findViewById(R.id.b28);
        RadioButton r_Spion_Dalam = (RadioButton) view.findViewById(R.id.r28);
        RadioButton t_Spion_Dalam = (RadioButton) view.findViewById(R.id.t28);
        EditText te_Safety_Belt = (EditText) view.findViewById(R.id.teSafety_Belt);
        EditText te_Karpet = (EditText) view.findViewById(R.id.teKarpet);
        EditText te_Lighter = (EditText) view.findViewById(R.id.teLighter);
        EditText te_Asbak = (EditText) view.findViewById(R.id.teAsbak);
        EditText te_Sarung_Jok = (EditText) view.findViewById(R.id.teSarung_Jok);
        EditText te_Sandaran_Kepala = (EditText) view.findViewById(R.id.teSandaran_Kepala);
        EditText te_Spion_Dalam = (EditText) view.findViewById(R.id.teSpion_Dalam);

        if(model.Safety_Belt!=null){
            te_Safety_Belt.setText(model.Safety_Belt_Ket);
            if(model.Safety_Belt == "B"){
                b_Safety_Belt.setChecked(true);
            }
            else if(model.Safety_Belt == "R"){
                r_Safety_Belt.setChecked(true);
            }
            else if(model.Safety_Belt == "T"){
                t_Safety_Belt.setChecked(true);
            }
        }
        if(model.Karpet!=null){
            te_Karpet.setText(model.Karpet_Ket);
            if(model.Karpet == "B"){
                b_Karpet.setChecked(true);
            }
            else if(model.Karpet == "R"){
                r_Karpet.setChecked(true);
            }
            else if(model.Karpet == "T"){
                t_Asbak.setChecked(true);
            }
        }
        if(model.Lighter!=null){
            te_Lighter.setText(model.Lighter_Ket);
            if(model.Lighter == "B"){
                b_Lighter.setChecked(true);
            }
            else if(model.Lighter == "R"){
                r_Lighter.setChecked(true);
            }
            else if(model.Lighter == "T"){
                t_Lighter.setChecked(true);
            }
        }
        if(model.Asbak!=null){
            te_Asbak.setText(model.Asbak_Ket);
            if(model.Asbak == "B"){
                b_Asbak.setChecked(true);
            }
            else if(model.Asbak == "R"){
                r_Asbak.setChecked(true);
            }
            else if(model.Asbak == "T"){
                t_Asbak.setChecked(true);
            }
        }
        if(model.Sarung_Jok!=null){
            te_Sarung_Jok.setText(model.Sarung_Jok_Ket);
            if(model.Sarung_Jok == "B"){
                b_Sarung_Jok.setChecked(true);
            }
            else if(model.Sarung_Jok == "R"){
                r_Sarung_Jok.setChecked(true);
            }
            else if(model.Sarung_Jok == "T"){
                t_Sarung_Jok.setChecked(true);
            }
        }
        if(model.Sandaran_Kepala!=null){
            te_Sandaran_Kepala.setText(model.Sandaran_Kepala_Ket);
            if(model.Sandaran_Kepala == "B"){
                b_Sandaran_Kepala.setChecked(true);
            }
            else if(model.Sandaran_Kepala == "R"){
                r_Sandaran_Kepala.setChecked(true);
            }
            else if(model.Sandaran_Kepala == "T"){
                t_Sandaran_Kepala.setChecked(true);
            }
        }
        if(model.Spion_Dalam!=null){
            te_Spion_Dalam.setText(model.Spion_Dalam_Ket);
            if(model.Spion_Dalam == "B"){
                b_Spion_Dalam.setChecked(true);
            }
            else if(model.Spion_Dalam == "R"){
                r_Spion_Dalam.setChecked(true);
            }
            else if(model.Spion_Dalam == "T"){
                t_Spion_Dalam.setChecked(true);
            }
        }


        ImageButton button1 = (ImageButton) view.findViewById(R.id.button_ceklis);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.Safety_Belt_Ket = te_Safety_Belt.getText().toString();
                model.Karpet_Ket = te_Karpet.getText().toString();
                model.Lighter_Ket = te_Lighter.getText().toString();
                model.Asbak_Ket = te_Asbak.getText().toString();
                model.Sarung_Jok_Ket = te_Sarung_Jok.getText().toString();
                model.Sandaran_Kepala_Ket = te_Sandaran_Kepala.getText().toString();
                model.Spion_Dalam_Ket = te_Spion_Dalam.getText().toString();

                if(b_Safety_Belt.isChecked()){
                    model.Safety_Belt = "B";
                }
                else if(r_Safety_Belt.isChecked()){
                    model.Safety_Belt = "R";
                }
                else if(t_Safety_Belt.isChecked()){
                    model.Safety_Belt = "T";
                }

                if(b_Karpet.isChecked()){
                    model.Karpet = "B";
                }
                else if(r_Karpet.isChecked()){
                    model.Karpet = "R";
                }
                else if(t_Karpet.isChecked()){
                    model.Karpet = "T";
                }

                if(b_Lighter.isChecked()){
                    model.Lighter = "B";
                }
                else if(r_Lighter.isChecked()){
                    model.Lighter = "R";
                }
                else if(t_Lighter.isChecked()){
                    model.Lighter = "T";
                }

                if(b_Asbak.isChecked()){
                    model.Asbak = "B";
                }
                else if(r_Asbak.isChecked()){
                    model.Asbak = "R";
                }
                else if(t_Asbak.isChecked()){
                    model.Asbak = "T";
                }

                if(b_Sarung_Jok.isChecked()){
                    model.Sarung_Jok = "B";
                }
                else if(r_Sarung_Jok.isChecked()){
                    model.Sarung_Jok = "R";
                }
                else if(t_Sarung_Jok.isChecked()){
                    model.Sarung_Jok = "T";
                }

                if(b_Sandaran_Kepala.isChecked()){
                    model.Sandaran_Kepala = "B";
                }
                else if(r_Sandaran_Kepala.isChecked()){
                    model.Sandaran_Kepala = "R";
                }
                else if(t_Sandaran_Kepala.isChecked()){
                    model.Sandaran_Kepala = "T";
                }

                if(b_Spion_Dalam.isChecked()){
                    model.Spion_Dalam = "B";
                }
                else if(r_Spion_Dalam.isChecked()){
                    model.Spion_Dalam = "R";
                }
                else if(t_Spion_Dalam.isChecked()){
                    model.Spion_Dalam ="T";
                }

                next_Fragment(model); }
        });

        ImageButton button2 = (ImageButton) view.findViewById(R.id.button_Back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.Safety_Belt_Ket = te_Safety_Belt.getText().toString();
                model.Karpet_Ket = te_Karpet.getText().toString();
                model.Lighter_Ket = te_Lighter.getText().toString();
                model.Asbak_Ket = te_Asbak.getText().toString();
                model.Sarung_Jok_Ket = te_Sarung_Jok.getText().toString();
                model.Sandaran_Kepala_Ket = te_Sandaran_Kepala.getText().toString();
                model.Spion_Dalam_Ket = te_Spion_Dalam.getText().toString();

                if(b_Safety_Belt.isChecked()){
                    model.Safety_Belt = "B";
                }
                else if(r_Safety_Belt.isChecked()){
                    model.Safety_Belt = "R";
                }
                else if(t_Safety_Belt.isChecked()){
                    model.Safety_Belt = "T";
                }

                if(b_Karpet.isChecked()){
                    model.Karpet = "B";
                }
                else if(r_Karpet.isChecked()){
                    model.Karpet = "R";
                }
                else if(t_Karpet.isChecked()){
                    model.Karpet = "T";
                }

                if(b_Lighter.isChecked()){
                    model.Lighter = "B";
                }
                else if(r_Lighter.isChecked()){
                    model.Lighter = "R";
                }
                else if(t_Lighter.isChecked()){
                    model.Lighter = "T";
                }

                if(b_Asbak.isChecked()){
                    model.Asbak = "B";
                }
                else if(r_Asbak.isChecked()){
                    model.Asbak = "R";
                }
                else if(t_Asbak.isChecked()){
                    model.Asbak = "T";
                }

                if(b_Sarung_Jok.isChecked()){
                    model.Sarung_Jok = "B";
                }
                else if(r_Sarung_Jok.isChecked()){
                    model.Sarung_Jok = "R";
                }
                else if(t_Sarung_Jok.isChecked()){
                    model.Sarung_Jok = "T";
                }

                if(b_Sandaran_Kepala.isChecked()){
                    model.Sandaran_Kepala = "B";
                }
                else if(r_Sandaran_Kepala.isChecked()){
                    model.Sandaran_Kepala = "R";
                }
                else if(t_Sandaran_Kepala.isChecked()){
                    model.Sandaran_Kepala = "T";
                }

                if(b_Spion_Dalam.isChecked()){
                    model.Spion_Dalam = "B";
                }
                else if(r_Spion_Dalam.isChecked()){
                    model.Spion_Dalam = "R";
                }
                else if(t_Spion_Dalam.isChecked()){
                    model.Spion_Dalam ="T";
                }

                back_Fragment(); }
        });

        return view;
    }
    private void next_Fragment(Model model) {
        Fragment_Ceklis5 fragment = new Fragment_Ceklis5();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void back_Fragment() {
        Fragment_Ceklis3 fragment = new Fragment_Ceklis3();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
