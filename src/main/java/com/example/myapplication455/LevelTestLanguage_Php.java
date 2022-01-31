package com.example.myapplication455;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class LevelTestLanguage_Php extends AppCompatActivity {

    public ColorStateList textColorDefaultRb;
    public List<Question> questionList;
    private int questionCounter=0;
    private int questionCountTotal;
    private Question currentQuestion;
    private int score;
    private boolean answered;

    RadioGroup rbGroup;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;

    TextView submit;
    TextView textViewQuestion;
    TextView textViewQuestionCount;
    TextView ScoreAffichage;

    public static final String EXTRA_SCORE = "extraScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_test_language__php);



        QuizDbHelperLanguage_php dbHelper = new QuizDbHelperLanguage_php(this);
        questionList = dbHelper.getAllQuestions();


        rbGroup = (RadioGroup) findViewById(R.id.rg1_Php);
        rb1 = (RadioButton) findViewById(R.id.rb1_Php);
        rb2 = (RadioButton) findViewById(R.id.rb2_Php);
        rb3 = (RadioButton) findViewById(R.id.rb3_Php);
        submit = (TextView)findViewById(R.id.submit_Php);
        textViewQuestion= (TextView)findViewById(R.id.textViewQuestion_Php);
        textViewQuestionCount=(TextView)findViewById(R.id.textViewQuestionCount_Php) ;
        ScoreAffichage=(TextView)findViewById(R.id.textViewScore_Php);

        textColorDefaultRb = rb1.getTextColors();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);


        showNextQuestion();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(LevelTestLanguage_Php.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }


    private void showNextQuestion() {

        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            questionCounter++;
            textViewQuestionCount.setText("ROUND " + questionCounter + "/" + questionCountTotal);
            answered = false;
            submit.setText("Confirmer");
        } else {
            finishQuiz();
        }

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this,R.style.DialogeTheme)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Leaving")
                .setMessage("Are you sure you want to leave ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent= new Intent(getBaseContext(),Levels.class);
                        startActivity(intent);
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    public void GoQustionnext(View view) {

     /*   Intent myIntent = new Intent(getBaseContext(),   Qst_Answer2.class);
        startActivity(myIntent);
        myIntent.putExtra("Score",String.valueOf(Score));
        startActivity(myIntent);
      */

    }


    private void finishQuiz() {


        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE,score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }


    private void checkAnswer() {
        answered = true;

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getAnswerNr()) {
            score++;
            ScoreAffichage.setText("Score: " + score);
        }

        showSolution();
    }

    private void showSolution() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 1 is correct");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 2 is correct");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 3 is correct");
                break;
        }

        if (questionCounter < questionCountTotal) {
            submit.setText("Next");
        } else {

            submit.setText("Finish");
        }
    }
}
