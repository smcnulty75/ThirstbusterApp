package com.androiddevclass.thirstbuster;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Shawn on 11/21/2015.
 */
public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        createNotification(context, "It's been an hour", "Drink your water", "Drink up!");
    }

    public void createNotification(Context context, String msgTitle, String msgText, String msgAlert) {

        PendingIntent notifIntent = PendingIntent.getActivity(context, 0, new Intent(context,
                MainActivity.class), 0);

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(msgTitle)
                .setTicker(msgAlert)
                .setWhen(System.currentTimeMillis())
                .setContentText(msgText);

        mBuilder.setContentIntent(notifIntent);
        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }
}
