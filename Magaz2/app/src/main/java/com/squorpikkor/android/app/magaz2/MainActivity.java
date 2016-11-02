package com.squorpikkor.android.app.magaz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.buttonStart);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickActivity(PersonCollectorActivity.class);
            }
        };

        buttonStart.setOnClickListener
                (onClickListener);
    }

    public void clickActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
