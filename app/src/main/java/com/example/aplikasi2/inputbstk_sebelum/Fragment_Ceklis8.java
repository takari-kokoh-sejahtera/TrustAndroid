package com.example.aplikasi2.inputbstk_sebelum;

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


public class Fragment_Ceklis8 extends Fragment {
    public Model model = new Model();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment__ceklis8, container, false);
        final Spinner spinner_appar = (Spinner) view.findViewById(R.id.spinner_apar);
        final Spinner spinner_fuel = (Spinner) view.findViewById(R.id.spinner_fuel);
        final Spinner spinner_velg_ban = (Spinner) view.findViewById(R.id.spinner_velg_ban);
        final Spinner spinner_tutup_dop = (Spinner) view.findViewById(R.id.spinner_velg_tutup_dop);
        final SeekBar seekbar_bensin = (SeekBar) view.findViewById(R.id.seekbar_bensin);
        ImageButton button_next = (ImageButton) view.findViewById(R.id.button_next);
        ImageButton button_back = (ImageButton) view.findViewById(R.id.button_back);
        final EditText edittext_km = (EditText) view.findViewById(R.id.textedit_km);
        final TextView text_seekbar = (TextView) view.findViewById(R.id.text_seekbar);

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
                if (edittext_km.getText().toString() != ""){
                    model.km = Integer.parseInt(edittext_km.getText().toString());
                }
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
                if (edittext_km.getText().toString() != ""){
                    model.km = Integer.parseInt(edittext_km.getText().toString());
                }
                model.isi_tangki_ket = text_seekbar.getText().toString();
                model.isi_tangki = seekbar_bensin.getProgress();
                back_Fragment(); }
        });

        return view;
    }

    private void next_Fragment(Model model){
        Fragment_Camera fragment = new Fragment_Camera();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void back_Fragment(){
        Fragment_Ceklis7 fragment = new Fragment_Ceklis7();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
