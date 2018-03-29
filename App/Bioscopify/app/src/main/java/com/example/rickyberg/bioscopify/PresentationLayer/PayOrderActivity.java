package com.example.rickyberg.bioscopify.PresentationLayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;

import java.io.Serializable;

public class PayOrderActivity extends AppCompatActivity {
    private TextView total;
    private TextView time;
    private TextView title;
    private TextView ticket;

    private double price;
    private int SEATS;
    private String TIME;
    private Movie movie;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payorder_activity);
        total = (TextView) findViewById(R.id.total_tv);
        movie = (Movie) getIntent().getSerializableExtra("MOVIE");

        time = (TextView) findViewById(R.id.time_tv);
        title = (TextView) findViewById(R.id.movietitle_tv);
        ticket = (TextView) findViewById(R.id.ticket_tv);

        SEATS = (int) getIntent().getSerializableExtra("SEATS");
        TIME = (String) getIntent().getSerializableExtra("TIME");
        price = (Double) getIntent().getSerializableExtra("PRICE");

        title.setText("Movie: " + movie.getTitle());
        time.setText("Time: " + TIME);
        ticket.setText("Tickets: " + SEATS);


        total.setText("Total: " + price);
    }

    public void PaymentClick(View view) {
        Intent intent = new Intent(getApplicationContext(), ProcessingActivity.class);
        intent.putExtra("MOVIE", movie);
        intent.putExtra("SEATS", SEATS);
        intent.putExtra("PRICE", price);
        intent.putExtra("TIME", TIME);
        startActivity(intent);


    }

}
