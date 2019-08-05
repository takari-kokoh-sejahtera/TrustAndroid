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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.aplikasi2.R;
import com.example.aplikasi2.inputbstk_sebelum.Fragment_Camera;
import com.example.aplikasi2.inputbstk_sebelum.Fragment_Ceklis7;
import com.example.aplikasi2.inputbstk_sebelum.Model;

public class Inputbstk_8 extends Fragment {
    public Modelbstk model = new Modelbstk();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inputbstk_8, container, false);

        Spinner spinner_appar = (Spinner) view.findViewById(R.id.spinner_apar);
        Spinner spinner_fuel = (Spinner) view.findViewById(R.id.spinner_fuel);
        Spinner spinner_velg_ban = (Spinner) view.findViewById(R.id.spinner_velg_ban);
        Spinner spinner_tutup_dop = (Spinner) view.findViewById(R.id.spinner_velg_tutup_dop);
        SeekBar seekbar_bensin = (SeekBar) view.findViewById(R.id.seekbar_bensin);
        ImageButton button_next = (ImageButton) view.findViewById(R.id.button_next);
        ImageButton button_back = (ImageButton) view.findViewById(R.id.button_back);
        EditText edittext_km = (EditText) view.findViewById(R.id.textedit_km);
        TextView text_seekbar = (TextView) view.findViewById(R.id.text_seekbar);

        ArrayAdapter<CharSequence> adapter_appar = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.string_apar, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_fuel = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.string_fuel, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_velg_ban = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.string_velg_ban, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_tutup_dop = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.string_tutup_dop, android.R.layout.simple_spinner_item);
        adapter_appar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_fuel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_velg_ban.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_tutup_dop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_appar.setAdapter(adapter_appar);
        spinner_fuel.setAdapter(adapter_fuel);
        spinner_velg_ban.setAdapter(adapter_velg_ban);
        spinner_tutup_dop.setAdapter(adapter_tutup_dop);
        seekbar_bensin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                text_seekbar.setText("" + seekbar_bensin.getProgress());
                if(seekbar_bensin.getProgress() == 0){
                    text_seekbar.setText("0%");
                }
                else if(seekbar_bensin.getProgress() == 1){
                    text_seekbar.setText("25%");
                }
                else if(seekbar_bensin.getProgress() == 2){
                    text_seekbar.setText("50%");
                }
                else if(seekbar_bensin.getProgress() == 3){
                    text_seekbar.setText("75%");
                }
                else if(seekbar_bensin.getProgress() == 4){
                    text_seekbar.setText("100%");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        if(model.isi_tangki_ket!= null){
            seekbar_bensin.setProgress(model.isi_tangki);
            text_seekbar.setText(model.isi_tangki_ket);
        }

        if (model.apar!=null){
            int spinnerPosition = adapter_appar.getPosition(model.apar);
            spinner_appar.setSelection(spinnerPosition);
        }
        if(model.fuel!=null){
            int spinnerPosition = adapter_fuel.getPosition(model.fuel);
            spinner_fuel.setSelection(spinnerPosition);
        }
        if (model.velg_ban!=null){
            int spinnerPosition = adapter_velg_ban.getPosition(model.velg_ban);
            spinner_velg_ban.setSelection(spinnerPosition);
        }
        if(model.tutup_dop!=null){
            int spinnerPosition = adapter_tutup_dop.getPosition(model.tutup_dop);
            spinner_tutup_dop.setSelection(spinnerPosition);
        }
        if(model.km!=null){
            edittext_km.setText(model.km);
        }


        button_next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                model.apar = spinner_appar.getSelectedItem().toString();
                model.fuel = spinner_fuel.getSelectedItem().toString();
                model.velg_ban = spinner_velg_ban.getSelectedItem().toString();
                model.tutup_dop = spinner_tutup_dop.getSelectedItem().toString();
                model.km = edittext_km.getText().toString();
                model.isi_tangki_ket = text_seekbar.getText().toString();
                model.isi_tangki = seekbar_bensin.getProgress();
                next_Fragment(model); }
        });
        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                model.apar = spinner_appar.getSelectedItem().toString();
                model.fuel = spinner_fuel.getSelectedItem().toString();
                model.velg_ban = spinner_velg_ban.getSelectedItem().toString();
                model.tutup_dop = spinner_tutup_dop.getSelectedItem().toString();
                model.km = edittext_km.getText().toString();
                model.isi_tangki_ket = text_seekbar.getText().toString();
                model.isi_tangki = seekbar_bensin.getProgress();
                back_Fragment(); }
        });

        return view;
    }

    private void next_Fragment(Modelbstk model){
        Inputbstk_Camera1 fragment = new Inputbstk_Camera1();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void back_Fragment(){
        Inputbstk_7 fragment = new Inputbstk_7();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
