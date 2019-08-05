package com.example.aplikasi2.inputbstk_sebelum;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.ByteArrayOutputStream;


public class Fragment_Camera extends Fragment {

    public Model model = new Model();

    ImageButton button;
    ImageView imageView;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_fragment__camera,
                container, false);
        button = (ImageButton) rootView.findViewById(R.id.button_camera);
        imageView = (ImageView) rootView.findViewById(R.id.imageview);

        if(model.Foto_Kendaraan_Tampak_Depan!=null){
            byte [] byteArray = Base64.decode(model.Foto_Kendaraan_Tampak_Depan.getBytes(), Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.
                    decodeByteArray(byteArray, 0, byteArray.length);
            imageView.setImageBitmap(bitmap);

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


//                byte [] byteArray = Base64.decode(model.Foto_Kendaraan_Tampak_Depan.getBytes(), Base64.DEFAULT);
//                Bitmap bitmap = BitmapFactory.
//                        decodeByteArray(byteArray, 0, byteArray.length);
//                imageView.setImageBitmap(bitmap);
                next_Fragment(model); }
        });

        ImageButton button2 = (ImageButton) rootView.findViewById(R.id.button_Back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
//                byte [] byteArray = Base64.decode(model.Foto_Kendaraan_Tampak_Depan.getBytes(), Base64.DEFAULT);
//                Bitmap bitmap = BitmapFactory.
//                        decodeByteArray(byteArray, 0, byteArray.length);
//                imageView.setImageBitmap(bitmap);
                back_Fragment(); }
        });

        return rootView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
                        byteArray.length);
                model.Foto_Kendaraan_Tampak_Depan = Base64.encodeToString(byteArray, Base64.DEFAULT);
                imageView.setImageBitmap(bitmap);
            }
        }
    }


    private void next_Fragment(Model model) {
        Fragment_Camera2 fragment = new Fragment_Camera2();
        fragment. model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void back_Fragment() {
        Fragment_Ceklis8 fragment = new Fragment_Ceklis8();
        fragment. model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    }

