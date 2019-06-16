package com.example.admin.mobileapplicationassignment1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button btnsearch;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Bundle bundle=getIntent().getExtras();
        String quizName=bundle.getString("Value");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Search");
        btnsearch = (Button) findViewById(R.id.btnsearch);
        layout = (LinearLayout) findViewById(R.id.searchlayout);

        Database db = new Database(this);
        final ArrayList<String> quizNames = db.getQuizNames();

      btnsearch.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              for (int i = 0; i < quizNames.size(); i++) {
                  Button btn1 = new Button(SearchActivity.this);
                  btn1.setText(quizNames.get(i));
                  btn1.setTextColor(Color.WHITE);
                  btn1.setGravity(Gravity.CENTER);
                  btn1.setBackgroundResource(R.color.cardview_dark_background);
                  btn1.setTextSize(24);

                  final String tempQuizName = quizNames.get(i);
                  btn1.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Intent i;
                          i = new Intent(SearchActivity.this, EditActivity.class);
                          i.putExtra("quizName", tempQuizName);
                          startActivity(i);
                      }
                  });
                  layout.addView(btn1);
              } TextView tvedit=new TextView(SearchActivity.this);
              tvedit.setText("Click on buttons to Edit");
              tvedit.setTextColor(Color.RED);
              tvedit.setGravity(Gravity.CENTER);
              tvedit.setTextSize(18);
              layout.addView(tvedit);

          }
      });


    }
}





