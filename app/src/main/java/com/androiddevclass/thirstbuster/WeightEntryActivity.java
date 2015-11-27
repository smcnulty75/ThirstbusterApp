package com.androiddevclass.thirstbuster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

public class WeightEntryActivity extends AppCompatActivity {

    Button nextBtn;
    EditText weight;
    RadioButton femaleBtn;
    RadioGroup genderRadioGroup;
    int selectedValueId;
    String weightValue;
    int waterAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_entry);

        nextBtn = (Button) findViewById(R.id.weightButton);
        femaleBtn = (RadioButton) findViewById(R.id.femaleRadioButton);
        genderRadioGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        weight = (EditText) findViewById(R.id.weightEditText);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check that weight has been entered before proceeding
                weightValue = weight.getText().toString();
                if (weightValue.trim().equals("000") || weightValue == null) {
                    Toast.makeText(getApplicationContext(), "Please enter a weight value", Toast.LENGTH_LONG).show();
                } else {
                    waterAmount = Integer.parseInt(weightValue) / 2;
                    //if female is selected, take me to the pregnancy screen
                    selectedValueId = genderRadioGroup.getCheckedRadioButtonId();
                    if (selectedValueId == femaleBtn.getId()) {
                        Intent female = new Intent(v.getContext(), PregnantActivity.class);
                        female.putExtra("waterValue", waterAmount);
                        startActivity(female);
                    }
                    //else take me straight to the activity level screen
                    else {
                        Intent male = new Intent(v.getContext(), ActivityLevelActivity.class);
                        waterAmount += 16;
                        male.putExtra("waterValue", waterAmount);
                        startActivity(male);
                    }
                }
            }
        });
    }
}
