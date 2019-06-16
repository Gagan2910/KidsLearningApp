package com.example.admin.mobileapplicationassignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class FullimageActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Gallery");
        toolbar.setLogo(R.drawable.logo);

        Intent i=getIntent();
        int position=i.getExtras().getInt("id");
        ImageAdapter imageAdapter=new ImageAdapter(this);
        ImageView imageView=(ImageView)findViewById(R.id.galleryimage);
        imageView.setImageResource(imageAdapter.images[position]);



    }
}
