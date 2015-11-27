package com.androiddevclass.thirstbuster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityLevelActivity extends AppCompatActivity {

    RadioGroup activityRadioGroup;
    RadioButton mildActivityRadioBtn;
    RadioButton veryActiveRadioBtn;
    Button calculate;
    int waterTotal;
    int selectedValue;
    int cupTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_level);

        activityRadioGroup = (RadioGroup) findViewById(R.id.activityRadioGroup);
        mildActivityRadioBtn = (RadioButton) findViewById(R.id.mildActivityRadioButton);
        veryActiveRadioBtn = (RadioButton) findViewById(R.id.veryActiveRadioButton);
        calculate = (Button) findViewById(R.id.calculateButton);
        Bundle waterData = getIntent().getExtras();

        if (waterData == null){
            return;
        } else {
            waterTotal = waterData.getInt("waterValue");
        }
    }

    public void calculateTotal(View v){
        selectedValue = activityRadioGroup.getCheckedRadioButtonId();

        if(selectedValue == mildActivityRadioBtn.getId()){
            waterTotal += 12;
        } else if (selectedValue == veryActiveRadioBtn.getId()){
            waterTotal += 18;
        }
        cupTotal = waterTotal / 8;

        Intent resultsIntent = new Intent(this, ResultsActivity.class);
        resultsIntent.putExtra("ounces", waterTotal);
        resultsIntent.putExtra("cups", cupTotal);
        startActivity(resultsIntent);
    }
}
