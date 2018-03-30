package com.example.rickyberg.bioscopify.PresentationLayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.rickyberg.bioscopify.DomainLayer.Genre;
import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;

import java.util.ArrayList;

public class FilterViewActivity extends AppCompatActivity {

    private GridView gvResult;
    private ArrayList<Movie> filtered;
    private ArrayList<String> genres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_view);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        gvResult = (GridView) findViewById(R.id.movieListResult);

        filtered = new ArrayList<>();
        filtered = (ArrayList<Movie>) getIntent().getSerializableExtra("MOVIEITEMS");
        ArrayAdapter<Movie> adapter = new movieListAdapter(this, filtered);
        gvResult.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar_spinner_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home/back button
            case android.R.id.home:
                Intent intentHome = new Intent(getApplicationContext(), HomeFragment.class);
                startActivity(intentHome);
                break;
            case R.id.mybutton:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
