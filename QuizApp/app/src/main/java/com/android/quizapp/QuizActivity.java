package com.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    public static int correct;
    int flag = 0;
    boolean cond = false;
    private TextView questionView;
    private Button nextButton;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1, mRadioButton2, mRadioButton3;
    private String[] questions = {"Name Of First Android Phone?", "Name of the First Android Version", "Android is which kind of Software?"};
    public static String[] answers = {"HTC dream", "Cup Cake", "OS"};
    private String[] options = {"HTC 01", "HTC StartUP", "HTC dream", "Cup Cake", "Jelly Bean", "Donuts", "Application", "OS", "Antivirus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questionView = (TextView) findViewById(R.id.questions_textView);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroupView);
        mRadioButton1 = (RadioButton) findViewById(R.id.rd1);
        mRadioButton2 = (RadioButton) findViewById(R.id.rd2);
        mRadioButton3 = (RadioButton) findViewById(R.id.rd3);
        nextButton = (Button) findViewById(R.id.next_button);

        questionView.setText(questions[flag]);
        mRadioButton1.setText(options[0]);
        mRadioButton2.setText(options[1]);
        mRadioButton3.setText(options[2]);

        buttonClick();


    }

    public void buttonClick() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton youAnswer = (RadioButton) findViewById(mRadioGroup.getCheckedRadioButtonId());
                String answerText = youAnswer.getText().toString();
                Log.d("ANswer", " " + answerText);
                Log.d("ANswer Flag wala", " " + answers[flag]);
                if (answerText.equalsIgnoreCase(answers[flag])) {
                    correct++;
                    Log.d("correct", "= " + correct);

                } else {
                    Log.d("in Else correct", "= " + correct);
                }
                flag++;
                Log.d("Flag After ", "= " + flag);
                if (flag < questions.length) {
                    questionView.setText(questions[flag]);
                    mRadioButton1.setText(options[flag * 3]);
                    mRadioButton2.setText(options[(flag * 3) + 1]);
                    mRadioButton3.setText(options[(flag * 3) + 2]);

                } else {
                    Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
