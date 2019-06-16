package com.example.admin.mobileapplicationassignment1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="db_Kidsapp";
    public static final int DATABASE_VERSION=7;

    public static final String TABLE_QuizNAME="tbQuizName";
    public static final String COLUMN_QUESTION_ID="questionID";
    public static final String COLUMN_QUESTION="questions";
    public static final String COLUMN_Option1="option1";
    public static final String COLUMN_Option2="option2";
    public static final String COLUMN_Option3="option3";
    public static final String COLUMN_Option4="option4";
    public static final String COLUMN_CORRECT_OPTION="correctOption";
    public static final String COLUMN_QUIZNAME="quiz";

    public static final String TABLE_QuizType="tbQuizType";
    public static final String COLUMN_QUIZType="quiz";



    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "Create table " + TABLE_QuizNAME + "(" + COLUMN_QUESTION_ID + "INTEGER PRIMARY KEY, " +
                COLUMN_QUESTION + " TEXT, "
                + COLUMN_Option1 + " TEXT, " + COLUMN_Option2 + " TEXT , " + COLUMN_Option3 + " TEXT , " +
                COLUMN_Option4 + " TEXT ," +
                COLUMN_CORRECT_OPTION + " INTEGER, "+ COLUMN_QUIZNAME + " TEXT )" ;
        db.execSQL(query);

        String insertQuery1 = "Insert into " + TABLE_QuizNAME + " Values( 1, 'AINR?','NAIR','RINA','RAIN','RANI',3,'Learn Spellings')";
        String insertQuery2 = "Insert into " + TABLE_QuizNAME+ " Values( 2, 'RFO?','ROF','FOR','FRO','OFR',2,'Learn Spellings')";
        String insertQuery3 = "Insert into " + TABLE_QuizNAME+ " Values( 3, 'NBAINRWO?','BRAINNOW','ROWINBAN','WINABRO','RAINBOW',4" +
                ",'Learn Spellings')";
        String insertQuery4 = "Insert into " + TABLE_QuizNAME + " Values( 4, 'SGARS?','SARSG','AGRSS','GRASS','RAGSS',3,'Learn Spellings')";
        String insertQuery5 = "Insert into " + TABLE_QuizNAME+ " Values( 5, 'ESEDRT?','RESEDT','TEDSRE','SEDERT','DESERT',4,'Learn Spellings')";
        db.execSQL(insertQuery1);
        db.execSQL(insertQuery2);
        db.execSQL(insertQuery3);
        db.execSQL(insertQuery4);
        db.execSQL(insertQuery5);

        db.execSQL("Insert into " + TABLE_QuizNAME + " Values( 6, 'It is yellow on outside and white on inside'," +
                "'WaterMelon','Banana','Peach','Mango',2,'Learn Fruits Name')");
        db.execSQL("Insert into " + TABLE_QuizNAME+ " Values( 7, 'It is white on inside and can be red, yellow, or green on outside'," +
                "'Banana','Peach','Mango','Apple',4,'Learn Fruits Name')");
        db.execSQL("Insert into " + TABLE_QuizNAME + " Values( 8, 'Name a soft, red fruit that is not sweet'," +
                "'Apricot','Apple','Tomato','Peach',3,'Learn Fruits Name')");
        db.execSQL("Insert into " + TABLE_QuizNAME + " Values( 9, 'It is green on the outside and pink on the inside'," +
                "'Grapes','Banana','Olive','Watermelon',4,'Learn Fruits Name')");
        db.execSQL("Insert into " + TABLE_QuizNAME + " Values( 10, 'Name a sour, yellow fruit that starts with L'," +
                "'Lemon','Lime','Olive','Lettuce',1,'Learn Fruits Name')");

        db.execSQL("Insert into " + TABLE_QuizNAME + " Values( 11, 'Which number comes next 10,20,30,_'," +
                "'50','40','60','70',2,'Learn Counting')");
        db.execSQL("Insert into " + TABLE_QuizNAME + " Values( 12, 'Which is an even number'," +
                "'3','5','7','8',4,'Learn Counting')");
        db.execSQL("Insert into " + TABLE_QuizNAME+ " Values( 13, 'Which is the multiple of 9'," +
                "'41','30','18','26',3,'Learn Counting')");
        db.execSQL("Insert into " + TABLE_QuizNAME + " Values( 14, 'Which is an odd number'," +
                "'8','6','4','7',4,'Learn Counting')");
        db.execSQL("Insert into " + TABLE_QuizNAME + " Values( 15, 'How many times 0 comes in this number 0226009830101 '," +
                "'5','4','6','3',1,'Learn Counting')");

        db.execSQL("Insert into " + TABLE_QuizNAME + " Values( 16, 'What is  14 minus 2.73?'," +
                "'11.27','12.73','11.37','12.27',1,'Learn Maths Operations')");
        db.execSQL("Insert into " + TABLE_QuizNAME + " Values( 17, '3*(5*9+5)-4 ?'," +
                "'156','140','146','139',3,'Learn Maths Operations')");
        db.execSQL("Insert into " + TABLE_QuizNAME+ " Values( 18, '48/4+3 ?'," +
                "'17','15','6','7',2,'Learn Maths Operations')");
        db.execSQL("Insert into " + TABLE_QuizNAME  + " Values( 19, 'What is 14.5 times 7?'," +
                "'102.5','101.5','10.15','10.25',2,'Learn Maths Operations')");
        db.execSQL("Insert into " + TABLE_QuizNAME  + " Values( 20, 'What is 1/5 of 100?'," +
                "'20','25','3','50',1,'Learn Maths Operations')");

        db.execSQL("Create table " + TABLE_QuizType + "(" + COLUMN_QUIZType+ " TEXT )" );
        db.execSQL("Insert into " + TABLE_QuizType  + " Values( 'Learn Spellings')");
        db.execSQL("Insert into " + TABLE_QuizType  + " Values( 'Learn Fruits Name')");
        db.execSQL("Insert into " + TABLE_QuizType  + " Values( 'Learn Counting')");
        db.execSQL("Insert into " + TABLE_QuizType  + " Values( 'Learn Maths Operations')");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists " + TABLE_QuizNAME);
        db.execSQL("DROP table if exists " + TABLE_QuizType);

        onCreate(db);
    }

    public ArrayList<String> getQuizNames() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor1 = db.rawQuery("Select distinct (" + COLUMN_QUIZType + ") from " + TABLE_QuizType, null);
        ArrayList<String> localQuizNames = new ArrayList<>();
        if (cursor1.moveToFirst()) {
            do {
                localQuizNames.add(cursor1.getString(0));
            }
            while (cursor1.moveToNext());
        }
        return localQuizNames;
    }
    public ArrayList<QuizType> getQuizques(String quiztype) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor1 = db.rawQuery("Select  (" + COLUMN_QUESTION+ ") from " + TABLE_QuizNAME + " where " + COLUMN_QUIZNAME +"='" +quiztype +"'",
                null);
        ArrayList<QuizType> localQuizNames = new ArrayList<>();
        if (cursor1.moveToFirst()) {
            do {
                QuizType question=new QuizType(cursor1.getString(0));
                localQuizNames.add(question);
            }
            while (cursor1.moveToNext());
        }
        return localQuizNames;
    }


    public ArrayList<Questions> getALLQuestions(String quizName)
    {
        String query= "Select * from "+ TABLE_QuizNAME + " where " + COLUMN_QUIZNAME +"='" +quizName +"'";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);

        ArrayList<Questions> localCompleteQuestions=new ArrayList<Questions>();
        if(cursor.moveToFirst()) {
            do {
                Questions aquestion=new Questions(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),cursor.getInt(6),cursor.getString(7));
                localCompleteQuestions.add(aquestion);
            }
            while(cursor.moveToNext());

        }
        return localCompleteQuestions;
    }


}
