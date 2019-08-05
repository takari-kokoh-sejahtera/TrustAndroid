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

public class Fragment_Ceklis5 extends Fragment {

    public Model model = new Model();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment__ceklis5, container, false);

        RadioGroup rg_Wiper_Blade = (RadioGroup) view.findViewById(R.id.rgWiper_Blade);
        RadioButton b_Wiper_Blade = (RadioButton) view.findViewById(R.id.b29);
        RadioButton r_Wiper_Blade = (RadioButton) view.findViewById(R.id.r29);
        RadioButton t_Wiper_Blade = (RadioButton) view.findViewById(R.id.t29);
        RadioGroup rg_Windshield_Washer = (RadioGroup) view.findViewById(R.id.rgWindshield_Washer);
        RadioButton b_Windshield_Washer = (RadioButton) view.findViewById(R.id.b30);
        RadioButton r_Windshield_Washer = (RadioButton) view.findViewById(R.id.r30);
        RadioButton t_Windshield_Washer = (RadioButton) view.findViewById(R.id.t30);
        RadioGroup rg_Talang_Air = (RadioGroup) view.findViewById(R.id.rgTalang_Air);
        RadioButton b_Talang_Air = (RadioButton) view.findViewById(R.id.b31);
        RadioButton r_Talang_Air = (RadioButton) view.findViewById(R.id.r31);
        RadioButton t_Talang_Air = (RadioButton) view.findViewById(R.id.t31);
        RadioGroup rg_Fender_Lumpur = (RadioGroup) view.findViewById(R.id.rgFender_Lumpur_Depan_dan_Belakang);
        RadioButton b_Fender_Lumpur = (RadioButton) view.findViewById(R.id.b32);
        RadioButton r_Fender_Lumpur = (RadioButton) view.findViewById(R.id.r32);
        RadioButton t_Fender_Lumpur = (RadioButton) view.findViewById(R.id.t32);
        RadioGroup rg_Spion_Kiri_Kanan = (RadioGroup) view.findViewById(R.id.rgSpion_Kiri_Kanan);
        RadioButton b_Spion_Kiri_Kanan = (RadioButton) view.findViewById(R.id.b33);
        RadioButton r_Spion_Kiri_Kanan = (RadioButton) view.findViewById(R.id.r33);
        RadioButton t_Spion_Kiri_Kanan = (RadioButton) view.findViewById(R.id.t33);
        RadioGroup rg_Tutup_Bensin = (RadioGroup) view.findViewById(R.id.rgTutup_Bensin);
        RadioButton b_Tutup_Bensin = (RadioButton) view.findViewById(R.id.b34);
        RadioButton r_Tutup_Bensin = (RadioButton) view.findViewById(R.id.r34);
        RadioButton t_Tutup_Bensin = (RadioButton) view.findViewById(R.id.t34);
        RadioGroup rg_Emblem_Logo = (RadioGroup) view.findViewById(R.id.rgEmblem_Logo);
        RadioButton b_Emblem_Logo = (RadioButton) view.findViewById(R.id.b35);
        RadioButton r_Emblem_Logo = (RadioButton) view.findViewById(R.id.r35);
        RadioButton t_Emblem_Logo = (RadioButton) view.findViewById(R.id.t35);
        EditText te_Wiper_Blade = (EditText) view.findViewById(R.id.teWiper_Blade);
        EditText te_Windshield_Washer = (EditText) view.findViewById(R.id.teWindshield_Washer);
        EditText te_Talang_Air = (EditText) view.findViewById(R.id.teTalang_Air);
        EditText te_Fender_Lumpur = (EditText) view.findViewById(R.id.teFender_Lumpur_Depan_dan_Belakang);
        EditText te_Spion_Kiri_Kanan = (EditText) view.findViewById(R.id.teSpion_Kiri_Kanan);
        EditText te_Tutup_Bensin = (EditText) view.findViewById(R.id.teTutup_Bensin);
        EditText te_Emblem_Logo = (EditText) view.findViewById(R.id.teEmblem_Logo);

        if(model.Wiper_Blade!=null){
            te_Wiper_Blade.setText(model.Wiper_Blade_Ket);
            if(model.Wiper_Blade == "B"){
                b_Wiper_Blade.setChecked(true);
            }
            else if(model.Wiper_Blade == "R"){
                r_Wiper_Blade.setChecked(true);
            }
            else if(model.Wiper_Blade == "T"){
                t_Wiper_Blade.setChecked(true);
            }
        }
        if(model.Windshield_Washer!=null){
            te_Windshield_Washer.setText(model.Windshield_Washer_Ket);
            if(model.Windshield_Washer == "B"){
                b_Windshield_Washer.setChecked(true);
            }
            else if(model.Windshield_Washer == "R"){
                r_Windshield_Washer.setChecked(true);
            }
            else if(model.Windshield_Washer == "T"){
                t_Windshield_Washer.setChecked(true);
            }
        }
        if(model.Talang_Air!=null){
            te_Talang_Air.setText(model.Talang_Air_Ket);
            if (model.Talang_Air == "B") {
                b_Talang_Air.setChecked(true);
            }
            else if(model.Talang_Air == "R"){
                r_Talang_Air.setChecked(true);
            }
            else if(model.Talang_Air == "T"){
                t_Talang_Air.setChecked(true);
            }
        }
        if(model.Fender_Lumpur_Depan_dan_Belakang!=null){
            te_Fender_Lumpur.setText(model.Fender_Lumpur_Depan_dan_Belakang_Ket);
            if(model.Fender_Lumpur_Depan_dan_Belakang == "B"){
                b_Fender_Lumpur.setChecked(true);
            }
            else if(model.Fender_Lumpur_Depan_dan_Belakang == "R"){
                r_Fender_Lumpur.setChecked(true);
            }
            else if(model.Fender_Lumpur_Depan_dan_Belakang == "T"){
                t_Fender_Lumpur.setChecked(true);
            }
        }
        if(model.Spion_Kiri_Kanan!=null){
            te_Spion_Kiri_Kanan.setText(model.Spion_Kiri_Kanan_Ket);
            if(model.Spion_Kiri_Kanan == "B"){
                b_Spion_Kiri_Kanan.setChecked(true);
            }
            else if(model.Spion_Kiri_Kanan == "R"){
                r_Spion_Kiri_Kanan.setChecked(true);
            }
            else if(model.Spion_Kiri_Kanan == "T"){
                t_Spion_Kiri_Kanan.setChecked(true);
            }
        }
        if(model.Tutup_Bensin!=null){
            te_Tutup_Bensin.setText(model.Tutup_Bensin_Ket);
            if(model.Tutup_Bensin == "B"){
                b_Tutup_Bensin.setChecked(true);
            }
            else if(model.Tutup_Bensin == "R"){
                r_Tutup_Bensin.setChecked(true);
            }
            else if(model.Tutup_Bensin == "T"){
                t_Tutup_Bensin.setChecked(true);
            }
        }
        if(model.Emblem_Logo!=null){
            te_Emblem_Logo.setText(model.Emblem_Logo_Ket);
            if(model.Emblem_Logo == "B"){
                b_Emblem_Logo.setChecked(true);
            }
            else if(model.Emblem_Logo == "R"){
                r_Emblem_Logo.setChecked(true);
            }
            else if(model.Emblem_Logo == "T"){
                t_Emblem_Logo.setChecked(true);
            }
        }

        ImageButton button1 = (ImageButton) view.findViewById(R.id.button_ceklis);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.Wiper_Blade_Ket = te_Wiper_Blade.getText().toString();
                model.Windshield_Washer_Ket = te_Windshield_Washer.getText().toString();
                model.Talang_Air_Ket = te_Talang_Air.getText().toString();
                model.Fender_Lumpur_Depan_dan_Belakang_Ket = te_Fender_Lumpur.getText().toString();
                model.Spion_Kiri_Kanan_Ket = te_Spion_Kiri_Kanan.getText().toString();
                model.Tutup_Bensin_Ket = te_Tutup_Bensin.getText().toString();
                model.Emblem_Logo_Ket = te_Emblem_Logo.getText().toString();

                if(b_Wiper_Blade.isChecked()){
                    model.Wiper_Blade = "B";
                }
                else if(r_Wiper_Blade.isChecked()){
                    model.Wiper_Blade = "R";
                }
                else if(t_Wiper_Blade.isChecked()){
                    model.Wiper_Blade = "T";
                }

                if(b_Windshield_Washer.isChecked()){
                    model.Windshield_Washer = "B";
                }
                else if(r_Windshield_Washer.isChecked()){
                    model.Windshield_Washer = "R";
                }
                else if(t_Windshield_Washer.isChecked()){
                    model.Windshield_Washer = "T";
                }

                if(b_Talang_Air.isChecked()){
                    model.Talang_Air = "B";
                }
                else if(r_Talang_Air.isChecked()){
                    model.Talang_Air = "R";
                }
                else if(t_Talang_Air.isChecked()){
                    model.Talang_Air = "T";
                }

                if(b_Fender_Lumpur.isChecked()){
                    model.Fender_Lumpur_Depan_dan_Belakang = "B";
                }
                else if(r_Fender_Lumpur.isChecked()){
                    model.Fender_Lumpur_Depan_dan_Belakang = "R";
                }
                else if(t_Fender_Lumpur.isChecked()){
                    model.Fender_Lumpur_Depan_dan_Belakang = "T";
                }

                if(b_Spion_Kiri_Kanan.isChecked()){
                    model.Spion_Kiri_Kanan = "B";
                }
                else if(r_Spion_Kiri_Kanan.isChecked()){
                    model.Spion_Kiri_Kanan = "R";
                }
                else if(t_Spion_Kiri_Kanan.isChecked()){
                    model.Spion_Kiri_Kanan = "T";
                }

                if(b_Tutup_Bensin.isChecked()){
                    model.Tutup_Bensin = "B";
                }
                else if(r_Tutup_Bensin.isChecked()){
                    model.Tutup_Bensin = "R";
                }
                else if(t_Tutup_Bensin.isChecked()){
                    model.Tutup_Bensin = "T";
                }

                if(b_Emblem_Logo.isChecked()){
                    model.Emblem_Logo = "B";
                }
                else if(r_Emblem_Logo.isChecked()){
                    model.Emblem_Logo = "R";
                }
                else if(t_Emblem_Logo.isChecked()){
                    model.Emblem_Logo = "T";
                }

                next_Fragment(model); }
        });

        ImageButton button2 = (ImageButton) view.findViewById(R.id.button_Back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.Wiper_Blade_Ket = te_Wiper_Blade.getText().toString();
                model.Windshield_Washer_Ket = te_Windshield_Washer.getText().toString();
                model.Talang_Air_Ket = te_Talang_Air.getText().toString();
                model.Fender_Lumpur_Depan_dan_Belakang_Ket = te_Fender_Lumpur.getText().toString();
                model.Spion_Kiri_Kanan_Ket = te_Spion_Kiri_Kanan.getText().toString();
                model.Tutup_Bensin_Ket = te_Tutup_Bensin.getText().toString();
                model.Emblem_Logo_Ket = te_Emblem_Logo.getText().toString();

                if(b_Wiper_Blade.isChecked()){
                    model.Wiper_Blade = "B";
                }
                else if(r_Wiper_Blade.isChecked()){
                    model.Wiper_Blade = "R";
                }
                else if(t_Wiper_Blade.isChecked()){
                    model.Wiper_Blade = "T";
                }

                if(b_Windshield_Washer.isChecked()){
                    model.Windshield_Washer = "B";
                }
                else if(r_Windshield_Washer.isChecked()){
                    model.Windshield_Washer = "R";
                }
                else if(t_Windshield_Washer.isChecked()){
                    model.Windshield_Washer = "T";
                }

                if(b_Talang_Air.isChecked()){
                    model.Talang_Air = "B";
                }
                else if(r_Talang_Air.isChecked()){
                    model.Talang_Air = "R";
                }
                else if(t_Talang_Air.isChecked()){
                    model.Talang_Air = "T";
                }

                if(b_Fender_Lumpur.isChecked()){
                    model.Fender_Lumpur_Depan_dan_Belakang = "B";
                }
                else if(r_Fender_Lumpur.isChecked()){
                    model.Fender_Lumpur_Depan_dan_Belakang = "R";
                }
                else if(t_Fender_Lumpur.isChecked()){
                    model.Fender_Lumpur_Depan_dan_Belakang = "T";
                }

                if(b_Spion_Kiri_Kanan.isChecked()){
                    model.Spion_Kiri_Kanan = "B";
                }
                else if(r_Spion_Kiri_Kanan.isChecked()){
                    model.Spion_Kiri_Kanan = "R";
                }
                else if(t_Spion_Kiri_Kanan.isChecked()){
                    model.Spion_Kiri_Kanan = "T";
                }

                if(b_Tutup_Bensin.isChecked()){
                    model.Tutup_Bensin = "B";
                }
                else if(r_Tutup_Bensin.isChecked()){
                    model.Tutup_Bensin = "R";
                }
                else if(t_Tutup_Bensin.isChecked()){
                    model.Tutup_Bensin = "T";
                }

                if(b_Emblem_Logo.isChecked()){
                    model.Emblem_Logo = "B";
                }
                else if(r_Emblem_Logo.isChecked()){
                    model.Emblem_Logo = "R";
                }
                else if(t_Emblem_Logo.isChecked()){
                    model.Emblem_Logo = "T";
                }

                back_Fragment(); }
        });

        return view;
    }
    private void next_Fragment(Model model) {
        Fragment_Ceklis6 fragment = new Fragment_Ceklis6();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void back_Fragment() {
        Fragment_Ceklis4 fragment = new Fragment_Ceklis4();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
