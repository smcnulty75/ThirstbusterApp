package com.androiddevclass.thirstbuster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PregnantActivity extends AppCompatActivity {

    RadioGroup pregnantRadioGroup;
    RadioButton yesBtn;
    Button pregnantNextBtn;
    int selectedValueId;
    int waterValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnant);

        pregnantRadioGroup = (RadioGroup) findViewById(R.id.pregnantRadioGroup);
        pregnantNextBtn = (Button) findViewById(R.id.pregnantNextButton);
        yesBtn = (RadioButton) findViewById(R.id.yesButton);
        Bundle weightData = getIntent().getExtras();

        if (weightData == null){
            return;
        } else {
            waterValue = weightData.getInt("waterValue");
        }
    }

    public void goToNextActivity(View v){
        selectedValueId = pregnantRadioGroup.getCheckedRadioButtonId();

        if(selectedValueId == yesBtn.getId()){
            waterValue += 16;
        }

        Intent activeIntent = new Intent(this, ActivityLevelActivity.class);
        activeIntent.putExtra("waterValue", waterValue);
        startActivity(activeIntent);
    }
}
