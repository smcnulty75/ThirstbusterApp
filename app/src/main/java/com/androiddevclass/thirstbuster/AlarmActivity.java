package com.androiddevclass.thirstbuster;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class AlarmActivity extends AppCompatActivity {

    private Button alarmOnBtn, alarmOffBtn;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        alarmOnBtn = (Button) findViewById(R.id.alarmOnButton);
        alarmOffBtn = (Button) findViewById(R.id.alarmOffButton);
    }

    public void alarmOn(View v){
        Intent alertIntent = new Intent(this, AlertReceiver.class);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        pendingIntent = PendingIntent.getBroadcast(this, 0, alertIntent, 0);

        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + 6 * 1000, pendingIntent);
//        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, AlarmManager.INTERVAL_HOUR,
//                AlarmManager.INTERVAL_HOUR, pendingIntent);

        Toast.makeText(getApplicationContext(), "The alarm is now on", Toast.LENGTH_LONG).show();
    }

    public void alarmOff(View v){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);

        Toast.makeText(getApplicationContext(), "The alarm is now off", Toast.LENGTH_LONG).show();
    }
}
