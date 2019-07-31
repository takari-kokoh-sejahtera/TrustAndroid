package com.example.aplikasi2.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aplikasi2.R;
import com.kyanogen.signatureview.SignatureView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;


public class Fragment_Ttd extends Fragment {
    public Model model = new Model();

    SignatureView signatureView;
    Bitmap bitmap;
    String path;
    private static final String IMAGE_DIRECTORY = "/signdemo";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment__view, container, false);

        signatureView =  (SignatureView) view.findViewById(R.id.signature_view);
        Button save = (Button) view.findViewById(R.id.button_save);
        Button hapus = (Button) view.findViewById(R.id.button_hapus);

        return view;
    }
}


