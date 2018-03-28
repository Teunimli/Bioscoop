package com.example.rickyberg.bioscopify.PresentationLayer;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rickyberg.bioscopify.R;


public class TicketSelectActivity extends AppCompatActivity {

    private ImageView poster;
    private TextView title;
    private EditText juniorTickets;
    private EditText normalTickets;
    private EditText seniorTickets;
    private TextView totalPrice;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.poster = (ImageView) findViewById(R.id.imageView);
        this.title = (TextView) findViewById(R.id.titleTv);
        this.juniorTickets = (EditText) findViewById(R.id.juniorTicketsEt);
        this.normalTickets = (EditText) findViewById(R.id.normalTicketsEt);
        this.seniorTickets = (EditText) findViewById(R.id.seniorTicketsEt);
        this.totalPrice = (TextView) findViewById(R.id.totalPriceTv);
        this.button = (Button) findViewById(R.id.button); //deze even renamen

    }


}
