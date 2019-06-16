package com.example.admin.mobileapplicationassignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        iv=(ImageView)findViewById(R.id.iv);
        //tv=(TextView)findViewById(R.id.tv);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        final Intent i=new Intent(this,HomeActivity.class);
       // tv.startAnimation(myanim);
        iv.startAnimation(myanim);
        Thread timer=new Thread()
        {
            public void run() {
                try {
                    sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
            }
}
