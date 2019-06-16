package com.example.admin.mobileapplicationassignment1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    private static final String TAG = "HomeActivity";
    //vars
    private ArrayList<String> mNames=new ArrayList<>();
    private ArrayList<String> mImageUrls=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       getSupportActionBar().setTitle("Kids Learning App");
        toolbar.setLogo(R.drawable.logo);
        Log.d(TAG,"onCreate:started.");
        initImageBitmaps();

        Button btndial=(Button)findViewById(R.id.dialupbutton);
        btndial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call intent to open dial phone
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:123"));
                startActivity(intent);
            }
        });
        Button btntxt=(Button)findViewById(R.id.textbtn);
        btntxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call intent to send SMS
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.fromParts("sms","022165438","null"));
                intent.putExtra("sms body","HI..");
                startActivity(intent);
            }
        });
        Button btnbrowser=(Button)findViewById(R.id.browsingbtn);
        btnbrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call intent to open URL
                String url="https://www.google.com";
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    private void initImageBitmaps(){
        Log.d(TAG,"InitImageBitmaps:preparing maps.");
       mImageUrls.add("https://image.freepik.com/free-vector/kids-learning-and-playing-illustration_53876-40284.jpg");
       mNames.add("About Application");

        mImageUrls.add("https://sarvosys.com/wp-content/uploads/2017/07/cwtype-Features.jpg");
        mNames.add("Features");

        mImageUrls.add("http://www.ccbi.ac.nz/wp-content/uploads/2014/03/contactus.jpg");
        mNames.add("Contactus");

        mImageUrls.add("http://wp.workable.com/wp-content/uploads/2013/04/android_3640x240.png");
        mNames.add("About Developer");

        mImageUrls.add("http://icons.iconarchive.com/icons/papirus-team/papirus-apps/256/maps-icon.png");
        mNames.add("Google Maps");

        initRecyclerView();
    }
    private void initRecyclerView()
    {
        Log.d(TAG,"initRecyclerView init recyclerview.");
        RecyclerView recyclerView=findViewById(R.id.recycler);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,mNames,mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
