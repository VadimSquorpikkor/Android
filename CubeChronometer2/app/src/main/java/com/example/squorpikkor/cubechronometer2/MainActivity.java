package com.example.squorpikkor.cubechronometer2;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //region TEXTVIEW & CHRONO
    private Chronometer mChronometer;

    TextView bestAverageText;
    TextView bestTimeText;
    TextView bestAverageValueText;
    TextView timeText01;
    TextView timeText02;
    TextView timeText03;
    TextView timeText04;
    TextView timeText05;
    TextView timeText06;
    TextView timeText07;
    TextView timeText08;
    TextView timeText09;
    TextView timeText10;
    TextView averageValueText;
    TextView setAverageText;
    TextView setAverageValueText;
    TextView maxAverageText;
    TextView maxAverageValueText;
    //endregion

    //region IMAGE BUTTON, sPREF, SAVED_TEXT
    ImageButton imageButton;
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //region SET TEXTVIEW & CHRONO
        mChronometer = (Chronometer) findViewById(R.id.chronometer);
        bestAverageText = (TextView) findViewById(R.id.bestAverageText);
        bestAverageValueText = (TextView) findViewById(R.id.bestAverageValueText);
        bestTimeText = (TextView) findViewById(R.id.bestTimeText);
        timeText01 = (TextView) findViewById(R.id.timeText01);
        timeText02 = (TextView) findViewById(R.id.timeText02);
        timeText03 = (TextView) findViewById(R.id.timeText03);
        timeText04 = (TextView) findViewById(R.id.timeText04);
        timeText05 = (TextView) findViewById(R.id.timeText05);
        timeText06 = (TextView) findViewById(R.id.timeText06);
        timeText07 = (TextView) findViewById(R.id.timeText07);
        timeText08 = (TextView) findViewById(R.id.timeText08);
        timeText09 = (TextView) findViewById(R.id.timeText09);
        timeText10 = (TextView) findViewById(R.id.timeText10);
        maxAverageText = (TextView) findViewById(R.id.maxAverageText);
        maxAverageValueText = (TextView) findViewById(R.id.maxAverageValueText);
        averageValueText = (TextView) findViewById(R.id.averageValueText);
        setAverageText = (TextView) findViewById(R.id.setAverageText);
        setAverageValueText = (TextView) findViewById(R.id.setAverageValueText);
        //endregion

    }
}
