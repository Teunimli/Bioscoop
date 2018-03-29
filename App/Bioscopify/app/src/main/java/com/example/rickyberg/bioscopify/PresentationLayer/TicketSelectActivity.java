package com.example.rickyberg.bioscopify.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    private double nrOfJuniorTickets;
    private double nrOfNormalTickets;
    private double nrOfSeniorTickets;
    private double totalPrice;
    private int nrOfTotalSeatsAvailable = 48;
    private int nrOfTotalSeatsSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_select);

        this.selectedMovie = (Movie) getIntent().getSerializableExtra("MOVIEITEM");

        this.posterIv = (ImageView) findViewById(R.id.imageView);
        this.titleTv = (TextView) findViewById(R.id.titleTv);
        this.juniorTicketsEt = (EditText) findViewById(R.id.juniorTicketsEt);
        this.normalTicketsEt = (EditText) findViewById(R.id.normalTicketsEt);
        this.seniorTicketsEt = (EditText) findViewById(R.id.seniorTicketsEt);
        this.totalPriceTv = (TextView) findViewById(R.id.totalPriceTv);
        this.selectSeatsButton = (Button) findViewById(R.id.selectSeatsBtn);

        Picasso.with(this).load(selectedMovie.getPosterpath()).into(posterIv);
        titleTv.setText(selectedMovie.getTitle());



        juniorTicketsEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (seatsAvailable(Integer.parseInt(editable.toString()))){
                    nrOfJuniorTickets = Double.parseDouble(editable.toString());
                    nrOfTotalSeatsSelected += Integer.parseInt(editable.toString());
                    updateTotalPrice();
                }
                else {
                    nrOfJuniorTickets = nrOfTotalSeatsAvailable - nrOfTotalSeatsSelected;
                    updateTotalPrice();
                }
            }
        });

        normalTicketsEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (seatsAvailable(Integer.parseInt(editable.toString()))){
                    nrOfNormalTickets = Double.parseDouble(editable.toString());
                    nrOfTotalSeatsSelected += Integer.parseInt(editable.toString());
                    updateTotalPrice();
                }
                else {
                    nrOfNormalTickets = nrOfTotalSeatsAvailable - nrOfTotalSeatsSelected;
                    updateTotalPrice();
                }
            }
        });

        seniorTicketsEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (seatsAvailable(Integer.parseInt(editable.toString()))){
                    nrOfSeniorTickets = Double.parseDouble(editable.toString());
                    nrOfTotalSeatsSelected += Integer.parseInt(editable.toString());
                    updateTotalPrice();
                }
                else {
                    nrOfSeniorTickets = nrOfTotalSeatsAvailable - nrOfTotalSeatsSelected;
                    updateTotalPrice();
                }

            }
        });

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
        totalPriceTv.setText(stringDouble);
    }

    public void onClick(View view)
    {
        //SEAT SELECT SCREEN

    }
}