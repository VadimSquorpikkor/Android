package magaz15.app.android.squorpikkor.com.magaz15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    EditText    editText1,editText2,editText3,editText4,editText5,editText6,editText7,
                editText8,editText9,editText10,editText11,editText12,editText13,editText14,
                editText15,editText16,editText17,editText18,editText19,editText20,editText21,
                editText22,editText23,editText24,editText25,editText26,editText27,editText28,
                editText29,editText30;

    Button calculate, ostatok;

    LinearLayout userClicker, priceClicker;

    JuiceCollector jc = new JuiceCollector(15);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = (Button) findViewById(R.id.calculate);
        ostatok = (Button) findViewById(R.id.ostatok);
        userClicker = (LinearLayout) findViewById(R.id.userClicker);
        priceClicker = (LinearLayout) findViewById(R.id.priceClicker);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.calculate:
                        sendData();
                        PriceCalculator.calculatePrice(jc.juiceList);//calculate juicelist from juiceCollector
                        break;
                    case R.id.ostatok:
                        //showOstatokActivity();
                        break;
                    case R.id.userClicker:
                        //showUserActivity();
                        break;
                    case R.id.priceClicker:
                        //showPriceActivity();
                        break;
                }
            }
        };

        calculate.setOnClickListener(onClickListener);
        ostatok.setOnClickListener(onClickListener);



    }



}
