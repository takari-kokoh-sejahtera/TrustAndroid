package com.example.aplikasi2.inputbstk_sebelum;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aplikasi2.R;

import static androidx.databinding.DataBindingUtil.setContentView;

public class Fragment_Test extends Fragment {

    ImageView imageView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_fragment__test, container, false);
        imageView = (ImageView) rootView.findViewById(R.id.minageView);

//        Bitmap bitmap = BitmapFactory.decodeFile(getIntent().getStringExtra("image_path"));
        Bitmap bitmap = BitmapFactory.decodeFile("/storage/emulated/0/Android/data/com.example.cameraexample/files/Pictures/jpg_20190827_163547_8394113630061445241.jpg");
        imageView.setImageBitmap(bitmap);

        return rootView;
    }
}
