package com.example.aplikasi2.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.aplikasi2.R;

import java.io.ByteArrayOutputStream;

public class Fragment_Camera4 extends Fragment {

    public Model model = new Model();

    ImageButton button;
    ImageView imageView4;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_fragment__camera4,
                container, false);
        button = (ImageButton) rootView.findViewById(R.id.button_camera);
        imageView4 = (ImageView) rootView.findViewById(R.id.imageview4);

        if(model.Foto_Kendaraan_Tampak_Samping_Kiri!=null){

            byte [] byteArray4 = Base64.decode(model.Foto_Kendaraan_Tampak_Samping_Kiri.getBytes(), Base64.DEFAULT);
            Bitmap bitmap4 = BitmapFactory.
                    decodeByteArray(byteArray4, 0, byteArray4.length);
            imageView4.setImageBitmap(bitmap4);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        });

        ImageButton button1 = (ImageButton) rootView.findViewById(R.id.button_ceklis);

        ImageButton button2 = (ImageButton) rootView.findViewById(R.id.button_Back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back_Fragment(); }
        });

        return rootView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                Bitmap bmp4 = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream4 = new ByteArrayOutputStream();
                bmp4.compress(Bitmap.CompressFormat.PNG, 100, stream4);
                byte[] byteArray4 = stream4.toByteArray();
                Bitmap bitmap4 = BitmapFactory.decodeByteArray(byteArray4, 0,
                        byteArray4.length);
                model.Foto_Kendaraan_Tampak_Samping_Kiri = Base64.encodeToString(byteArray4, Base64.DEFAULT);
                imageView4.setImageBitmap(bitmap4);
            }
        }

    }


    private void back_Fragment() {
        Fragment_Camera3 fragment = new Fragment_Camera3();
        fragment.model = model;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
}
}
