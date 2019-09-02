package com.example.aplikasi2.loginbstk;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.aplikasi2.R;

public class TestActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        imageView = findViewById(R.id.minageView);

//        Bitmap bitmap = BitmapFactory.decodeFile(getIntent().getStringExtra("image_path"));
        Bitmap bitmap = BitmapFactory.decodeFile("/storage/emulated/0/Android/data/com.example.cameraexample/files/Pictures/jpg_20190827_163547_8394113630061445241.jpg");
        imageView.setImageBitmap(bitmap);

    }
}
