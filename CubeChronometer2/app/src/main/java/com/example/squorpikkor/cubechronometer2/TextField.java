package com.example.squorpikkor.cubechronometer2;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.widget.TextView;

 //Created by SquorpikkoR on 08.10.2016.

abstract class TextField {
    TextView textView;
    public void moveDataToField(String string) {
        textView.setText(string);
    }

    public void moveDataToField(int integer) {
        textView.setText(integer);
    }

    public void changeColor(int color) {
        textView.setTextColor(color);
    }
}
