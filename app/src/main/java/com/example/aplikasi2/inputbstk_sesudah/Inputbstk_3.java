package com.example.aplikasi2.inputbstk_sesudah;

import android.content.Context;
import android.net.Uri;
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
import com.example.aplikasi2.inputbstk_sebelum.Fragment_Ceklis2;
import com.example.aplikasi2.inputbstk_sebelum.Fragment_Ceklis4;
import com.example.aplikasi2.inputbstk_sebelum.Model;

public class Inputbstk_3 extends Fragment {
    public Modelbstk model = new Modelbstk();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inputbstk_3, container, false);

        RadioGroup rg_Tape_Radio = (RadioGroup) view.findViewById(R.id.rgTape_Radio_CD_DVD_TV_Player);
        final RadioButton b_Tape_Radio = (RadioButton) view.findViewById(R.id.b15);
        final RadioButton r_Tape_Radio = (RadioButton) view.findViewById(R.id.r15);
        final RadioButton t_Tape_Radio = (RadioButton) view.findViewById(R.id.t15);
        RadioGroup rg_Remote_Tape = (RadioGroup) view.findViewById(R.id.rgRemote_Tape_Radio_CD_DVD_TV_Player);
        final RadioButton b_Remote_Tape = (RadioButton) view.findViewById(R.id.b16);
        final RadioButton r_Remote_Tape = (RadioButton) view.findViewById(R.id.r16);
        final RadioButton t_Remote_Tape = (RadioButton) view.findViewById(R.id.t16);
        RadioGroup rg_Alarm_Remote_Key = (RadioGroup) view.findViewById(R.id.rgAlarm_Remote_Key);
        final RadioButton b_Alarm_Remote_Key = (RadioButton) view.findViewById(R.id.b17);
        final RadioButton r_Alarm_Remote_Key = (RadioButton) view.findViewById(R.id.r17);
        final RadioButton t_Alarm_Remote_Key = (RadioButton) view.findViewById(R.id.t17);
        RadioGroup rg_Central_Lock = (RadioGroup) view.findViewById(R.id.rgCentral_Lock);
        final RadioButton b_Central_Lock = (RadioButton) view.findViewById(R.id.b18);
        final RadioButton r_Central_Lock = (RadioButton) view.findViewById(R.id.r18);
        final RadioButton t_Central_Lock = (RadioButton) view.findViewById(R.id.t18);
        RadioGroup rg_Power_Window = (RadioGroup) view.findViewById(R.id.rgPower_Window);
        final RadioButton b_Power_Window = (RadioButton) view.findViewById(R.id.b19);
        final RadioButton r_Power_Window = (RadioButton) view.findViewById(R.id.r19);
        final RadioButton t_Power_Window = (RadioButton) view.findViewById(R.id.t19);
        RadioGroup rg_Switch_Mirror = (RadioGroup) view.findViewById(R.id.rgSwitch_Mirror);
        final RadioButton b_Switch_Mirror = (RadioButton) view.findViewById(R.id.b20);
        final RadioButton r_Switch_Mirror = (RadioButton) view.findViewById(R.id.r20);
        final RadioButton t_Switch_Mirror = (RadioButton) view.findViewById(R.id.t20);
        RadioGroup rgAir_Conditioner = (RadioGroup) view.findViewById(R.id.rgAir_Conditioner);
        final RadioButton b_Air_Conditioner = (RadioButton) view.findViewById(R.id.b21);
        final RadioButton r_Air_Conditioner = (RadioButton) view.findViewById(R.id.r21);
        final RadioButton t_Air_Conditioner = (RadioButton) view.findViewById(R.id.t21);
        final EditText te_Tape_Radio = (EditText) view.findViewById(R.id.teTape_Radio_CD_DVD_TV_Player);
        final EditText te_Remote_Tape = (EditText) view.findViewById(R.id.teRemote_Tape_Radio_CD_DVD_TV_Player);
        final EditText te_Alarm_Remote_Key = (EditText) view.findViewById(R.id.teAlarm_Remote_Key);
        final EditText te_Central_Lock = (EditText) view.findViewById(R.id.teCentral_Lock);
        final EditText te_Power_Window = (EditText) view.findViewById(R.id.tePower_Window);
        final EditText te_Switch_Mirror = (EditText) view.findViewById(R.id.teSwitch_Mirror);
        final EditText te_Air_Conditioner = (EditText) view.findViewById(R.id.teAir_Conditioner);

        if(model.Tape_Radio_CD_DVD_TV_Player!=null){
            te_Tape_Radio.setText(model.Tape_Radio_CD_DVD_TV_Player_Ket);
            if(model.Tape_Radio_CD_DVD_TV_Player.equals("B")){
                b_Tape_Radio.setChecked(true);
            }
            else if(model.Tape_Radio_CD_DVD_TV_Player.equals("R")){
                r_Tape_Radio.setChecked(true);
            }
            else if (model.Tape_Radio_CD_DVD_TV_Player.equals("T")){
                t_Tape_Radio.setChecked(true);
            }
        }
        if (model.Remote_Tape_Radio_CD_DVD_TV_Player!=null){
            te_Remote_Tape.setText(model.Remote_Tape_Radio_CD_DVD_TV_Player_Ket);
            if(model.Remote_Tape_Radio_CD_DVD_TV_Player.equals("B")){
                b_Remote_Tape.setChecked(true);
            }
            else if(model.Remote_Tape_Radio_CD_DVD_TV_Player.equals("R")){
                r_Remote_Tape.setChecked(true);
            }
            else if (model.Remote_Tape_Radio_CD_DVD_TV_Player.equals("T")){
                t_Remote_Tape.setChecked(true);
            }
        }
        if (model.Alarm_Remote_Key!=null){
            te_Alarm_Remote_Key.setText(model.Alarm_Remote_Key_Ket);
            if(model.Alarm_Remote_Key.equals("B")){
                b_Alarm_Remote_Key.setChecked(true);
            }
            else if(model.Alarm_Remote_Key.equals("R")){
                r_Alarm_Remote_Key.setChecked(true);
            }
            else if(model.Alarm_Remote_Key.equals("T")){
                t_Alarm_Remote_Key.setChecked(true);
            }
        }
        if(model.Central_Lock!=null){
            te_Central_Lock.setText(model.Central_Lock_Ket);
            if(model.Central_Lock.equals("B")){
                b_Central_Lock.setChecked(true);
            }
            else if(model.Central_Lock.equals("R")){
                r_Central_Lock.setChecked(true);
            }
            else if(model.Central_Lock.equals("T")){
                t_Central_Lock.setChecked(true);
            }
        }
        if(model.Power_Window!=null){
            te_Power_Window.setText(model.Power_Window_Ket);
            if(model.Power_Window.equals("B")){
                b_Power_Window.setChecked(true);
            }
            else if(model.Power_Window.equals("R")){
                r_Power_Window.setChecked(true);
            }
            else if(model.Power_Window.equals("T")){
                t_Power_Window.setChecked(true);
            }
        }
        if(model.Switch_Mirror!=null){
            te_Switch_Mirror.setText(model.Switch_Mirror_Ket);
            if(model.Switch_Mirror.equals("B")){
                b_Switch_Mirror.setChecked(true);
            }
            else if(model.Switch_Mirror.equals("R")){
                r_Switch_Mirror.setChecked(true);
            }
            else if(model.Switch_Mirror.equals("T")){
                t_Switch_Mirror.setChecked(true);
            }
        }
        if(model.Air_Conditioner!=null){
            te_Air_Conditioner.setText(model.Air_Conditioner_Ket);
            if(model.Air_Conditioner.equals("B")){
                b_Air_Conditioner.setChecked(true);
            }
            else if(model.Air_Conditioner.equals("R")){
                r_Air_Conditioner.setChecked(true);
            }
            else if(model.Air_Conditioner.equals("T")){
                t_Air_Conditioner.setChecked(true);
            }

        }

        ImageButton button1 = (ImageButton) view.findViewById(R.id.button_ceklis);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.Tape_Radio_CD_DVD_TV_Player_Ket = te_Tape_Radio.getText().toString();
                model.Remote_Tape_Radio_CD_DVD_TV_Player_Ket = te_Remote_Tape.getText(). toString();
                model.Alarm_Remote_Key_Ket = te_Alarm_Remote_Key.getText().toString();
                model.Central_Lock_Ket = te_Central_Lock.getText().toString();
                model.Power_Window_Ket = te_Power_Window.getText().toString();
                model.Switch_Mirror_Ket = te_Switch_Mirror.getText().toString();
                model.Air_Conditioner_Ket = te_Air_Conditioner.getText().toString();

                if(b_Tape_Radio.isChecked()){
                    model.Tape_Radio_CD_DVD_TV_Player = "B";
                }
                else if(r_Tape_Radio.isChecked()){
                    model.Tape_Radio_CD_DVD_TV_Player = "R";
                }
                else if(t_Tape_Radio.isChecked()){
                    model.Tape_Radio_CD_DVD_TV_Player = "T";
                }

                if(b_Remote_Tape.isChecked()){
                    model.Remote_Tape_Radio_CD_DVD_TV_Player = "B";
                }
                else if(r_Remote_Tape.isChecked()){
                    model.Remote_Tape_Radio_CD_DVD_TV_Player = "R";
                }
                else if(t_Remote_Tape.isChecked()){
                    model.Remote_Tape_Radio_CD_DVD_TV_Player = "T";
                }

                if(b_Alarm_Remote_Key.isChecked()){
                    model.Alarm_Remote_Key = "B";
                }
                else if(r_Alarm_Remote_Key.isChecked()){
                    model.Alarm_Remote_Key = "R";
                }
                else if(t_Alarm_Remote_Key.isChecked()){
                    model.Alarm_Remote_Key = "T";
                }

                if(b_Central_Lock.isChecked()){
                    model.Central_Lock = "B";
                }
                else if(r_Central_Lock.isChecked()){
                    model.Central_Lock = "R";
                }
                else if(t_Central_Lock.isChecked()){
                    model.Central_Lock = "T";
                }

                if(b_Power_Window.isChecked()){
                    model.Power_Window = "B";
                }
                else if(r_Power_Window.isChecked()){
                    model.Power_Window = "R";
                }
                else if(t_Power_Window.isChecked()){
                    model.Power_Window = "T";
                }

                if(b_Switch_Mirror.isChecked()){
                    model.Switch_Mirror = "B";
                }
                else if(r_Switch_Mirror.isChecked()){
                    model.Switch_Mirror = "R";
                }
                else if(t_Switch_Mirror.isChecked()){
                    model.Switch_Mirror = "T";
                }

                if(b_Air_Conditioner.isChecked()){
                    model.Air_Conditioner = "B";
                }
                else if(r_Air_Conditioner.isChecked()){
                    model.Air_Conditioner = "R";
                }
                else if(t_Air_Conditioner.isChecked()){
                    model.Air_Conditioner = "T";
                }

                next_Fragment(model); }
        });

        ImageButton button2 = (ImageButton) view.findViewById(R.id.button_Back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model.Tape_Radio_CD_DVD_TV_Player_Ket = te_Tape_Radio.getText().toString();
                model.Remote_Tape_Radio_CD_DVD_TV_Player_Ket = te_Remote_Tape.getText(). toString();
                model.Alarm_Remote_Key_Ket = te_Alarm_Remote_Key.getText().toString();
                model.Central_Lock_Ket = te_Central_Lock.getText().toString();
                model.Power_Window_Ket = te_Power_Window.getText().toString();
                model.Switch_Mirror_Ket = te_Switch_Mirror.getText().toString();
                model.Air_Conditioner_Ket = te_Air_Conditioner.getText().toString();

                if(b_Tape_Radio.isChecked()){
                    model.Tape_Radio_CD_DVD_TV_Player = "B";
                }
                else if(r_Tape_Radio.isChecked()){
                    model.Tape_Radio_CD_DVD_TV_Player = "R";
                }
                else if(t_Tape_Radio.isChecked()){
                    model.Tape_Radio_CD_DVD_TV_Player = "T";
                }

                if(b_Remote_Tape.isChecked()){
                    model.Remote_Tape_Radio_CD_DVD_TV_Player = "B";
                }
                else if(r_Remote_Tape.isChecked()){
                    model.Remote_Tape_Radio_CD_DVD_TV_Player = "R";
                }
                else if(t_Remote_Tape.isChecked()){
                    model.Remote_Tape_Radio_CD_DVD_TV_Player = "T";
                }

                if(b_Alarm_Remote_Key.isChecked()){
                    model.Alarm_Remote_Key = "B";
                }
                else if(r_Alarm_Remote_Key.isChecked()){
                    model.Alarm_Remote_Key = "R";
                }
                else if(t_Alarm_Remote_Key.isChecked()){
                    model.Alarm_Remote_Key = "T";
                }

                if(b_Central_Lock.isChecked()){
                    model.Central_Lock = "B";
                }
                else if(r_Central_Lock.isChecked()){
                    model.Central_Lock = "R";
                }
                else if(t_Central_Lock.isChecked()){
                    model.Central_Lock = "T";
                }

                if(b_Power_Window.isChecked()){
                    model.Power_Window = "B";
                }
                else if(r_Power_Window.isChecked()){
                    model.Power_Window = "R";
                }
                else if(t_Power_Window.isChecked()){
                    model.Power_Window = "T";
                }

                if(b_Switch_Mirror.isChecked()){
                    model.Switch_Mirror = "B";
                }
                else if(r_Switch_Mirror.isChecked()){
                    model.Switch_Mirror = "R";
                }
                else if(t_Switch_Mirror.isChecked()){
                    model.Switch_Mirror = "T";
                }

                if(b_Air_Conditioner.isChecked()){
                    model.Air_Conditioner = "B";
                }
                else if(r_Air_Conditioner.isChecked()){
                    model.Air_Conditioner = "R";
                }
                else if(t_Air_Conditioner.isChecked()){
                    model.Air_Conditioner = "T";
                }


                back_Fragment(); }
        });

        return view;
    }
    private void next_Fragment(Modelbstk model) {
        Inputbstk_4 fragment = new Inputbstk_4();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void back_Fragment() {
        Inputbstk_2 fragment = new Inputbstk_2();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
