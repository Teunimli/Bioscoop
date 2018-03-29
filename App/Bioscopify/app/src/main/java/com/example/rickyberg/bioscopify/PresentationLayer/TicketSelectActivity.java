package com.example.rickyberg.bioscopify.PresentationLayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;
import com.squareup.picasso.Picasso;

public class TicketSelectActivity extends AppCompatActivity {

    private ImageView posterIv;
    private TextView titleTv;
    private EditText juniorTicketsEt;
    private EditText normalTicketsEt;
    private EditText seniorTicketsEt;
    private TextView totalPriceTv;
    private Button selectSeatsButton;
    private Movie selectedMovie;
    private String time;

    private int nrOfJuniorTickets; // veranderen naar int
    private int nrOfNormalTickets;
    private int nrOfSeniorTickets;
    private double totalPrice;
    private int nrOfTotalSeatsAvailable = 48;
    private int nrOfTotalSeatsSelected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_select);

        this.selectedMovie = (Movie) getIntent().getSerializableExtra("MOVIEITEM");
        time = (String) getIntent().getSerializableExtra("TIME");

        this.posterIv = (ImageView) findViewById(R.id.imageView);
        this.titleTv = (TextView) findViewById(R.id.titleTv);
        this.juniorTicketsEt = (EditText) findViewById(R.id.juniorTicketsEt);
        this.normalTicketsEt = (EditText) findViewById(R.id.normalTicketsEt);
        this.seniorTicketsEt = (EditText) findViewById(R.id.seniorTicketsEt);
        this.totalPriceTv = (TextView) findViewById(R.id.totalPriceTv);
        this.selectSeatsButton = (Button) findViewById(R.id.btnTicketSelect);
        selectSeatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SeatSelectActivity.class);
                intent.putExtra("MOVIE", selectedMovie);
                intent.putExtra("SEATS",nrOfTotalSeatsSelected);
                intent.putExtra("PRICE", totalPrice);
                startActivity(intent);
            }
        });

        Picasso.with(this).load(selectedMovie.getPosterpath()).into(posterIv);
        titleTv.setText(selectedMovie.getTitle());

        TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().equals("")) {
                    if (seatsAvailable(Integer.parseInt(editable.toString()))) {
                        nrOfNormalTickets = Integer.parseInt(editable.toString());
                        nrOfTotalSeatsSelected += Integer.parseInt(editable.toString());
                        updateTotalPrice();
                    } else {
                        nrOfNormalTickets = nrOfTotalSeatsAvailable - nrOfTotalSeatsSelected;
                        editable.clear();
                        CharSequence seq = Integer.toString(nrOfTotalSeatsAvailable - nrOfTotalSeatsSelected);
                        editable.append(seq);
                        updateTotalPrice();
                    }
                }
            }
        };
        juniorTicketsEt.addTextChangedListener(tw);
        normalTicketsEt.addTextChangedListener(tw);
        seniorTicketsEt.addTextChangedListener(tw);
    }


    private boolean seatsAvailable(int extraSeats){
        if (nrOfTotalSeatsSelected + extraSeats <= nrOfTotalSeatsAvailable){
            return true;
        }
        else {
            return false;
        }
    }

    private void updateTotalPrice(){

        totalPrice = nrOfJuniorTickets * 7.50 + nrOfNormalTickets * 9.00 + nrOfSeniorTickets * 8.50;

        String stringDouble = Double.toString(totalPrice);
        totalPriceTv.setText("€ " + stringDouble);
    }
}