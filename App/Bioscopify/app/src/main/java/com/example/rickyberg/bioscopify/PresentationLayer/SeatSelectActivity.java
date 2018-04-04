package com.example.rickyberg.bioscopify.PresentationLayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;

import java.util.ArrayList;

public class SeatSelectActivity extends AppCompatActivity {
    private ArrayList numbers;
    private GridView gridView;
    private ArrayAdapter<String> adapter;
    private int backposition = -1;
    private int seatCount;
    private TextView title;
    private TextView seats;
    private Movie movie;
    private Button nextbtn;
    private int tickets;
    private double price;
    private String time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_select);
        numbers = new ArrayList();
        for (int i = 1; i <=48; i++) {
            numbers.add(""+i);
        }
        title = (TextView) findViewById(R.id.tvTitleMovieSeatScreen);
        seats = (TextView) findViewById(R.id.tvSeatCount);
        nextbtn = (Button) findViewById(R.id.btNextSeatscreen);
        movie = (Movie) getIntent().getSerializableExtra("MOVIE");
        title.setText(movie.getTitle());
        seatCount = (int) getIntent().getSerializableExtra("SEATS");
        tickets = (int) getIntent().getSerializableExtra("SEATS");
        price = (double) getIntent().getSerializableExtra("PRICE");
        time = (String) getIntent().getSerializableExtra("TIME");
        seats.setText("Choose "+seatCount+" seats");
        gridView = (GridView) findViewById(R.id.gbSeatSelect);
        gridView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(getResources().getColor(R.color.colorWhite));
                return view;
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (seatCount >0)
                {
                    String selectedItem = adapterView.getItemAtPosition(i).toString();

                    TextView GridViewItems = (TextView) view;
                    if (GridViewItems.getText().toString().contains("."))
                    {
                        GridViewItems.setTextColor(getResources().getColor(R.color.colorWhite));
                        GridViewItems.setBackgroundResource(R.color.colorPrimary);

                        int text = i++;
                        GridViewItems.setText(""+i);
                        seatCount++;
                        seats.setText("Choose "+seatCount+" seats");

                    }
                    else
                    {
                        GridViewItems.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        GridViewItems.setBackgroundResource(R.color.colorWhite);

                        GridViewItems.setText(GridViewItems.getText()+".");
                        seatCount--;
                        seats.setText("Choose "+seatCount+" seats");
                    }

                }
                else if (seatCount == 0)
                {
                    String selectedItem = adapterView.getItemAtPosition(i).toString();

                    TextView GridViewItems = (TextView) view;
                    if (GridViewItems.getText().toString().contains(".")) {
                        GridViewItems.setTextColor(getResources().getColor(R.color.colorWhite));
                        GridViewItems.setBackgroundResource(R.color.colorPrimary);
                        int text = i++;
                        GridViewItems.setText("" + i);
                        seatCount++;
                        seats.setText("Choose "+seatCount+" seats");
                    }
                }

            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (seatCount == 0)
                {
                    Intent intent = new Intent(getApplicationContext(), PayOrderActivity.class);
                    intent.putExtra("MOVIE", movie);
                    intent.putExtra("SEATS", tickets);
                    intent.putExtra("PRICE", price);
                    intent.putExtra("TIME", time);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Not all seats selected",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
