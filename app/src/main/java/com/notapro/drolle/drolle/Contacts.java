package com.notapro.drolle.drolle;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class Contacts extends AppCompatActivity {

    ArrayList<String> names = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Button display = (Button) findViewById(R.id.btLoadContacts);
        final ListView contacts = (ListView) findViewById(R.id.lvContacts);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayContacts();
               ArrayAdapter<String> arrayadap = new ArrayAdapter<String>(getApplicationContext(),R.layout.custom_textview,names);
               contacts.setAdapter(arrayadap);
                createNotif();
            }
        });
    }


    public void createNotif(){
        Intent intent = new Intent(this, HomeScreen.class);
        PendingIntent pIntent = PendingIntent.getActivity(this,(int)System.currentTimeMillis(),intent,0);
        Notification noti = new Notification.Builder(this).setContentTitle("Contacts Loaded").setContentText("Subject").setSmallIcon(R.drawable.ic_menu_manage)
                .setContentText("Click to return Home").setContentIntent(pIntent).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0,noti);
    }

    private void displayContacts() {

        ContentResolver cr = getContentResolver();
        String number= new String();
        Cursor cur = cr.query( ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        if (cur.getCount()>0){
            while(cur.moveToNext()){
               String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)>0) {
                    Cursor curNum = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"=?",new String[]{id},null);
                    while(curNum.moveToNext()) {
                       number = curNum.getString(curNum.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }
                }
                //Toast toast = Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG);
                //toast.show();
                names.add(name+" "+number);
            }
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),"No Contacts",Toast.LENGTH_LONG);
            toast.show();

        }

    }
}
