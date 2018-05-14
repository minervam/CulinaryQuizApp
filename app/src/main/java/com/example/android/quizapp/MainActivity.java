package com.example.android.quizapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This quiz app challenges the Users culinary skillz.
 */

public class MainActivity extends AppCompatActivity {

    int score = 0;
    Button reset_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset_button = (Button) findViewById(R.id.reset_button);
        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restartIntent = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                restartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(restartIntent);
            }
        });
    }

    /**
     * The following ten methods adds a score if answer is correct.
     */

    public void q1Answer() {

        CheckBox q1Choice3CheckBox = (CheckBox) findViewById(R.id.q1_choice3);
        boolean q1Choice3CheckBoxChecked = q1Choice3CheckBox.isChecked();

        CheckBox q1Choice4CheckBox = (CheckBox) findViewById(R.id.q1_choice4);
        boolean q1Choice4CheckBoxChecked = q1Choice4CheckBox.isChecked();

        if (q1Choice3CheckBoxChecked & q1Choice4CheckBoxChecked) {
            score += 1;
        }
    }

    public void q2Answer() {
        EditText answerField = (EditText) findViewById(R.id.question2_answer);
        String correctAnswer = answerField.getText().toString().replace(" ", "");

        if (correctAnswer.equals("Firm")) {
            score += 1;
        }
    }

    public void q3Answer() {
        RadioButton q3Choice2RadioButton = (RadioButton) findViewById(R.id.q3_choice2);
        boolean q3Choice2Selected = q3Choice2RadioButton.isChecked();
        if (q3Choice2Selected) {
            score += 1;
        }
    }

    public void q4Answer() {
        RadioButton q4Choice1RadioButton = (RadioButton) findViewById(R.id.q4_choice1);
        boolean q4Choice1Selected = q4Choice1RadioButton.isChecked();
        if (q4Choice1Selected) {
            score += 1;
        }
    }

    public void q5Answer() {
        RadioButton q5Choice3RadioButton = (RadioButton) findViewById(R.id.q5_choice3);
        boolean q5Choice3Selected = q5Choice3RadioButton.isChecked();
        if (q5Choice3Selected) {
            score += 1;
        }
    }

    public void q6Answer() {
        RadioButton q6Choice2RadioButton = (RadioButton) findViewById(R.id.q6_choice2);
        boolean q6Choice2Selected = q6Choice2RadioButton.isChecked();
        if (q6Choice2Selected) {
            score += 1;
        }
    }

    public void q7Answer() {
        RadioButton q7Choice2RadioButton = (RadioButton) findViewById(R.id.q7_choice2);
        boolean q7Choice2Selected = q7Choice2RadioButton.isChecked();
        if (q7Choice2Selected) {
            score += 1;
        }
    }

    public void q8Answer() {
        RadioButton q8Choice1RadioButton = (RadioButton) findViewById(R.id.q8_choice1);
        boolean q8Choice1Selected = q8Choice1RadioButton.isChecked();
        if (q8Choice1Selected) {
            score += 1;
        }
    }

    public void q9Answer() {
        RadioButton q9Choice3RadioButton = (RadioButton) findViewById(R.id.q9_choice3);
        boolean q9Choice3Selected = q9Choice3RadioButton.isChecked();
        if (q9Choice3Selected) {
            score += 1;
        }
    }

    public void q10Answer() {
        RadioButton q10Choice4RadioButton = (RadioButton) findViewById(R.id.q10_choice4);
        boolean q10Choice4Selected = q10Choice4RadioButton.isChecked();
        if (q10Choice4Selected) {
            score += 1;
        }
    }

    /**
     * This method is called when the incremented scores are added.
     */
    public void calculateScore() {

        q1Answer();
        q2Answer();
        q3Answer();
        q4Answer();
        q5Answer();
        q6Answer();
        q7Answer();
        q8Answer();
        q9Answer();
        q10Answer();
    }

    /**
     * This method is called when the GET SCORE button is clicked.
     */
    public void getScore(View view) {

        calculateScore();

        if (score == 10) {
            String scoreMessage10 = "You scored " + score + " out of 10! " + "I can call you Chef!";
            Toast.makeText(this, scoreMessage10, Toast.LENGTH_LONG).show();
        } else if (score >= 8) {
            String scoreMessage8 = "You scored " + score + " out of 10! " + "You\'ve got some skillz! Keep on cookin\'!";
            Toast.makeText(this, scoreMessage8, Toast.LENGTH_LONG).show();
        } else if (score >= 6) {
            String scoreMessage6 = "You scored " + score + " out of 10! " + "You\'re getting there! Cook more!";
            Toast.makeText(this, scoreMessage6, Toast.LENGTH_LONG).show();
        } else if (score >= 4) {
            String scoreMessage4 = "You scored " + score + " out of 10! " + "You need more cooking practice!";
            Toast.makeText(this, scoreMessage4, Toast.LENGTH_LONG).show();
        } else if (score >= 2) {
            String scoreMessage2 = "You scored " + score + " out of 10! " + "You can still learn a thing or two!";
            Toast.makeText(this, scoreMessage2, Toast.LENGTH_LONG).show();
        } else {
            String scoreMessage = "You scored " + score + " out of 10! " + "You just like to eat, don\'t cha.";
            Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();
        }

        final Button score_button = (Button) findViewById(R.id.score_button);
        score_button.setClickable(false);
        score_button.setVisibility(view.GONE);
        score_button.requestLayout();
    }

    /**
     * This method is called when the RESET button is clicked.
     */
    public void resetQuiz(View view) {
        score = 0;
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
