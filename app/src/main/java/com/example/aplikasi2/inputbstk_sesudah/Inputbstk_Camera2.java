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
import com.example.aplikasi2.inputbstk_sebelum.Fragment_Camera;
import com.example.aplikasi2.inputbstk_sebelum.Fragment_Camera3;
import com.example.aplikasi2.inputbstk_sebelum.Model;

import java.io.ByteArrayOutputStream;

public class Inputbstk_Camera2 extends Fragment {
    public Modelbstk model = new Modelbstk();

    ImageButton button;
    ImageView imageView2;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_inputbstk__camera2,
                container, false);
        button = (ImageButton) rootView.findViewById(R.id.button_camera);
        imageView2 = (ImageView) rootView.findViewById(R.id.imageview2);
        if(model.Foto_Kendaraan_Tampak_Belakang!=null){
            byte [] byteArray2 = Base64.decode(model.Foto_Kendaraan_Tampak_Belakang.getBytes(), Base64.DEFAULT);
            Bitmap bitmap2 = BitmapFactory.
                    decodeByteArray(byteArray2, 0, byteArray2.length);
            imageView2.setImageBitmap(bitmap2);

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
//                byte [] byteArray2 = Base64.decode(model.Foto_Kendaraan_Tampak_Belakang.getBytes(), Base64.DEFAULT);
//                Bitmap bitmap2 = BitmapFactory.
//                        decodeByteArray(byteArray2, 0, byteArray2.length);
//                imageView2.setImageBitmap(bitmap2);

                next_Fragment(model); }
        });

        ImageButton button2 = (ImageButton) rootView.findViewById(R.id.button_Back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                byte [] byteArray2 = Base64.decode(model.Foto_Kendaraan_Tampak_Belakang.getBytes(), Base64.DEFAULT);
//                Bitmap bitmap2 = BitmapFactory.
//                        decodeByteArray(byteArray2, 0, byteArray2.length);
//                imageView2.setImageBitmap(bitmap2);
                back_Fragment(); }
        });

        return rootView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                Bitmap bmp2 = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
                bmp2.compress(Bitmap.CompressFormat.PNG, 100, stream2);
                byte[] byteArray2 = stream2.toByteArray();
                Bitmap bitmap2 = BitmapFactory.decodeByteArray(byteArray2, 0,
                        byteArray2.length);
                model.Foto_Kendaraan_Tampak_Belakang = Base64.encodeToString(byteArray2, Base64.DEFAULT);
                imageView2.setImageBitmap(bitmap2);
            }
        }

    }

    private void next_Fragment(Modelbstk model) {
        Inputbstk_Camera3 fragment = new Inputbstk_Camera3();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void back_Fragment() {
        Inputbstk_Camera1 fragment = new Inputbstk_Camera1();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
