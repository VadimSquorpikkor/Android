package com.squorpikkor.android.app.magaz2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PersonCollectorActivity extends AppCompatActivity {

    Button button, loadPerson;
    EditText editText;


    /*SharedPreferences sharedPref;
    String SAVED_TEXT; //= "saved_" + "name";

    public void Save(Person person) {
        SAVED_TEXT = "saved_" + person.getName();
        sharedPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPref.edit();
        ed.putString(SAVED_TEXT, person.getName());
        ed.commit();
        //Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    public void load() {
        sharedPref = getPreferences(MODE_PRIVATE);
        String savedText = sharedPref.getString(SAVED_TEXT, "");
        person.setName(savedText);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_collector);

        button = (Button) findViewById(R.id.button);
        loadPerson = (Button) findViewById(R.id.displayPerson);
        editText = (EditText) findViewById(R.id.textView);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PersonCollector.createPerson(editText.getText().toString());
                switch (view.getId()) {
                    case R.id.button:
                        PersonCollector.createPerson(editText.getText().toString());
                        break;
                    case R.id.displayPerson:
                        display();
                        break;

                }
            }
        };

        button.setOnClickListener(onClickListener);
        loadPerson.setOnClickListener(onClickListener);

    }

    /*private ArrayList<Person> persons = new ArrayList<>();

    public void createPerson(String name){

        persons.add(new Person(name));
        display();
    }*/

    /**PersonCollector.savePerson();
     * PersonCollector.loadPerson();
     */

    public void display() {
        for (Person person:PersonCollector.getPersons()) {

            LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);
            LayoutInflater ltInflater = getLayoutInflater();

            View item = ltInflater.inflate(R.layout.item, linLayout, false);
            TextView personName = (TextView) item.findViewById(R.id.personName);
            personName.setText(person.getName());

            item.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
            //item.setBackgroundColor(colors[1]);
            if (linLayout != null) {
                linLayout.addView(item);
            }
        }
    }

    public void openPerson(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}//
//проверить на github


