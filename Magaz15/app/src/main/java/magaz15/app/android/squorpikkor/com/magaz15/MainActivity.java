package magaz15.app.android.squorpikkor.com.magaz15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    double multiplex(EditText etext1, EditText etext2) {
        String s1 = etext1.getText().toString();
        String s2 = etext2.getText().toString();

        if (s1.length() == 0) { s1="0"; }
        if (s2.length() == 0) { s2="0"; }

        double value1 = Double.parseDouble(s1);
        double value2 = Double.parseDouble(s2);

        return value1*value2;
    }

    void readData() {
        for(int i = 1; i<31; i = 1+2) {
            String name1 = "editText" + i;
            String name2 = "editText" + (i+1);

            multiplex(name1, name2)

        }
    }
}
