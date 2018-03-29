package com.example.rickyberg.bioscopify.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;

public class ConfirmationActivity extends AppCompatActivity {
    private TextView time;
    private TextView title;
    private TextView ticket;

    private int SEATS;
    private String TIME;
    private Movie movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_activity);
        movie  = (Movie) getIntent().getSerializableExtra("MOVIE");

        time = (TextView) findViewById(R.id.time_tv);
        title = (TextView) findViewById(R.id.movietitle_tv);
        ticket =(TextView) findViewById(R.id.ticket_tv);

        SEATS = (int) getIntent().getSerializableExtra("SEATS");
        TIME = (String) getIntent().getSerializableExtra("TIME");

        title.setText(movie.getTitle());
        time.setText(TIME);
        ticket.setText(""+SEATS);


    }
}
