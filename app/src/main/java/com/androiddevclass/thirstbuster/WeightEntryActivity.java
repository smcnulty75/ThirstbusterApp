package com.androiddevclass.thirstbuster;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class WeightEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_entry);

        Button nextBtn = (Button) findViewById(R.id.weightButton);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check that weight has been entered before proceeding
                EditText weight = (EditText)findViewById(R.id.weightEditText);
                if(weight.equals("000")){
                    System.out.println("Please enter weight before proceeding.");
                }
                else {
                    Button femaleBtn = (Button) findViewById(R.id.femaleRadioButton);

                    //if female is selected, take me to the pregnancy screen
                    if (femaleBtn.isSelected()) {
                        Intent female = new Intent(v.getContext(), PregnantActivity.class);
                        startActivityForResult(female, 0);
                    }
                    //else take me straight to the activity level screen
                    else {
                        Intent male = new Intent(v.getContext(), ActivityLevelActivity.class);
                        startActivityForResult(male, 0);
                    }
                }
            }
        });
    }
}
