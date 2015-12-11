package com.androiddevclass.thirstbuster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button entryBtn = (Button) findViewById(R.id.newEntryButton);
        entryBtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent entry = new Intent(v.getContext(), WeightEntryActivity.class);
                                            startActivityForResult(entry, 0);
                                        }
                                    }
        );

        Button historyBtn = (Button) findViewById(R.id.showHistoryButton);
        historyBtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent entry = new Intent(v.getContext(), HistoryActivity.class);
                                            startActivityForResult(entry, 0);
                                        }
                                    }
        );

    }

    public void goToAlarmActivity(View v){
        Intent alarmIntent = new Intent(this, AlarmActivity.class);
        startActivity(alarmIntent);
    }

    public void goToHistoryActivity(View v) {

    }


}
