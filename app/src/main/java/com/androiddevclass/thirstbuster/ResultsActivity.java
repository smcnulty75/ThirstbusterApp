package com.androiddevclass.thirstbuster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView ouncesText;
    TextView cupsText;
    Button setAlarmBtn;
    Button viewHistoryBtn;
    String ouncesTotal;
    String cupsTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ouncesText = (TextView) findViewById(R.id.ounceTextView);
        cupsText = (TextView) findViewById(R.id.cupTextView);
        setAlarmBtn = (Button) findViewById(R.id.setAlarmButton);
        viewHistoryBtn = (Button) findViewById(R.id.viewHistoryButton);
        Bundle waterData = getIntent().getExtras();

        if (waterData == null){
            return;
        } else {
            ouncesTotal = Integer.toString(waterData.getInt("ounces"));
            cupsTotal = Integer.toString(waterData.getInt("cups"));
            ouncesText.setText(ouncesTotal);
            cupsText.setText(cupsTotal);
        }
    }

    public void setAlarmActivity(View v){
        Intent alarmIntent = new Intent(this, AlarmActivity.class);
        alarmIntent.putExtra("cups", cupsTotal);
        startActivity(alarmIntent);
    }

    public void goToHistoryActivity(View v) {

    }
}
