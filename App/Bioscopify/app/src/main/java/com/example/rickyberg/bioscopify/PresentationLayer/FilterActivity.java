package com.example.rickyberg.bioscopify.PresentationLayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        movies = (ArrayList<Movie>) getIntent().getSerializableExtra("MOVIES");

        btApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Movie> templist = new ArrayList<>();
                ArrayList<String> genres = getGenres();
                for (Movie movie : movies) {
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
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("MOVIEITEM", templist);
                startActivity(intent);
            }
        });
    }
    public ArrayList<String> getGenres()
    {
        ArrayList<String> genres = new ArrayList<>();
        genres.add(checkRadio(rdAction));
        genres.add(checkRadio(rdAdvernture));
        genres.add(checkRadio(rdAnimation));
        genres.add(checkRadio(rdComedy));
        genres.add(checkRadio(rdCrime));
        genres.add(checkRadio(rdDocumentary));
        genres.add(checkRadio(rdDrama));
        genres.add(checkRadio(rdFamily));
        genres.add(checkRadio(rdFantasy));
        genres.add(checkRadio(rdHistory));
        genres.add(checkRadio(rdMystery));
        genres.add(checkRadio(rdRomance));
        genres.add(checkRadio(rdScience));
        genres.add(checkRadio(rdTvMovie));
        genres.add(checkRadio(rdThriller));
        genres.add(checkRadio(rdWar));
        genres.add(checkRadio(rdWester));
        return genres;
    }
    public String checkRadio(RadioButton radioButton)
    {
        if (radioButton.isChecked() == true)
        {
            return radioButton.getText().toString();
        }
        else
        {
            return "";
        }
    }
}
