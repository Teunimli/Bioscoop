package com.example.rickyberg.bioscopify.PresentationLayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;

import java.util.ArrayList;

public class FilterActivity extends AppCompatActivity {
    private RadioButton rdAction;
    private RadioButton rdAdvernture;
    private RadioButton rdAnimation;
    private RadioButton rdComedy;
    private RadioButton rdCrime;
    private RadioButton rdDocumentary;
    private RadioButton rdDrama;
    private RadioButton rdFamily;
    private RadioButton rdFantasy;
    private RadioButton rdHistory;
    private RadioButton rdMystery;
    private RadioButton rdRomance;
    private RadioButton rdScience;
    private RadioButton rdTvMovie;
    private RadioButton rdThriller;
    private RadioButton rdWar;
    private RadioButton rdWester;
    private Button btApply;
    private ArrayList<Movie> movies;
    private ArrayList<String> genres = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        rdAction = (RadioButton) findViewById(R.id.rbAction);
        rdAdvernture = (RadioButton) findViewById(R.id.rbAdventure);
        rdAnimation = (RadioButton) findViewById(R.id.rbAnimation);
        rdComedy = (RadioButton) findViewById(R.id.rbComedy);
        rdCrime = (RadioButton) findViewById(R.id.rbCrime);
        rdDocumentary = (RadioButton) findViewById(R.id.rbDocumentary);
        rdDrama = (RadioButton) findViewById(R.id.rbDrama);
        rdFamily = (RadioButton) findViewById(R.id.rbFamily);
        rdFantasy = (RadioButton) findViewById(R.id.rbFantasy);
        rdHistory = (RadioButton) findViewById(R.id.rbHistory);
        rdMystery = (RadioButton) findViewById(R.id.rbMystery);
        rdRomance = (RadioButton) findViewById(R.id.rbRomance);
        rdScience = (RadioButton) findViewById(R.id.rbScience);
        rdTvMovie = (RadioButton) findViewById(R.id.rbTVmovie);
        rdThriller = (RadioButton) findViewById(R.id.rbThriller);
        rdWar = (RadioButton) findViewById(R.id.rbWar);
        rdWester = (RadioButton) findViewById(R.id.rbWestern);
        btApply = (Button) findViewById(R.id.btApply);
        movies = (ArrayList<Movie>) getIntent().getSerializableExtra("MOVIEITEMS");

        btApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Movie> templist = new ArrayList<>();
                getGenres();
                for (Movie movie : movies) {
                    if (genres.isEmpty())
                    {
                        templist = null;
                    }
                    else
                    {
                        for (int i = 0; i < genres.size(); i++) {

                            if(movie.getGenre().contains(genres.get(i)))
                            {
                                if (!templist.contains(movie))
                                {
                                    templist.add(movie);
                                }
                            }
                        }
                    }
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("MOVIEITEMS", templist);
                startActivity(intent);
            }
        });
    }
    public ArrayList<String> getGenres()
    {
        checkRadio(rdAction);
        checkRadio(rdAdvernture);
        checkRadio(rdAnimation);
        checkRadio(rdComedy);
        checkRadio(rdCrime);
        checkRadio(rdDocumentary);
        checkRadio(rdDrama);
        checkRadio(rdFamily);
        checkRadio(rdFantasy);
        checkRadio(rdHistory);
        checkRadio(rdMystery);
        checkRadio(rdRomance);
        checkRadio(rdScience);
        checkRadio(rdTvMovie);
        checkRadio(rdThriller);
        checkRadio(rdWar);
        checkRadio(rdWester);
        return genres;
    }
    public void checkRadio(RadioButton radioButton)
    {
        if (radioButton.isChecked() == true)
        {
            genres.add(radioButton.getText().toString());
        }
    }
}
