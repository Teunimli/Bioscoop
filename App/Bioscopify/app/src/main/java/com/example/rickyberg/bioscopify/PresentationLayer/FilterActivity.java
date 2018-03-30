package com.example.rickyberg.bioscopify.PresentationLayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.rickyberg.bioscopify.DomainLayer.Genre;
import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.DomainLayer.MovieGenres;
import com.example.rickyberg.bioscopify.R;

import java.util.ArrayList;
import java.util.Collections;

public class FilterActivity extends AppCompatActivity {
    private ListView lvGenres;
    private Button btApply;
    private ArrayList<Movie> movies;
    private ArrayList<String> genres;
    private ArrayList<Genre> _genres;
    private FilterAdapter adapter;
    private ArrayList<String> selectedGenres = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        setContentView(R.layout.activity_filter);
        genres = new ArrayList<String>(MovieGenres.getList().values());
        Collections.sort(genres);
        _genres = new ArrayList<>();
        for (String s : genres) {
            _genres.add(new Genre(s));
        }
        adapter = new FilterAdapter(this, _genres);
        lvGenres = (ListView) findViewById(R.id.lvGenres);
        lvGenres.setAdapter(adapter);
        btApply = (Button) findViewById(R.id.btApply);
        movies = (ArrayList<Movie>) getIntent().getSerializableExtra("MOVIEITEMS");
        selectedGenres = new ArrayList<>();

        lvGenres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Genre model = _genres.get(i);

                if (model.isSelected()) {
                    model.setSelected(false);
                    selectedGenres.remove(model.getGenre());
                }
                else {
                    if(!selectedGenres.contains(model.getGenre())) {
                        selectedGenres.add(model.getGenre());
                    }
                    model.setSelected(true);
                }

                adapter.notifyDataSetChanged();

            }
        });

        btApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedGenres.size() == 0)
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    ArrayList<Movie> templist = new ArrayList<>();
                    for (Movie movie : movies) {
                        if (selectedGenres.isEmpty()) {
                            templist = null;
                        } else {
                            for (int i = 0; i < selectedGenres.size(); i++) {

                                if (movie.getGenre().contains(selectedGenres.get(i))) {
                                    if (!templist.contains(movie)) {
                                        templist.add(movie);
                                    }
                                }
                            }
                        }
                    }
                    Intent intent = new Intent(getApplicationContext(), FilterViewActivity.class);
                    intent.putExtra("MOVIEITEMS", templist);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar_filter_trash, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home/back button
            case android.R.id.home:
                finish();
                break;
            case R.id.btnTrash:
                for (Genre g: _genres) {
                    g.setSelected(false);
                    selectedGenres.clear();
                    adapter.notifyDataSetChanged();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
