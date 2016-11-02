package com.example.squorpikkor.trener2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise1 extends AppCompatActivity {


    ImageButton plusWeightValueButton;
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
    final String SAVED_EXERCISE_HISTORY = "saved_exercise_history";


    //ArrayList<String> exerciseHistoryArray = new ArrayList<String>();
    Set<String> exerciseHistory = new HashSet<String>();
    ArrayAdapter<String> adapter;
    List<String> exerciseHistoryArray = new ArrayList<String>(exerciseHistory);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        plusWeightValueButton = (ImageButton) findViewById(R.id.plusWeightValueButton);
        minusWeightValueButton = (ImageButton) findViewById(R.id.minusWeightValueButton);
        plusQuantityValueButton = (ImageButton) findViewById(R.id.plusQuantityValueButton);
        minusQuantityValueButton = (ImageButton) findViewById(R.id.minusQuantityValueButton);
        addToResultButton = (ImageButton) findViewById(R.id.addToResultButton);
        addToHistoryButton = (ImageButton) findViewById(R.id.addToHistoryButton);
        weightValue = (TextView) findViewById(R.id.weightValue);
        quantityValue = (TextView) findViewById(R.id.quantityValue);
        exerciseResult = (TextView) findViewById(R.id.exerciseResult);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.plusWeightValueButton:
                        plusWeightValue();
                        break;
                    case R.id.minusWeightValueButton:
                        weightValue.setText(String.valueOf(
                                Float.parseFloat(weightValue.getText().toString())-2.5
                        ));
                        break;
                    case R.id.plusQuantityValueButton:
                        quantityValue.setText(String.valueOf(
                                Integer.parseInt(quantityValue.getText().toString())+1
                        ));
                        break;
                    case R.id.minusQuantityValueButton:
                        quantityValue.setText(String.valueOf(
                                Integer.parseInt(quantityValue.getText().toString())-1
                        ));
                        break;
                    case R.id.addToResultButton:
                        addToResult();
                        break;
                    case R.id.addToHistoryButton:
                        addToHistory();
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

        ListView listView = (ListView)findViewById(R.id.listView);



        //adapter = new ArrayAdapter<String>(this,
        //        R.layout.list_item, exerciseHistory);

        adapter = new ArrayAdapter<String>(this,
                R.layout.list_item, exerciseHistoryArray);

        listView.setAdapter(adapter);

        loadVariables();
    }

    public void plusWeightValue(){
        weightValue.setText(String.valueOf(
                Float.parseFloat(weightValue.getText().toString())+2.5
        ));
    }

    public void addToResult(){
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

    public void saveVariables(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString(SAVED_QUANTITY_VALUE, quantityValue.getText().toString());
        editor.putString(SAVED_WEIGHT_VALUE, weightValue.getText().toString());
        editor.putFloat(SAVED_BEST_WEIGHT, bestWeight);  //(SAVED_BEST_WEIGHT, String.valueOf(bestWeight));
        editor.putFloat(SAVED_SUM_OF_WEIGHT, sumOfWeight);
        editor.putFloat(SAVED_BEST_SUM_OF_WEIGHT, bestSumOfWeight);
        editor.putStringSet(SAVED_EXERCISE_HISTORY,exerciseHistory);
        editor.commit();
        Toast.makeText(Exercise1.this, "save_text", Toast.LENGTH_SHORT).show();
    }

    public void loadVariables(){
        sPref = getPreferences(MODE_PRIVATE);
        weightValue.setText(sPref.getString(SAVED_WEIGHT_VALUE, "0"));
        quantityValue.setText(sPref.getString(SAVED_QUANTITY_VALUE, "0"));
        bestWeight = sPref.getFloat(SAVED_BEST_WEIGHT, bestWeight);
        bestSumOfWeight = sPref.getFloat(SAVED_BEST_SUM_OF_WEIGHT, bestSumOfWeight);
        //exerciseHistory.add(SAVED_SUM_OF_WEIGHT);
        exerciseHistory = sPref.getStringSet(SAVED_EXERCISE_HISTORY, exerciseHistory);
        //exerciseHistoryArray.add(exerciseHistory);


    }



    public void addToHistory(){
        exerciseHistoryArray.add(exerciseResult.getText().toString());
        adapter.notifyDataSetChanged();
        exerciseResult.setText("");
        //saveVariables();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveVariables();
    }
}