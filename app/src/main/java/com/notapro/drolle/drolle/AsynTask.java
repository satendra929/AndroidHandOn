package com.notapro.drolle.drolle;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.AsyncListUtil;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AsynTask extends AppCompatActivity {

    private EditText milli;
    private Button sleepnow;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyn_task);

        milli = (EditText) findViewById(R.id.etMillisecs);
        sleepnow = (Button) findViewById(R.id.btSleep);
        status = (TextView) findViewById(R.id.tvStatus);

        sleepnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(milli.getText().toString().length()==0){
                  status.setText("Enter Time First");
                }
                else {
                    AsyncTaskRunner runner = new AsyncTaskRunner();
                    String time= milli.getText().toString();
                    runner.execute(time);
                }
            }
        });
    }

    private class AsyncTaskRunner extends AsyncTask<String , String , String>{

        private String response;
        @Override
        protected String doInBackground(String... strings) {
            publishProgress("Sleeping...");
            try {

                    int time = Integer.parseInt(strings[0]);
                    Thread.sleep(time);
                    response = "Slept for " + time + " milliseconds";

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            status.setText(result);
        }
        @Override
        protected void onProgressUpdate(String... text) {
            status.setText(text[0]);
        }

    }
}
