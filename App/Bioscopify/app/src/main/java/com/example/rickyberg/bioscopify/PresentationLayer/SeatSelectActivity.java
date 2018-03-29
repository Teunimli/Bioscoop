package com.example.rickyberg.bioscopify.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.rickyberg.bioscopify.R;

import java.util.ArrayList;

public class SeatSelectActivity extends AppCompatActivity {
    private ArrayList numbers;
    private GridView gridView;
    private ArrayAdapter<String> adapter;
    private int backposition = -1;
    private int seatCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_select);
        seatCount = 5;//AANTAL TICKETS GEKOCHT;
        numbers = new ArrayList();
        for (int i = 1; i <=48; i++) {
            numbers.add(""+i);
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,numbers);
        gridView = (GridView) findViewById(R.id.gbSeatSelect);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (seatCount >0)
                {
                    String selectedItem = adapterView.getItemAtPosition(i).toString();

                    TextView GridViewItems = (TextView) view;
                    if (GridViewItems.getText().toString().contains("."))
                    {
                        GridViewItems.setBackgroundResource(R.color.notClickedSeat);

                        int text = i++;
                        GridViewItems.setText(""+i);
                        seatCount++;

                    }
                    else
                    {
                        GridViewItems.setBackgroundResource(R.color.clickedSeat);

                        GridViewItems.setText(GridViewItems.getText()+".");
                        seatCount--;
                    }

                }
                else if (seatCount == 0)
                {
                    String selectedItem = adapterView.getItemAtPosition(i).toString();

                    TextView GridViewItems = (TextView) view;
                    if (GridViewItems.getText().toString().contains(".")) {
                        GridViewItems.setBackgroundResource(R.color.notClickedSeat);
                        int text = i++;
                        GridViewItems.setText("" + i);
                        seatCount++;
                    }
                }

            }
        });
    }
}
