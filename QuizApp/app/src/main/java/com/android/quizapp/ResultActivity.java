package com.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView resultView;
    private Button resultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultButton = (Button) findViewById(R.id.result_ViewButton);
        resultView = (TextView) findViewById(R.id.result_View);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText("You have Got " + QuizActivity.correct + " out of " + QuizActivity.answers.length);
                resultButton.setText("Want to Restart Quiz??");
                resultButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(ResultActivity.this, MainActivity.class);
                        startActivity(i);
                        QuizActivity.correct = 0;

                    }
                });
            }
        });
    }
}
