package com.example.rickyberg.bioscopify.PresentationLayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TicketSelectActivity extends AppCompatActivity {

    private ImageView posterIv;
    private TextView titleTv;
    private TextView totalPriceTv;
    private Button selectSeatsButton;
    private Movie selectedMovie;
    private String time;

    private ArrayAdapter<Integer> adapterJunior;
    private ArrayAdapter<Integer> adapterNormal;
    private ArrayAdapter<Integer> adapterSenior;
    private ArrayList<Integer> ticketsJunior;
    private ArrayList<Integer> ticketsNormal;
    private ArrayList<Integer> ticketsSenior;
    private double totalPrice;
    private final int MAXIMUM_TICKETS = 12;
    private int amountOfTicketsSelected = 0;
    private int ticketsAvailable;
    private Spinner spinJuniorTickets;
    private Spinner spinNormalTickets;
    private Spinner spinSeniorTickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_select);
        selectedMovie = (Movie) getIntent().getSerializableExtra("MOVIEITEM");
        time = (String) getIntent().getSerializableExtra("TIME");
        posterIv = (ImageView) findViewById(R.id.imageView);
        titleTv = (TextView) findViewById(R.id.titleTv);
        totalPriceTv = (TextView) findViewById(R.id.totalPriceTv);
        selectSeatsButton = (Button) findViewById(R.id.btnTicketSelect);
        selectSeatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SeatSelectActivity.class);
                intent.putExtra("MOVIE", selectedMovie);
                intent.putExtra("SEATS", getAmountOfTicketsSelected());
                intent.putExtra("PRICE", getPrice());
                intent.putExtra("TIME", time);
                startActivity(intent);
            }
        });
        Picasso.with(this).load(selectedMovie.getPosterpath()).into(posterIv);
        titleTv.setText(selectedMovie.getTitle());

        //ticket selection
        spinJuniorTickets = (Spinner) findViewById(R.id.spinTicketJunior);
        spinNormalTickets = (Spinner) findViewById(R.id.spinTicketNormal);
        spinSeniorTickets = (Spinner) findViewById(R.id.spinTicketSenior);
        ticketsJunior = getList(12);
        ticketsNormal = getList(12);
        ticketsSenior = getList(12);
        adapterJunior = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_item, ticketsJunior);
        adapterNormal = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_item, ticketsNormal);
        adapterSenior = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_item, ticketsSenior);
        spinJuniorTickets.setAdapter(adapterJunior);
        spinNormalTickets.setAdapter(adapterNormal);
        spinSeniorTickets.setAdapter(adapterSenior);

         AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 totalPriceTv.setText("€ " + getPrice() + "0");
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         };
        spinJuniorTickets.setOnItemSelectedListener(listener);
        spinNormalTickets.setOnItemSelectedListener(listener);
        spinSeniorTickets.setOnItemSelectedListener(listener);

    }

    public double getPrice()
    {
        if(spinJuniorTickets.getSelectedItem() != null && spinNormalTickets.getSelectedItem() != null && spinSeniorTickets.getSelectedItem() != null) {
            totalPrice =
                            (Integer.parseInt(spinJuniorTickets.getSelectedItem().toString()) * 7.5) +
                            (Integer.parseInt(spinNormalTickets.getSelectedItem().toString()) * 9.0) +
                            (Integer.parseInt(spinSeniorTickets.getSelectedItem().toString()) * 8.5) ;
            return totalPrice;
        }
        return 0;
    }


    public int getAmountOfTicketsSelected() {
        if(spinJuniorTickets.getSelectedItem() != null && spinNormalTickets.getSelectedItem() != null && spinSeniorTickets.getSelectedItem() != null) {
            amountOfTicketsSelected = Integer.parseInt(spinJuniorTickets.getSelectedItem().toString()) +
                    Integer.parseInt(spinNormalTickets.getSelectedItem().toString()) +
                    Integer.parseInt(spinSeniorTickets.getSelectedItem().toString());
        }
        else
        {
            amountOfTicketsSelected = 0;
        }
        return amountOfTicketsSelected;
    }


    public ArrayList<Integer> getList(int amount){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < amount + 1; i++) {
            temp.add(i);
        }
        return temp;
    }

}