package com.groupec.getdatetimefromntp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static String dateTimeFromNTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* TimeZone.getTimeZone("Asia/Colombo") to spécific zone */
        SNTPClient.getDate(Calendar.getInstance().getTimeZone(), new SNTPClient.Listener() {
            @Override
            public void onTimeResponse(String rawDate, Date date, Exception ex) {
                dateTimeFromNTP =rawDate;
                TextView text = (TextView) findViewById(R.id.text);
                text.setText(rawDate);
            }

            public void onError(Exception ex) {
                Log.i("SNTPClient", ex.getMessage());
            }
        });

    }

}