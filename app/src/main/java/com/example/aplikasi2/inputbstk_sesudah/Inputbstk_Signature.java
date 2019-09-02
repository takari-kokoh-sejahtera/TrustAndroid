package com.example.aplikasi2.inputbstk_sesudah;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.aplikasi2.R;
import com.example.aplikasi2.inputbstk_sebelum.Fragment_Camera4;
import com.example.aplikasi2.inputbstk_sebelum.Fragment_Konfirmasi;
import com.example.aplikasi2.inputbstk_sebelum.Model;
import com.kyanogen.signatureview.SignatureView;

import java.io.ByteArrayOutputStream;

public class Inputbstk_Signature extends Fragment {
    public Modelbstk model = new Modelbstk();

    Bitmap bitmap;
    SignatureView signatureView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inputbstk__signature, container, false);

        signatureView = (SignatureView) view.findViewById(R.id.signature_view);
        Button clear = (Button) view.findViewById(R.id.clear);
        ImageButton button1 = (ImageButton) view.findViewById(R.id.button_next);
        ImageButton button2 = (ImageButton) view.findViewById(R.id.button_back);
        final EditText editText_signature = (EditText) view.findViewById(R.id.textedit_signature);

        if (model.signature != null) {
            editText_signature.setText(model.signature);
        }

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signatureView.clearCanvas();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.signature = editText_signature.getText().toString();
                bitmap = signatureView.getSignatureBitmap();
                saveImage(bitmap);
                next_Fragment(model);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.signature = editText_signature.getText().toString();
                back_Fragment();
            }
        });

        return view;
    }
    private void saveImage (Bitmap bitmap){
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bytes);
        byte[] byteArray = bytes.toByteArray();
        model.signature_image= Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    private void next_Fragment(Modelbstk model) {
        Inputbstk_Signature2 fragment = new Inputbstk_Signature2();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void back_Fragment() {
        Inputbstk_Camera4 fragment = new Inputbstk_Camera4();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
