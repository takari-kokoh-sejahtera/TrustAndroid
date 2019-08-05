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

public class Fragment_Ceklis extends Fragment {

    public Model model = new Model();
    private String mtext1 = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment__ceklis, container, false);

        RadioGroup rg_Automatic_Light_Switch = (RadioGroup) view.findViewById(R.id.rgAutomatic_Light_Switch);
        RadioButton b_Automatic_Light_Switch = (RadioButton) view.findViewById(R.id.b1);
        RadioButton r_Automatic_Light_Switch = (RadioButton) view.findViewById(R.id.r1);
        RadioButton t_Automatic_Light_Switch = (RadioButton) view.findViewById(R.id.t1);
        RadioGroup rg_Lampu_Kecil = (RadioGroup) view.findViewById(R.id.rgLampu_Kecil);
        RadioButton b_Lampu_Kecil = (RadioButton) view.findViewById(R.id.b2);
        RadioButton r_Lampu_Kecil = (RadioButton) view.findViewById(R.id.r2);
        RadioButton t_Lampu_Kecil = (RadioButton) view.findViewById(R.id.t2);
        RadioGroup rg_Lampu_Dekat = (RadioGroup) view.findViewById(R.id.rgLampu_Dekat);
        RadioButton b_Lampu_Dekat = (RadioButton) view.findViewById(R.id.b3);
        RadioButton r_Lampu_Dekat = (RadioButton) view.findViewById(R.id.r3);
        RadioButton t_Lampu_Dekat = (RadioButton) view.findViewById(R.id.t3);
        RadioGroup rg_Lampu_Jauh = (RadioGroup) view.findViewById(R.id.rgLampu_Jauh);
        RadioButton b_Lampu_Jauh = (RadioButton) view.findViewById(R.id.b4);
        RadioButton r_Lampu_Jauh = (RadioButton) view.findViewById(R.id.r4);
        RadioButton t_Lampu_Jauh = (RadioButton) view.findViewById(R.id.t4);
        RadioGroup rg_Lampu_Kabut_Fog_Lamp = (RadioGroup) view.findViewById(R.id.rgLampu_Kabut_Fog_Lamp);
        RadioButton b_Lampu_Kabut_Fog_Lamp = (RadioButton) view.findViewById(R.id.b5);
        RadioButton r_Lampu_Kabut_Fog_Lamp = (RadioButton) view.findViewById(R.id.r5);
        RadioButton t_Lampu_Kabut_Fog_Lamp = (RadioButton) view.findViewById(R.id.t5);
        RadioGroup rg_Lampu_Sign_Depan = (RadioGroup) view.findViewById(R.id.rgLampu_Sign_Depan);
        RadioButton b_Lampu_Sign_Depan = (RadioButton) view.findViewById(R.id.b6);
        RadioButton r_Lampu_Sign_Depan = (RadioButton) view.findViewById(R.id.r6);
        RadioButton t_Lampu_Sign_Depan = (RadioButton) view.findViewById(R.id.t6);
        RadioGroup rg_Lampu_Sign_Belakang = (RadioGroup) view.findViewById(R.id.rgLampu_Sign_Belakang);
        RadioButton b_Lampu_Sign_Belakang = (RadioButton) view.findViewById(R.id.b7);
        RadioButton r_Lampu_Sign_Belakang = (RadioButton) view.findViewById(R.id.r7);
        RadioButton t_Lampu_Sign_Belakang = (RadioButton) view.findViewById(R.id.t7);

        EditText te_Automatic_Light_Switch = (EditText) view.findViewById(R.id.teAutomatic_Light_Switch);
        EditText te_Lampu_Kecil = (EditText) view.findViewById(R.id.teLampu_Kecil);
        EditText te_Lampu_Dekat = (EditText) view.findViewById(R.id.teLampu_Dekat);
        EditText te_Lampu_Jauh = (EditText) view.findViewById(R.id.teLampu_Jauh);
        EditText te_Lampu_Kabut_Fog_Lamp = (EditText) view.findViewById(R.id.teLampu_Kabut_Fog_Lamp);
        EditText te_Lampu_Sign_Depan = (EditText) view.findViewById(R.id.teLampu_Sign_Depan);
        EditText te_Lampu_Sign_Belakang = (EditText) view.findViewById(R.id.teLampu_Sign_Belakang);


       if (model.Automatic_Light_Switch!= null)
        {
            te_Automatic_Light_Switch.setText(model.Automatic_Light_Switch_Ket);
            if ( model.Automatic_Light_Switch == "B")
            {b_Automatic_Light_Switch.setChecked(true);}
            else if ( model.Automatic_Light_Switch == "R")
            {r_Automatic_Light_Switch.setChecked(true);}
            else if ( model.Automatic_Light_Switch == "T")
            {t_Automatic_Light_Switch.setChecked(true);}
        }
        if (model.Lampu_Kecil!= null)
        {
            te_Lampu_Kecil.setText(model.Lampu_Kecil_Ket);
            if ( model.Lampu_Kecil == "B")
            {b_Lampu_Kecil.setChecked(true);}
            else if ( model.Lampu_Kecil == "R")
            {r_Lampu_Kecil.setChecked(true);}
            else if ( model.Lampu_Kecil == "T")
            {t_Lampu_Kecil.setChecked(true);}
        }
        if (model.Lampu_Dekat!= null)
        {
            te_Lampu_Dekat.setText(model.Lampu_Dekat_Ket);
            if ( model.Lampu_Dekat == "B")
            {b_Lampu_Dekat.setChecked(true);}
            else if ( model.Lampu_Dekat == "R")
            {r_Lampu_Dekat.setChecked(true);}
            else if ( model.Lampu_Dekat == "T")
            {t_Lampu_Dekat.setChecked(true);}
        }
        if (model.Lampu_Jauh!= null)
        {
            te_Lampu_Jauh.setText(model.Lampu_Jauh_Ket);
            if ( model.Lampu_Jauh == "B")
            {b_Lampu_Jauh.setChecked(true);}
            else if ( model.Lampu_Jauh == "R")
            {r_Lampu_Jauh.setChecked(true);}
            else if ( model.Lampu_Jauh == "T")
            {t_Lampu_Jauh.setChecked(true);}
        }
        if (model.Lampu_Kabut_Fog_Lamp!= null)
        {
            te_Lampu_Kabut_Fog_Lamp.setText(model.Lampu_Kabut_Fog_Lamp_Ket);
            if ( model.Lampu_Kabut_Fog_Lamp == "B")
            {b_Lampu_Kabut_Fog_Lamp.setChecked(true);}
            else if ( model.Lampu_Kabut_Fog_Lamp == "R")
            {r_Lampu_Kabut_Fog_Lamp.setChecked(true);}
            else if ( model.Lampu_Kabut_Fog_Lamp == "T")
            {t_Lampu_Kabut_Fog_Lamp.setChecked(true);}
        }
        if (model.Lampu_Sign_Depan!= null)
        {
            te_Lampu_Sign_Depan.setText(model.Lampu_Sign_Depan_Ket);
            if ( model.Lampu_Sign_Depan == "B")
            {b_Lampu_Sign_Depan.setChecked(true);}
            else if ( model.Lampu_Sign_Depan == "R")
            {r_Lampu_Sign_Depan.setChecked(true);}
            else if ( model.Lampu_Sign_Depan == "T")
            {t_Lampu_Sign_Depan.setChecked(true);}
        }
        if (model.Lampu_Sign_Belakang!= null)
        {
            te_Lampu_Sign_Belakang.setText(model.Lampu_Sign_Belakang_Ket);
            if ( model.Lampu_Sign_Belakang == "B")
            {b_Lampu_Sign_Belakang.setChecked(true);}
            else if ( model.Lampu_Sign_Belakang == "R")
            {r_Lampu_Sign_Belakang.setChecked(true);}
            else if ( model.Lampu_Sign_Belakang == "T")
            {t_Lampu_Sign_Belakang.setChecked(true);}
        }

        ImageButton button1 = (ImageButton) view.findViewById(R.id.button_next);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.Automatic_Light_Switch_Ket = te_Automatic_Light_Switch.getText().toString();
                model.Lampu_Kecil_Ket = te_Lampu_Kecil.getText().toString();
                model.Lampu_Dekat_Ket = te_Lampu_Dekat.getText().toString();
                model.Lampu_Jauh_Ket = te_Lampu_Jauh.getText().toString();
                model.Lampu_Kabut_Fog_Lamp_Ket = te_Lampu_Kabut_Fog_Lamp.getText().toString();
                model.Lampu_Sign_Depan_Ket = te_Lampu_Sign_Depan.getText().toString();
                model.Lampu_Sign_Belakang_Ket = te_Lampu_Sign_Belakang.getText().toString();

                if ( b_Automatic_Light_Switch.isChecked())
                {model.Automatic_Light_Switch = "B"; }
                else if ( r_Automatic_Light_Switch.isChecked())
                {model.Automatic_Light_Switch = "R";}
                else if ( t_Automatic_Light_Switch.isChecked())
                {model.Automatic_Light_Switch = "T";}

                if ( b_Lampu_Kecil.isChecked())
                {model.Lampu_Kecil = "B"; }
                else if ( r_Lampu_Kecil.isChecked())
                {model.Lampu_Kecil = "R";}
                else if ( t_Lampu_Kecil.isChecked())
                {model.Lampu_Kecil = "T";}

                if ( b_Lampu_Dekat.isChecked())
                {model.Lampu_Dekat = "B"; }
                else if ( r_Lampu_Dekat.isChecked())
                {model.Lampu_Dekat = "R";}
                else if ( t_Lampu_Dekat.isChecked())
                {model.Lampu_Dekat = "T";}

                if ( b_Lampu_Jauh.isChecked())
                {model.Lampu_Jauh = "B"; }
                else if ( r_Lampu_Jauh.isChecked())
                {model.Lampu_Jauh = "R";}
                else if ( t_Lampu_Jauh.isChecked())
                {model.Lampu_Jauh = "T";}

                if ( b_Lampu_Kabut_Fog_Lamp.isChecked())
                {model.Lampu_Kabut_Fog_Lamp = "B"; }
                else if ( r_Lampu_Kabut_Fog_Lamp.isChecked())
                {model.Lampu_Kabut_Fog_Lamp = "R";}
                else if ( t_Lampu_Kabut_Fog_Lamp.isChecked())
                {model.Lampu_Kabut_Fog_Lamp = "T";}

                if ( b_Lampu_Sign_Depan.isChecked())
                {model.Lampu_Sign_Depan = "B"; }
                else if ( r_Lampu_Sign_Depan.isChecked())
                {model.Lampu_Sign_Depan = "R";}
                else if ( t_Lampu_Sign_Depan.isChecked())
                {model.Lampu_Sign_Depan = "T";}

                if ( b_Lampu_Sign_Belakang.isChecked())
                {model.Lampu_Sign_Belakang = "B"; }
                else if ( r_Lampu_Sign_Belakang.isChecked())
                {model.Lampu_Sign_Belakang = "R";}
                else if ( t_Lampu_Sign_Belakang.isChecked())
                {model.Lampu_Sign_Belakang = "T";}

                next_Fragment(model); }
        });

        ImageButton button2 = (ImageButton) view.findViewById(R.id.button_back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                model.Automatic_Light_Switch_Ket = te_Automatic_Light_Switch.getText().toString();
                model.Lampu_Kecil_Ket = te_Lampu_Kecil.getText().toString();
                model.Lampu_Dekat_Ket = te_Lampu_Dekat.getText().toString();
                model.Lampu_Jauh_Ket = te_Lampu_Jauh.getText().toString();
                model.Lampu_Kabut_Fog_Lamp_Ket = te_Lampu_Kabut_Fog_Lamp.getText().toString();
                model.Lampu_Sign_Depan_Ket = te_Lampu_Sign_Depan.getText().toString();
                model.Lampu_Sign_Belakang_Ket = te_Lampu_Sign_Belakang.getText().toString();

                if ( b_Automatic_Light_Switch.isChecked())
                {model.Automatic_Light_Switch = "B"; }
                else if ( r_Automatic_Light_Switch.isChecked())
                {model.Automatic_Light_Switch = "R";}
                else if ( t_Automatic_Light_Switch.isChecked())
                {model.Automatic_Light_Switch = "T";}

                if ( b_Lampu_Kecil.isChecked())
                {model.Lampu_Kecil = "B"; }
                else if ( r_Lampu_Kecil.isChecked())
                {model.Lampu_Kecil = "R";}
                else if ( r_Lampu_Kecil.isChecked())
                {model.Lampu_Kecil = "T";}

                if ( b_Lampu_Dekat.isChecked())
                {model.Lampu_Dekat = "B"; }
                else if ( r_Lampu_Dekat.isChecked())
                {model.Lampu_Dekat = "R";}
                else if ( t_Lampu_Dekat.isChecked())
                {model.Lampu_Dekat = "T";}

                if ( b_Lampu_Jauh.isChecked())
                {model.Lampu_Jauh = "B"; }
                else if ( r_Lampu_Jauh.isChecked())
                {model.Lampu_Jauh = "R";}
                else if ( t_Lampu_Jauh.isChecked())
                {model.Lampu_Jauh = "T";}

                if ( b_Lampu_Kabut_Fog_Lamp.isChecked())
                {model.Lampu_Kabut_Fog_Lamp = "B"; }
                else if ( r_Lampu_Kabut_Fog_Lamp.isChecked())
                {model.Lampu_Kabut_Fog_Lamp = "R";}
                else if ( t_Lampu_Kabut_Fog_Lamp.isChecked())
                {model.Lampu_Kabut_Fog_Lamp = "T";}

                if ( b_Lampu_Sign_Depan.isChecked())
                {model.Lampu_Sign_Depan = "B"; }
                else if ( r_Lampu_Sign_Depan.isChecked())
                {model.Lampu_Sign_Depan = "R";}
                else if ( t_Lampu_Sign_Depan.isChecked())
                {model.Lampu_Sign_Depan = "T";}

                if ( b_Lampu_Sign_Belakang.isChecked())
                {model.Lampu_Sign_Belakang = "B"; }
                else if ( r_Lampu_Sign_Belakang.isChecked())
                {model.Lampu_Sign_Belakang = "R";}
                else if ( t_Lampu_Sign_Belakang.isChecked())
                {model.Lampu_Sign_Belakang = "T";}


                back_Fragment(); }
        });

        return view;
    }

    private void next_Fragment(Model model) {
        Fragment_Ceklis2 fragment = new Fragment_Ceklis2();
        fragment.model =  model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void back_Fragment() {
        Fragment_Input fragment = new Fragment_Input();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
