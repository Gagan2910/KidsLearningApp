package com.example.admin.mobileapplicationassignment1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class StartactivitiesActivity extends AppCompatActivity {
    Toolbar toolbar;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startactivities);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Features");

        layout = (LinearLayout) findViewById(R.id.childlayout);

        Database db = new Database(this);

        ArrayList<String> quizNames = db.getQuizNames();

        for (int i = 0; i < quizNames.size(); i++) {
            Button btn1 = new Button(this);
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
                    i = new Intent(StartactivitiesActivity.this, LearnactivitiesActivity.class);
                    i.putExtra("quizName", tempQuizName);
                    startActivity(i);
                }
            });
            layout.addView(btn1);
        }
    }
}

