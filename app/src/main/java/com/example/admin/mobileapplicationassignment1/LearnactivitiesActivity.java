package com.example.admin.mobileapplicationassignment1;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class LearnactivitiesActivity extends AppCompatActivity {
    public static final long COUNTDOWN=30000;
    Toolbar toolbar;
    TextView tvscore,tvtotalquestions,tvtimer,tvquestions;
    RadioButton rdbtn1,rdbtn2,rdbtn3,rdbtn4;
    RadioGroup radioGroup;
    ArrayList<Questions> allQuestions;
    private ColorStateList txtcolorDefaultrdbtn;
    private ColorStateList txtcolorDefaultCd;
    private CountDownTimer countDownTimer;
    private long timeleft;
    private int questionCounter;
    private int questionCountTotal;
    private Questions currentQuestion;
    private int score;
    private boolean answered;
    Button btnnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnactivities);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String quizName=this.getIntent().getExtras().getString("quizName");
        getSupportActionBar().setTitle(quizName);

        tvscore=(TextView)findViewById(R.id.tv_score);
        tvtotalquestions=(TextView)findViewById(R.id.tv_questionno);
        tvtimer=(TextView)findViewById(R.id.tv_timer);
        tvquestions=(TextView)findViewById(R.id.tv_questions);
        radioGroup=(RadioGroup)findViewById(R.id.radiogroup) ;
        rdbtn1=(RadioButton)findViewById(R.id.radiobtn1);
        rdbtn2=(RadioButton)findViewById(R.id.radiobtn2);
        rdbtn3=(RadioButton)findViewById(R.id.radiobtn3);
        rdbtn4=(RadioButton)findViewById(R.id.radiobtn4);
        btnnext=(Button)findViewById(R.id.btnnext);
        //save default color of radiobutton
        txtcolorDefaultrdbtn=rdbtn1.getTextColors();
        //save default color of countdowntimer
        txtcolorDefaultCd=tvtimer.getTextColors();
        allQuestions=new Database(this).getALLQuestions(quizName);

        questionCountTotal=allQuestions.size();

        Collections.shuffle(allQuestions);

        shownxtanswer();
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered)
                    if(rdbtn1.isChecked()||rdbtn2.isChecked()||rdbtn3.isChecked()||rdbtn4.isChecked())
                    {
                        checkAnswer();
                    }
                    else {
                        Toast.makeText(LearnactivitiesActivity.this,"Please select an Answer",Toast.LENGTH_LONG).show();
                    }
                else
                {
                    shownxtanswer();
                }
            }
        });
    }
    private void shownxtanswer()
    {
        rdbtn1.setTextColor(txtcolorDefaultrdbtn);
        rdbtn2.setTextColor(txtcolorDefaultrdbtn);
        rdbtn3.setTextColor(txtcolorDefaultrdbtn);
        rdbtn4.setTextColor(txtcolorDefaultrdbtn);
        radioGroup.clearCheck();
        if(questionCounter<questionCountTotal)
        {
            currentQuestion=allQuestions.get(questionCounter);
            tvquestions.setText(currentQuestion.getQuestion());
            rdbtn1.setText(currentQuestion.getOption1());
            rdbtn2.setText(currentQuestion.getOption2());
            rdbtn3.setText(currentQuestion.getOption3());
            rdbtn4.setText(currentQuestion.getOption4());
            questionCounter++;
            tvtotalquestions.setText("Questions: "+ questionCounter+ "/" + questionCountTotal );
            answered=false;
            btnnext.setText("Confirm");
            timeleft=COUNTDOWN;
            startCountDown();
        }
        else {
            finishQuiz();
        }

    }
    private void startCountDown()
    {
        countDownTimer =new CountDownTimer(timeleft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleft=millisUntilFinished;
                updateCountDownText();

            }
            @Override
            public void onFinish() {
                timeleft=0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }
    private void updateCountDownText()
    {
        int minutes=(int)(timeleft/1000)/60;
        int seconds=(int)(timeleft/1000)% 60;
        String timeFormat=String .format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        tvtimer.setText(timeFormat);
        if(timeleft<10000)
        {
            tvtimer.setTextColor(Color.RED);
        }
        else {
            tvtimer.setTextColor(txtcolorDefaultCd);
        }
    }
    private void checkAnswer()
    {
        answered=true;
        countDownTimer.cancel();
        RadioButton rbSelected=findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo=radioGroup.indexOfChild(rbSelected)+1;
        if(answerNo==currentQuestion.getAnswerNo())
        {
            score++;
            tvscore.setText("Score: "+ score);
        }
        showSolution();
    }
    private void showSolution()
    {
        rdbtn1.setTextColor(Color.RED);
        rdbtn2.setTextColor(Color.RED);
        rdbtn3.setTextColor(Color.RED);
        rdbtn4.setTextColor(Color.RED);
        switch (currentQuestion.getAnswerNo())
        {
            case 1:
                rdbtn1.setTextColor(Color.GREEN);
                tvquestions.setText("Answer 1 is correct");
                break;
            case 2:
                rdbtn2.setTextColor(Color.GREEN);
                tvquestions.setText("Answer 2 is correct");
                break;
            case 3:
                rdbtn3.setTextColor(Color.GREEN);
                tvquestions.setText("Answer 3 is correct");
                break;
            case 4:
                rdbtn4.setTextColor(Color.GREEN);
                tvquestions.setText("Answer 4 is correct");
                break;
        }
        if(questionCounter<questionCountTotal)
        {
            btnnext.setText("Next");
        }
        else
        {
            btnnext.setText("Finish");
        }
}
    private void  finishQuiz()
    {
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

}
