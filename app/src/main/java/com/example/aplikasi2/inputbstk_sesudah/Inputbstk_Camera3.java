package com.example.aplikasi2.inputbstk_sesudah;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.aplikasi2.R;
import com.example.aplikasi2.inputbstk_sebelum.Fragment_Camera2;
import com.example.aplikasi2.inputbstk_sebelum.Fragment_Camera4;
import com.example.aplikasi2.inputbstk_sebelum.Model;

import java.io.ByteArrayOutputStream;

public class Inputbstk_Camera3 extends Fragment {
    public Modelbstk model = new Modelbstk();

    ImageButton button;
    ImageView imageView3;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_inputbstk__camera3,
                container, false);
        button = (ImageButton) rootView.findViewById(R.id.button_camera);
        imageView3 = (ImageView) rootView.findViewById(R.id.imageview3);
        if(model.Foto_Kendaraan_Tampak_Samping_Kanan!=null){
            byte [] byteArray3 = Base64.decode(model.Foto_Kendaraan_Tampak_Samping_Kanan.getBytes(), Base64.DEFAULT);
            Bitmap bitmap3 = BitmapFactory.
                    decodeByteArray(byteArray3, 0, byteArray3.length);
            imageView3.setImageBitmap(bitmap3);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        });

        ImageButton button1 = (ImageButton) rootView.findViewById(R.id.button_ceklis);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next_Fragment(model); }
        });

        ImageButton button2 = (ImageButton) rootView.findViewById(R.id.button_Back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back_Fragment(); }
        });

        return rootView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Bitmap bmp3 = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream3 = new ByteArrayOutputStream();
                bmp3.compress(Bitmap.CompressFormat.PNG, 100, stream3);
                byte[] byteArray3 = stream3.toByteArray();
                Bitmap bitmap3 = BitmapFactory.decodeByteArray(byteArray3, 0,
                        byteArray3.length);
                model.Foto_Kendaraan_Tampak_Samping_Kanan = Base64.encodeToString(byteArray3, Base64.DEFAULT);
                imageView3.setImageBitmap(bitmap3);
            }
        }
    }



    private void next_Fragment(Modelbstk model) {
        Inputbstk_Camera4 fragment = new Inputbstk_Camera4();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void back_Fragment() {
        Inputbstk_Camera2 fragment = new Inputbstk_Camera2();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
