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

    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;
    private int check = 0;
    private Spinner spinJuniorTickets;
    private Spinner spinNormalTickets;
    private Spinner spinSeniorTickets;
    private ArrayList<String> ticketList;
    private double totalPrice;
    private int nrOfTotalSeatsAvailable = 12;
    private int nrOfTotalTicketsSelected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_select);

        this.selectedMovie = (Movie) getIntent().getSerializableExtra("MOVIEITEM");
        time = (String) getIntent().getSerializableExtra("TIME");

        this.ticketList = new ArrayList<>();
        this.posterIv = (ImageView) findViewById(R.id.imageView);
        this.titleTv = (TextView) findViewById(R.id.titleTv);
        this.totalPriceTv = (TextView) findViewById(R.id.totalPriceTv);
        this.selectSeatsButton = (Button) findViewById(R.id.btnTicketSelect);
        this.spinJuniorTickets = (Spinner) findViewById(R.id.spinTicketJunior);
        this.spinNormalTickets = (Spinner) findViewById(R.id.spinTicketNormal);
        this.spinSeniorTickets = (Spinner) findViewById(R.id.spinTicketSenior);
        selectSeatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SeatSelectActivity.class);
                intent.putExtra("MOVIE", selectedMovie);
                intent.putExtra("SEATS", 1);
                intent.putExtra("PRICE", totalPrice);
                intent.putExtra("TIME", time);
                startActivity(intent);
            }
        });
        fillSpinner(nrOfTotalSeatsAvailable);
        adapter = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_spinner_item, ticketList);
        adapter2 = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_spinner_item, ticketList);
        adapter3 = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_spinner_item, ticketList);
        spinJuniorTickets.setAdapter(adapter);
        spinNormalTickets.setAdapter(adapter2);
        spinSeniorTickets.setAdapter(adapter3);

        final ArrayList<Spinner> spinners = new ArrayList<>();

        Picasso.with(this).load(selectedMovie.getPosterpath()).into(posterIv);
        titleTv.setText(selectedMovie.getTitle());

        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (++check > 3) {
                    Spinner spin = (Spinner) adapterView;
                    int x = Integer.parseInt(spin.getSelectedItem().toString());

                    fillSpinner(nrOfTotalSeatsAvailable - x);
                    updateSeats();


                        switch (adapterView.getId()) {
                            case R.id.spinTicketJunior:
                                adapter2.notifyDataSetChanged();
                                adapter3.notifyDataSetChanged();
                                break;
                            case R.id.spinTicketNormal:
                                adapter.notifyDataSetChanged();
                                adapter3.notifyDataSetChanged();
                                break;
                            case R.id.spinTicketSenior:
                                adapter2.notifyDataSetChanged();
                                adapter.notifyDataSetChanged();
                                break;
                        }
                    }

                    Log.i("================", "seats: " + nrOfTotalSeatsAvailable);
                    Log.i("================", "event ran: " + check);
                }



            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        spinJuniorTickets.setOnItemSelectedListener(listener);
        spinNormalTickets.setOnItemSelectedListener(listener);
        spinSeniorTickets.setOnItemSelectedListener(listener);

    }

    private void updateSeats()
    {
        nrOfTotalSeatsAvailable = Integer.parseInt(spinJuniorTickets.getSelectedItem().toString()) -
                Integer.parseInt(spinNormalTickets.getSelectedItem().toString()) -
                Integer.parseInt(spinSeniorTickets.getSelectedItem().toString());
    }

    private void fillSpinner(int amount) {
        ticketList.clear();
        for (int i = 0; i < amount + 1; i++) {
            ticketList.add("" + i);
        }
    }

}