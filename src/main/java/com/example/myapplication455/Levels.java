package com.example.myapplication455;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class Levels extends AppCompatActivity {


    public ColorStateList textColorDefaultRb;
    public List<Question> questionList;


    private static final int REQUEST_CODE_QUIZ=1;
    private static final int REQUEST_CODE_QUIZ_2=2;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";
    public static final String KEY_HIGHSCORE2 = "keyHighscore2";
    public static final String KEY_LOCKS = "keyLocks";

    private TextView HighScore;
    private TextView textViewHighscore;
    private TextView textViewHighscore2;

    ImageView Imageniv2;
    ImageView lockNiv2;

    private int highscore;
    private int highscore2;

    int Lock2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getAllQuestions();
        textViewHighscore = findViewById(R.id.highScore);
        textViewHighscore2 = findViewById(R.id.highScore2);
        Imageniv2 = (ImageView)findViewById(R.id.ImageNiv2);
        lockNiv2 = (ImageView)findViewById(R.id.LockNiv2);
        loadHighscore();
        loadHighscore2();
        loadlocks();

        textViewHighscore2.setVisibility(View.GONE);
    }

    public void Test1(View view) {

        Intent myIntent = new Intent(getBaseContext(),   Qst_Answer.class);
        startActivityForResult(myIntent,REQUEST_CODE_QUIZ);

    }

    public void Test2(View view) {

        Intent myIntent = new Intent(getBaseContext(),   Qst_Answer2.class);
        startActivityForResult(myIntent,REQUEST_CODE_QUIZ_2);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(Qst_Answer.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }

                //CONDITION DE REUSSITE

                if (score >= 8 )
                {
                    lockNiv2.setVisibility(View.GONE);
                    Lock2=1;

                    SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt(KEY_LOCKS, Lock2);
                    editor.apply();
                }

                if ( score >=6 && score < 8 )
                {

                    new AlertDialog.Builder(this,R.style.DialogeTheme2)
                            .setIcon(android.R.drawable.btn_plus)
                            .setTitle("Read the pdf !")
                            .setMessage("you got "+ score +"0%,Watch the video that we recommend to you ")
                            .setPositiveButton("Read the Pdf", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent video = new Intent(getBaseContext(),CoursNiv1.class);
                                    startActivity(video);
                                }

                            })
                            .setNegativeButton("No,Remind me Later", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent Level = new Intent(getBaseContext(),Levels.class);
                                    startActivity(Level);
                                }

                            })
                            .show();
                }

                if (score < 6 )
                {
                    new AlertDialog.Builder(this,R.style.DialogeTheme2)
                            .setIcon(android.R.drawable.ic_media_play)
                            .setTitle("Play the video ! ")
                            .setMessage("you got "+score +"0%,watch the video that we recommend to you ")
                            .setPositiveButton("Play Video", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent video = new Intent(getBaseContext(),VideoPlay.class);
                                    startActivity(video);
                                }

                            })
                            .setNegativeButton("No,Remind me Later", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent Level = new Intent(getBaseContext(),Levels.class);
                                    startActivity(Level);
                                }

                            })
                            .show();

                  /*
                   Intent video = new Intent(getBaseContext(),VideoPlay.class);
                    startActivity(video);


                  */
                }


            }
        }else
        if (requestCode == REQUEST_CODE_QUIZ_2){

            if (resultCode == RESULT_OK){

                int Score = data.getIntExtra(Qst_Answer2.EXTRA_SCORE2,0);
                if (Score > highscore2) {
                    updateHighscore2(Score);
                }
            }
        }
    }


    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);

    }


    private void loadHighscore2() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore2 = prefs.getInt(KEY_HIGHSCORE2, 0);
        textViewHighscore2.setText("Highscore: " + highscore2);

    }
    private void loadlocks() {


        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        Lock2= prefs.getInt(KEY_LOCKS,0);
        if (Lock2==1)
            lockNiv2.setVisibility(View.GONE);
    }




    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }


    private void updateHighscore2(int highscoreNew) {

        highscore2 = highscoreNew;
        textViewHighscore2.setText("Highscore: " + highscore2);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE2, highscore2);
        editor.apply();
    }


}
