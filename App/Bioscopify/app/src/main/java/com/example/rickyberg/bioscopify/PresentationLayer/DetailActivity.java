package com.example.rickyberg.bioscopify.PresentationLayer;

import android.content.Intent;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rickyberg.bioscopify.ApplicationLayer.RandomMovieDate;
import com.example.rickyberg.bioscopify.DataAccessLayer.MovieRepositoryInterface;
import com.example.rickyberg.bioscopify.DataAccessLayer.MovieRepositorySQL;
import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    private MovieRepositoryInterface movieRepository;
    private Movie item;
    private ImageView poster;
    private TextView title;
    private TextView adult;
    private TextView language;
    private TextView genre;
    private TextView time;
    private TextView overview;
    private TextView day;
    private String TIME;
    private FloatingActionButton floatingActionButton;
    private boolean isFavorite;
    private ImageView backdropImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        item = (Movie) getIntent().getSerializableExtra("MOVIEITEM");
        int position = (int)getIntent().getSerializableExtra("POSITION");
         movieRepository = new MovieRepositorySQL(this);
        poster = (ImageView) findViewById(R.id.posterTv);
        title = (TextView) findViewById(R.id.titleTv);
        adult = (TextView) findViewById(R.id.ageTv);
        language = (TextView) findViewById(R.id.languageTv);
        genre = (TextView) findViewById(R.id.genreTv);
        time = (TextView) findViewById(R.id.movietimeTV);
        overview = (TextView) findViewById(R.id.overviewTv);
        day = (TextView) findViewById(R.id.tvDay);
        backdropImageview = (ImageView) findViewById(R.id.ivBackdropDetailed);
        Picasso.with(this).load(item.getPosterpath()).into(poster);
        if(!item.getBackdrop().equals("noimage"))
        {
            Picasso.with(this).load(item.getBackdrop()).into(backdropImageview);
        }
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fabDetailFavorite);
        checkIfFavorite();
        title.setText(item.getTitle());
        if (item.getAge() == true)
        {
            adult.setText("Age: 18+");
        }
        else
        {
            adult.setText("Age: All");
        }
        switch (item.getLanguage())
        {
            case "en":
                language.setText("Spoken: English");
                break;
                case "nl":
                    language.setText("Spoken: Dutch");
                    break;

        }
        String genreString = "Genres: ";
        for (int i = 0; i < item.getGenre().size(); i++) {
            if (i == item.getGenre().size() - 1)
                genreString += "" + item.getGenre().get(i);
            else
                genreString += "" + item.getGenre().get(i) + ", ";
        }
        genre.setText(genreString);
        RandomMovieDate movieDate = new RandomMovieDate();
        if (position <=3)
        {
            if (movieDate.hasTimePassed(Calendar.getInstance(Locale.FRANCE), "10:00"))
                day.setText("Tomorrow");

            time.setText("10:00");
        }
        else if(position <=6)
        {
            if (movieDate.hasTimePassed(Calendar.getInstance(Locale.FRANCE), "12:00"))
                day.setText("Tomorrow");
            time.setText("12:00");
        }
        else if (position <= 9)
        {
            if (movieDate.hasTimePassed(Calendar.getInstance(Locale.FRANCE), "14:00"))
                day.setText("Tomorrow");
            time.setText("14:00");
        }
        else if (position <= 12)
        {
            if (movieDate.hasTimePassed(Calendar.getInstance(Locale.FRANCE), "16:00"))
                day.setText("Tomorrow");
            time.setText("16:00");
        }
        else if (position <= 15)
        {
            if (movieDate.hasTimePassed(Calendar.getInstance(Locale.FRANCE), "18:00"))
                day.setText("Tomorrow");
            time.setText("18:00");
        }
        else if (position <= 18)
        {
            if (movieDate.hasTimePassed(Calendar.getInstance(Locale.FRANCE), "20:00"))
                day.setText("Tomorrow");
            time.setText("20:00");
        }
        else
        {
            if (movieDate.hasTimePassed(Calendar.getInstance(Locale.FRANCE), "22:00"))
                day.setText("Tomorrow");
            time.setText("22:00");
        }
        overview.setText(item.getOverview());

    }
    public void checkIfFavorite(){
        try {
            if (movieRepository.getMovie(item.getId()) != null) {
                floatingActionButton.setImageResource(R.drawable.ic_favorite);
                isFavorite = true;
            }
        }catch (CursorIndexOutOfBoundsException ex) {
            floatingActionButton.setImageResource(R.drawable.ic_not_enabled_favorite);
            isFavorite = false;
        }
    }

    public void onClick(View view)
    {
        //TICKET SELECT SCREEN
        TIME = time.getText().toString();
        Intent intent = new Intent(getApplicationContext(), TicketSelectActivity.class);
        intent.putExtra("MOVIEITEM", item);
        intent.putExtra("TIME",TIME);
        startActivity(intent);

    }

    public void addToFavorites(View view){
        if (isFavorite) {
            movieRepository.deleteMovie(item.getId());
            floatingActionButton.setImageResource(R.drawable.ic_not_enabled_favorite);
            isFavorite = false;
        }
        else
        {
            movieRepository.addMovie(item);
            floatingActionButton.setImageResource(R.drawable.ic_favorite);
            isFavorite = true;
        }

    }
}
