package com.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView popular_placesView, historical_placesView, beautiful_placesView, karachi_beachView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popular_placesView = (TextView) findViewById(R.id.popularPlace_View);
        historical_placesView = (TextView) findViewById(R.id.historicalPlace_View);
        beautiful_placesView = (TextView) findViewById(R.id.beauitfulPlace_View);
        karachi_beachView = (TextView) findViewById(R.id.beach_View);

        popular_placesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PopularActivity.class);
                startActivity(i);

            }
        });
        historical_placesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HistoricalActivity.class);
                startActivity(i);
            }
        });
        beautiful_placesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BeautifulActivity.class);
                startActivity(i);
            }
        });
        karachi_beachView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BeachActivity.class);
                startActivity(i);
            }
        });
    }
}
