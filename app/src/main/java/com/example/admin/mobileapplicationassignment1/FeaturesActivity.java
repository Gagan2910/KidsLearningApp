package com.example.admin.mobileapplicationassignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class FeaturesActivity extends AppCompatActivity {
    private static final String TAG = "Features Activity";
    Toolbar toolbar;
    //vars
    private ArrayList<String> mFeaturesNames=new ArrayList<>();
    private ArrayList<String> mImageUrls=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Features");
        initImageBitmaps();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menubar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.search:
                Intent i=new Intent(FeaturesActivity.this,SearchActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("Value","this data");
                i.putExtras(bundle);
                startActivity(i);

        }
        return super.onOptionsItemSelected(item);

    }

    private void initImageBitmaps(){
        Log.d(TAG,"InitImageBitmaps:preparing maps.");
        mImageUrls.add("http://www.genlish.com/learn-english/wp-content/uploads/2017/02/spelling-help.jpg");
        mFeaturesNames.add("Learn Spellings");

        mImageUrls.add("https://i.ytimg.com/vi/2qedQn_m_58/maxresdefault.jpg");
        mFeaturesNames.add("Learn Fruits Name");

        mImageUrls.add("https://i.ytimg.com/vi/H9tjc_v5TsU/maxresdefault.jpg");
        mFeaturesNames.add("Learn Counting");

        mImageUrls.add("https://i.ytimg.com/vi/mFjrX79EaW8/hqdefault.jpg");
        mFeaturesNames.add("Learn Maths Operations");

        mImageUrls.add("https://www.jqueryscript.net/images/jQuery-Plugin-For-Stacked-Polaroid-Image-Gallery-Photopile.jpg");
        mFeaturesNames.add("Gallery");

        initRecyclerView();
    }
    private void initRecyclerView()
    {
        Log.d(TAG,"initRecyclerView init recyclerview.");
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        RecyclerViewAdapter2 adapter2=new RecyclerViewAdapter2(this,mFeaturesNames,mImageUrls);
        recyclerView.setAdapter(adapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
