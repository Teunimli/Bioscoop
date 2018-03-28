package com.example.rickyberg.bioscopify.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.rickyberg.bioscopify.R;

public class ConfirmationActivity extends AppCompatActivity {
    private TextView time;
    private TextView title;
    private TextView ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_activity);

        time = (TextView) findViewById(R.id.time_tv);
        title = (TextView) findViewById(R.id.movietitle_tv);
        ticket = (TextView) findViewById(R.id.ticket_tv);


    }
}
