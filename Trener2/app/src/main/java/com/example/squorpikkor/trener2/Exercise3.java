package com.example.squorpikkor.trener2;

import android.app.Activity;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise3 extends Activity {

    //region VARIABLES AND OBJECTS
    //ImageButton plusWeightValueButton;
    ImageButton plusWeightValueButton = (ImageButton)findViewById(R.id.plusWeightValueButton);//НОВАЯ ТЕМА!!!
    ImageButton minusWeightValueButton;
    ImageButton plusQuantityValueButton;
    ImageButton minusQuantityValueButton;
    ImageButton addToResultButton;
    ImageButton addToHistoryButton;

    TextView weightValue;
    TextView quantityValue;
    TextView exerciseResult;

    public float bestWeight = 0;
    public float sumOfWeight = 0;
    public float bestSumOfWeight = 0;

    SharedPreferences sPref;
    final String SAVED_WEIGHT_VALUE = "saved_weight_value";
    final String SAVED_QUANTITY_VALUE = "saved_quantity_value";
    final String SAVED_BEST_WEIGHT = "saved_best_weight";
    final String SAVED_SUM_OF_WEIGHT = "saved_sum_of_weight";
    final String SAVED_BEST_SUM_OF_WEIGHT = "saved_best_sum_of_weight";

    DBHelper dbHelper;

    int historyRecord = 0;
    int newWeight = 0;
    /////String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    String date = "07.09.2016";

    int[] colors = new int[2];                                                          //

    //endregion

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);

        //region ID FOR WIDGET

        //plusWeightValueButton = (ImageButton) findViewById(R.id.plusWeightValueButton);
        minusWeightValueButton = (ImageButton) findViewById(R.id.minusWeightValueButton);
        plusQuantityValueButton = (ImageButton) findViewById(R.id.plusQuantityValueButton);
        minusQuantityValueButton = (ImageButton) findViewById(R.id.minusQuantityValueButton);
        addToResultButton = (ImageButton) findViewById(R.id.addToResultButton);
        addToHistoryButton = (ImageButton) findViewById(R.id.addToHistoryButton);
        weightValue = (TextView) findViewById(R.id.weightValue);
        quantityValue = (TextView) findViewById(R.id.quantityValue);
        exerciseResult = (TextView) findViewById(R.id.exerciseResult);

        //endregion

        dbHelper = new DBHelper(this);

        //region CLICK LISTENER/SWITCH CASE

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()){
                    case R.id.plusWeightValueButton:
                        plusWeightValue();
                        break;
                    case R.id.minusWeightValueButton:
                        minusWeightValue();
                        break;
                    case R.id.plusQuantityValueButton:
                        plusQuantityValue();
                        break;
                    case R.id.minusQuantityValueButton:
                        minusQuantityValue();
                        break;
                    case R.id.addToResultButton:
                        addToResult();
                        break;
                    case R.id.addToHistoryButton:
                        addToDB();
                        createLayoutItem();
                        //readFromDB();
                        exerciseResult.setText("");
                        break;
                }
            }
        };

        plusWeightValueButton.setOnClickListener(onClickListener);
        minusWeightValueButton.setOnClickListener(onClickListener);
        plusQuantityValueButton.setOnClickListener(onClickListener);
        minusQuantityValueButton.setOnClickListener(onClickListener);
        addToResultButton.setOnClickListener(onClickListener);
        addToHistoryButton.setOnClickListener(onClickListener);

        //endregion

        loadVariables();
        readFromDB();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveVariables();
    }

    //region METHODS FOR PLUS, MINUS, ADD TO RESULT

    public void plusWeightValue(){
        weightValue.setText(String.valueOf(
                Float.parseFloat(weightValue.getText().toString())+2.5
        ));
    }

    public void minusWeightValue(){
        weightValue.setText(String.valueOf(
                Float.parseFloat(weightValue.getText().toString())-2.5
        ));
    }

    public void plusQuantityValue(){
        quantityValue.setText(String.valueOf(
                Integer.parseInt(quantityValue.getText().toString())+1
        ));}

    public void minusQuantityValue(){
        quantityValue.setText(String.valueOf(
                Integer.parseInt(quantityValue.getText().toString())-1
        ));}

    public void  addToResult(){
        float weightValueFloat = Float.parseFloat(weightValue.getText().toString());
        float quantityValueFloat = Float.parseFloat(quantityValue.getText().toString());

        if(weightValueFloat>bestWeight){
            bestWeight = weightValueFloat;
            sumOfWeight = weightValueFloat * quantityValueFloat;
        }
        else if(weightValueFloat==bestWeight){
            sumOfWeight = sumOfWeight + (weightValueFloat * quantityValueFloat);
        }

        exerciseResult.setText(exerciseResult.getText().toString()
                +weightValue.getText().toString()+"-"
                +quantityValue.getText().toString()+", ");
    }

    //endregion

    public void  addToDB(){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.KEY_RESULT, exerciseResult.getText().toString());//добавить результат
        contentValues.put(DBHelper.KEY_HISTORY_RECORD_COUNT, historyRecord);
        contentValues.put(DBHelper.KEY_NEW_WEIGHT_COUNT, newWeight);
        contentValues.put(DBHelper.KEY_DATE, date);

        Log.d("LLLLLLOOOOG_ADD", exerciseResult.getText().toString());
        database.insert(DBHelper.TABLE_EXERCISE1, null, contentValues);
    }

    public void readFromDB(){
        colors[0] = Color.parseColor("#559966CC");
        colors[1] = Color.parseColor("#55336699");

        int i = 0;
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_EXERCISE1, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            //int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            //int exResultIndex = cursor.getColumnIndex(DBHelper.KEY_RESULT);
            do{
                Log.d("LLLLOOOGGGG_READ", cursor.getString(cursor.getColumnIndex(DBHelper.KEY_RESULT)));
                Log.d("myLogs", "i = " + i);

                LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);
                LayoutInflater ltInflater = getLayoutInflater();

                View item = ltInflater.inflate(R.layout.item, linLayout, false);

                TextView listResult = (TextView) item.findViewById(R.id.listResult);
                TextView listHistoryRecord = (TextView) item.findViewById(R.id.listHistoryRecord);
                TextView listNewWeight = (TextView) item.findViewById(R.id.listNewWeight);
                TextView listDate = (TextView) item.findViewById(R.id.listDate);

                listResult.setText(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_RESULT)));
                listHistoryRecord.setText(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_HISTORY_RECORD_COUNT)));
                listNewWeight.setText(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NEW_WEIGHT_COUNT)));
                listDate.setText(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_DATE)));

                item.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
                item.setBackgroundColor(colors[i % 2]);
                linLayout.addView(item);

                i = i+1;
            }
            while (cursor.moveToNext());
        }
        else
            Log.d("mLog", "0rows");
        cursor.close();
    }

    public void createLayoutItem(){
        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);
        LayoutInflater ltInflater = getLayoutInflater();

        View item = ltInflater.inflate(R.layout.item, linLayout, false);
        TextView tvName = (TextView) item.findViewById(R.id.listResult);
        tvName.setText(exerciseResult.getText().toString());
        TextView tvPosition = (TextView) item.findViewById(R.id.listNewWeight);
        tvPosition.setText("Должность: " + exerciseResult.getText().toString());
        TextView tvSalary = (TextView) item.findViewById(R.id.listDate);
        tvSalary.setText("Оклад: " + exerciseResult.getText().toString());
        item.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        item.setBackgroundColor(colors[1]);
        linLayout.addView(item);
    }

    //region METHODS FOR SAVE/LOAD VARIABLES

    public void saveVariables(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString(SAVED_QUANTITY_VALUE, quantityValue.getText().toString());
        editor.putString(SAVED_WEIGHT_VALUE, weightValue.getText().toString());
        editor.putFloat(SAVED_BEST_WEIGHT, bestWeight);  //(SAVED_BEST_WEIGHT, String.valueOf(bestWeight));
        editor.putFloat(SAVED_SUM_OF_WEIGHT, sumOfWeight);
        editor.putFloat(SAVED_BEST_SUM_OF_WEIGHT, bestSumOfWeight);
        editor.commit();
        Toast.makeText(Exercise3.this, "save_text", Toast.LENGTH_SHORT).show();
    }

    public void loadVariables(){
        sPref = getPreferences(MODE_PRIVATE);
        weightValue.setText(sPref.getString(SAVED_WEIGHT_VALUE, "0"));
        quantityValue.setText(sPref.getString(SAVED_QUANTITY_VALUE, "0"));
        bestWeight = sPref.getFloat(SAVED_BEST_WEIGHT, bestWeight);
        bestSumOfWeight = sPref.getFloat(SAVED_BEST_SUM_OF_WEIGHT, bestSumOfWeight);
        sumOfWeight = sPref.getFloat(SAVED_SUM_OF_WEIGHT, sumOfWeight);
        //}
    }

    //endregion
}
