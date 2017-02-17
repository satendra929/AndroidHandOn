package com.notapro.drolle.drolle;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class CustomNotif extends AppCompatActivity implements View.OnClickListener{

    Button Notification;
    Button CustomNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_notif);
        Notification = (Button) findViewById(R.id.btNotifnormal);
        CustomNotif= (Button) findViewById(R.id.btCnotif);
        Notification.setOnClickListener(this);
        CustomNotif.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btNotifnormal:
                NormalNotification();
                break;
            case R.id.btCnotif:
                CustomNotification();
                break;
        }
    }

    private void CustomNotification() {
        RemoteViews rm = new RemoteViews(getPackageName(),R.layout.customnotif);
        Intent intent = new Intent(this,CustomNotif.class);
        PendingIntent pintent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_menu_manage)
                .setCustomBigContentView(rm)
                .setContentIntent(pintent);
        NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationmanager.notify(0, builder.build());


    }

    private void NormalNotification() {
        Intent intent = new Intent(getApplicationContext(),CustomNotif.class);
        PendingIntent pIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.cast_ic_notification_small_icon)
                .setContentTitle("Normal Notification")
                .addAction(R.drawable.com_facebook_button_icon_blue,"Action Button",pIntent)
                .setContentIntent(pIntent)
                .setAutoCancel(true);
        NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationmanager.notify(0, builder.build());
    }
}
