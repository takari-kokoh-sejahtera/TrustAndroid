package com.example.aplikasi2.inputbstk_sebelum;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aplikasi2.R;
import com.example.aplikasi2.viewbstk.Fragment_View;

public class Fragment_Konfirmasi extends Fragment {
    public Model model = new Model();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment__konfirmasi, container, false);

        ImageView image_signature = (ImageView) view.findViewById(R.id.image_signature);
        TextView text_ttd = (TextView) view.findViewById(R.id.text_ttd);
        Button button_save =(Button) view.findViewById(R.id.button_save);
        Button button_back = (Button) view.findViewById(R.id.button_back);

        byte [] byteArray3 = Base64.decode(model.signature_image.getBytes(), Base64.DEFAULT);
        Bitmap bitmap3 = BitmapFactory.
                decodeByteArray(byteArray3, 0, byteArray3.length);
        image_signature.setImageBitmap(bitmap3);

        text_ttd.setText(model.signature);
        model.signature = text_ttd.getText().toString();

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                back_fragment();
            }
        });

        return view;
    }

    private void back_fragment(){
        Fragment_Ttd fragment = new Fragment_Ttd();
        fragment. model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}