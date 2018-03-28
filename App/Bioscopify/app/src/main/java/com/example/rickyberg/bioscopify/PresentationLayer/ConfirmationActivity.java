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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_activity);
        Movie item = (Movie) getIntent().getSerializableExtra("MOVIEITEM");
        int position = (int)getIntent().getSerializableExtra("POSITION");

        time = (TextView) findViewById(R.id.time_tv);
        title = (TextView) findViewById(R.id.movietitle_tv);
        ticket = (TextView) findViewById(R.id.ticket_tv);

        title.setText(item.getTitle());
        if (position <=3)
        {
            time.setText("10:00");
        }
        else if(position <=6)
        {
            time.setText("12:00");
        }
        else if (position <= 9)
        {
            time.setText("14:00");
        }
        else if (position <= 12)
        {
            time.setText("16:00");
        }
        else if (position <= 15)
        {
            time.setText("18:00");
        }
        else if (position <= 18)
        {
            time.setText("20:00");
        }
        else
        {
            time.setText("22:00");
        }

    }
}
