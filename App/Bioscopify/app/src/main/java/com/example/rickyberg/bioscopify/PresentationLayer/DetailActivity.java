package com.example.rickyberg.bioscopify.PresentationLayer;

import android.content.Intent;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rickyberg.bioscopify.DataAccessLayer.MovieRepositoryInterface;
import com.example.rickyberg.bioscopify.DataAccessLayer.MovieRepositorySQL;
import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;
import com.squareup.picasso.Picasso;

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
        language.setText(item.getLanguage());
        genre.setText(item.getGenre().toString());
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
        Intent intent = new Intent(getApplicationContext(), TicketSelectActivity.class);
        intent.putExtra("MOVIEITEM", item);
        intent.putExtra("TIME",time.getText());
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
