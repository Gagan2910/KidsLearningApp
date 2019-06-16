package com.example.admin.mobileapplicationassignment1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button btnedit;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit");
        btnedit = (Button) findViewById(R.id.btnedit);
        layout = (LinearLayout) findViewById(R.id.editlayout);
        String quizques=this.getIntent().getExtras().getString("quizName");
        Database db = new Database(this);
        final ArrayList<QuizType>  getques= db.getQuizques(quizques);
        btnedit.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                for(int i=0;i<getques.size();i++) {
                    EditText et = new EditText(EditActivity.this);
                    et.setText(getques.get(i).getQuiztype());
                    layout.addView(et);
                }
                Button btnupdate=new Button(EditActivity.this);
                btnupdate.setText("Update");
                btnupdate.setTextColor(Color.WHITE);
                btnupdate.setGravity(Gravity.CENTER);
                btnupdate.setBackgroundResource(R.color.black);
                btnupdate.setTextSize(18);
                layout.addView(btnupdate);
                btnupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(EditActivity.this,"Data updated successfully",Toast.LENGTH_LONG).show();
                    }
                });
                return false;
            }
        });
    }
}
