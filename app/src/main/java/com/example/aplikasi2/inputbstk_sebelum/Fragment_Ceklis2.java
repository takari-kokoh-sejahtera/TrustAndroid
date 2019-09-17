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


public class Fragment_Ceklis2 extends Fragment {

    public Model model = new Model();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment__ceklis2, container, false);


        RadioGroup rg_Lampu_Belakang = (RadioGroup) view.findViewById(R.id.rgLampu_Belakang);
        final RadioButton b_Lampu_Belakang = (RadioButton) view.findViewById(R.id.b8);
        final RadioButton r_Lampu_Belakang = (RadioButton) view.findViewById(R.id.r8);
        final RadioButton t_Lampu_Belakang = (RadioButton) view.findViewById(R.id.t8);
        RadioGroup rg_Lampu_Rem = (RadioGroup) view.findViewById(R.id.rgLampu_Rem);
        final RadioButton b_Lampu_Rem = (RadioButton) view.findViewById(R.id.b9);
        final RadioButton r_Lampu_Rem = (RadioButton) view.findViewById(R.id.r9);
        final RadioButton t_Lampu_Rem = (RadioButton) view.findViewById(R.id.t9);
        RadioGroup rg_Lampu_Mundur = (RadioGroup) view.findViewById(R.id.rgLampu_Mundur);
        final RadioButton b_Lampu_Mundur = (RadioButton) view.findViewById(R.id.b10);
        final RadioButton r_Lampu_Mundur = (RadioButton) view.findViewById(R.id.r10);
        final RadioButton t_Lampu_Mundur = (RadioButton) view.findViewById(R.id.t10);
        RadioGroup rg_Lampu_Dashboard = (RadioGroup) view.findViewById(R.id.rgLampu_Dashboard);
        final RadioButton b_Lampu_Dashboard = (RadioButton) view.findViewById(R.id.b11);
        final RadioButton r_Lampu_Dashboard = (RadioButton) view.findViewById(R.id.r11);
        final RadioButton t_Lampu_Dashboard = (RadioButton) view.findViewById(R.id.t11);
        RadioGroup rg_Lampu_Plafond_Depan = (RadioGroup) view.findViewById(R.id.rgLampu_Plafond_Depan_dan_Belakang);
        final RadioButton b_Lampu_Plafond_Depan = (RadioButton) view.findViewById(R.id.b12);
        final RadioButton r_Lampu_Plafond_Depan = (RadioButton) view.findViewById(R.id.r12);
        final RadioButton t_Lampu_Plafond_Depan = (RadioButton) view.findViewById(R.id.t12);
        RadioGroup rg_Klakson = (RadioGroup) view.findViewById(R.id.rgKlakson);
        final RadioButton b_Klakson = (RadioButton) view.findViewById(R.id.b13);
        final RadioButton r_Klakson = (RadioButton) view.findViewById(R.id.r13);
        final RadioButton t_Klakson = (RadioButton) view.findViewById(R.id.t13);
        RadioGroup rg_Antena = (RadioGroup) view.findViewById(R.id.rgAntena);
        final RadioButton b_Antena = (RadioButton) view.findViewById(R.id.b14);
        final RadioButton r_Antena = (RadioButton) view.findViewById(R.id.r14);
        final RadioButton t_Antena = (RadioButton) view.findViewById(R.id.t14);
        final EditText te_Lampu_Belakang = (EditText) view.findViewById(R.id.teLampu_Belakang);
        final EditText te_Lampu_Rem = (EditText) view.findViewById(R.id.teLampu_Rem);
        final EditText te_Lampu_Mundur = (EditText) view.findViewById(R.id.teLampu_Mundur);
        final EditText te_Lampu_Dashboard = (EditText) view.findViewById(R.id.teLampu_Dashboard);
        final EditText te_Lampu_Plafond_Depan = (EditText) view.findViewById(R.id.teLampu_Plafond_Depan_dan_Belakang);
        final EditText te_Klakson = (EditText) view.findViewById(R.id.teKlakson);
        final EditText te_Antena = (EditText) view.findViewById(R.id.teAntena);

        if(model.Lampu_Belakang!=null){
            te_Lampu_Belakang.setText(model.Lampu_Belakang_Ket);
            if(model.Lampu_Belakang.equals("B")){
                b_Lampu_Belakang.setChecked(true);
            }
            else if(model.Lampu_Belakang.equals("R")){
                r_Lampu_Belakang.setChecked(true);
            }
            else if(model.Lampu_Belakang.equals("T")){
                t_Lampu_Belakang.setChecked(true);
            }
        }
        if(model.Lampu_Rem!=null){
            te_Lampu_Rem.setText(model.Lampu_Rem_Ket);
            if(model.Lampu_Rem.equals("B")){
                b_Lampu_Rem.setChecked(true);
            }
            else if(model.Lampu_Rem.equals("R")){
                r_Lampu_Rem.setChecked(true);
            }
            else if(model.Lampu_Rem.equals("T")){
                t_Lampu_Rem.setChecked(true);
            }
        }
        if(model.Lampu_Mundur!=null){
            te_Lampu_Mundur.setText(model.Lampu_Mundur_Ket);
            if(model.Lampu_Mundur.equals("B")){
                b_Lampu_Mundur.setChecked(true);
            }
            if(model.Lampu_Mundur.equals("R")){
                r_Lampu_Mundur.setChecked(true);
            }
            if(model.Lampu_Mundur.equals("T")){
                t_Lampu_Mundur.setChecked(true);
            }
        }
        if(model.Lampu_Dashboard!=null){
            te_Lampu_Dashboard.setText(model.Lampu_Dashboard_Ket);
            if(model.Lampu_Dashboard.equals("B")){
                b_Lampu_Dashboard.setChecked(true);
            }
            if(model.Lampu_Dashboard.equals("R")){
                r_Lampu_Dashboard.setChecked(true);
            }
            if(model.Lampu_Dashboard.equals("T")){
                t_Lampu_Dashboard.setChecked(true);
            }
        }
        if(model.Lampu_Plafond_Depan_dan_Belakang!=null){
            te_Lampu_Plafond_Depan.setText(model.Lampu_Plafond_Depan_dan_Belakang_Ket);
            if(model.Lampu_Plafond_Depan_dan_Belakang.equals("B")){
                b_Lampu_Plafond_Depan.setChecked(true);
            }
            if(model.Lampu_Plafond_Depan_dan_Belakang.equals("R")){
                r_Lampu_Plafond_Depan.setChecked(true);
            }
            if(model.Lampu_Plafond_Depan_dan_Belakang.equals("T")){
                t_Lampu_Plafond_Depan.setChecked(true);
            }
        }
        if(model.Klakson!=null){
            te_Klakson.setText(model.Klakson_Ket);
            if(model.Klakson.equals("B")){
                b_Klakson.setChecked(true);
            }
            if(model.Klakson.equals("R")){
                r_Klakson.setChecked(true);
            }
            if(model.Klakson.equals("T")){
                t_Klakson.setChecked(true);
            }
        }
        if(model.Antena!=null){
            te_Antena.setText(model.Antena_Ket);
            if(model.Antena.equals("B")){
                b_Antena.setChecked(true);
            }
            if(model.Antena.equals("R")){
                r_Antena.setChecked(true);
            }
            if(model.Antena.equals("T")){
                t_Antena.setChecked(true);
            }
        }


        ImageButton button1 = (ImageButton) view.findViewById(R.id.button_ceklis);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.Lampu_Belakang_Ket = te_Lampu_Belakang.getText().toString();
                model.Lampu_Rem_Ket = te_Lampu_Rem.getText().toString();
                model.Lampu_Mundur_Ket = te_Lampu_Mundur.getText().toString();
                model.Lampu_Dashboard_Ket = te_Lampu_Dashboard.getText().toString();
                model.Lampu_Plafond_Depan_dan_Belakang_Ket = te_Lampu_Plafond_Depan.getText().toString();
                model.Klakson_Ket = te_Klakson.getText().toString();
                model.Antena_Ket = te_Antena.getText().toString();

                if(b_Lampu_Belakang.isChecked()){
                    model.Lampu_Belakang = "B";
                }
                else if (r_Lampu_Belakang.isChecked()){
                    model.Lampu_Belakang = "R";
                }
                else if (t_Lampu_Belakang.isChecked()){
                    model.Lampu_Belakang = "T";
                }

                if(b_Lampu_Rem.isChecked()){
                    model.Lampu_Rem = "B";
                }
                else if(r_Lampu_Rem.isChecked()){
                    model.Lampu_Rem = "R";
                }
                else if(t_Lampu_Rem.isChecked()){
                    model.Lampu_Rem = "T";
                }

                if(b_Lampu_Mundur.isChecked()){
                    model.Lampu_Mundur = "B";
                }
                else if(r_Lampu_Mundur.isChecked()){
                    model.Lampu_Mundur = "R";
                }
                else if(t_Lampu_Mundur.isChecked()){
                    model.Lampu_Mundur ="T";
                }

                if(b_Lampu_Dashboard.isChecked()){
                    model.Lampu_Dashboard = "B";
                }
                else if(r_Lampu_Dashboard.isChecked()){
                    model.Lampu_Dashboard = "R";
                }
                else if(t_Lampu_Dashboard.isChecked()){
                    model.Lampu_Dashboard = "T";
                }

                if(b_Lampu_Plafond_Depan.isChecked()){
                    model.Lampu_Plafond_Depan_dan_Belakang = "B";
                }
                else if(r_Lampu_Plafond_Depan.isChecked()){
                    model.Lampu_Plafond_Depan_dan_Belakang = "R";
                }
                else if(t_Lampu_Plafond_Depan.isChecked()){
                    model.Lampu_Plafond_Depan_dan_Belakang = "T";
                }

                if(b_Klakson.isChecked()){
                    model.Klakson = "B";
                }
                else if(r_Klakson.isChecked()){
                    model.Klakson = "R";
                }
                else if(t_Klakson.isChecked()){
                    model.Klakson = "T";
                }

                if(b_Antena.isChecked()){
                    model.Antena = "B";
                }
                else if(r_Antena.isChecked()){
                    model.Antena = "R";
                }
                else if(t_Antena.isChecked()){
                    model.Antena = "T";
                }

                next_Fragment(model); }
        });

        ImageButton button2 = (ImageButton) view.findViewById(R.id.button_Back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.Lampu_Belakang_Ket = te_Lampu_Belakang.getText().toString();
                model.Lampu_Rem_Ket = te_Lampu_Rem.getText().toString();
                model.Lampu_Mundur_Ket = te_Lampu_Mundur.getText().toString();
                model.Lampu_Dashboard_Ket = te_Lampu_Dashboard.getText().toString();
                model.Lampu_Plafond_Depan_dan_Belakang_Ket = te_Lampu_Plafond_Depan.getText().toString();
                model.Klakson_Ket = te_Klakson.getText().toString();
                model.Antena_Ket = te_Antena.getText().toString();

                if(b_Lampu_Belakang.isChecked()){
                    model.Lampu_Belakang = "B";
                }
                else if (r_Lampu_Belakang.isChecked()){
                    model.Lampu_Belakang = "R";
                }
                else if (t_Lampu_Belakang.isChecked()){
                    model.Lampu_Belakang = "T";
                }

                if(b_Lampu_Rem.isChecked()){
                    model.Lampu_Rem = "B";
                }
                else if(r_Lampu_Rem.isChecked()){
                    model.Lampu_Rem = "R";
                }
                else if(t_Lampu_Rem.isChecked()){
                    model.Lampu_Rem = "T";
                }

                if(b_Lampu_Mundur.isChecked()){
                    model.Lampu_Mundur = "B";
                }
                else if(r_Lampu_Mundur.isChecked()){
                    model.Lampu_Mundur = "R";
                }
                else if(t_Lampu_Mundur.isChecked()){
                    model.Lampu_Mundur ="T";
                }

                if(b_Lampu_Dashboard.isChecked()){
                    model.Lampu_Dashboard = "B";
                }
                else if(r_Lampu_Dashboard.isChecked()){
                    model.Lampu_Dashboard = "R";
                }
                else if(t_Lampu_Dashboard.isChecked()){
                    model.Lampu_Dashboard = "T";
                }

                if(b_Lampu_Plafond_Depan.isChecked()){
                    model.Lampu_Plafond_Depan_dan_Belakang = "B";
                }
                else if(r_Lampu_Plafond_Depan.isChecked()){
                    model.Lampu_Plafond_Depan_dan_Belakang = "R";
                }
                else if(t_Lampu_Plafond_Depan.isChecked()){
                    model.Lampu_Plafond_Depan_dan_Belakang = "T";
                }

                if(b_Klakson.isChecked()){
                    model.Klakson = "B";
                }
                else if(r_Klakson.isChecked()){
                    model.Klakson = "R";
                }
                else if(t_Klakson.isChecked()){
                    model.Klakson = "T";
                }

                if(b_Antena.isChecked()){
                    model.Antena = "B";
                }
                else if(r_Antena.isChecked()){
                    model.Antena = "R";
                }
                else if(t_Antena.isChecked()){
                    model.Antena = "T";
                }

                back_Fragment(); }
        });

        return view;
    }
    private void next_Fragment(Model model) {
        Fragment_Ceklis3 fragment = new Fragment_Ceklis3();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void back_Fragment() {
        Fragment_Ceklis fragment = new Fragment_Ceklis();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
