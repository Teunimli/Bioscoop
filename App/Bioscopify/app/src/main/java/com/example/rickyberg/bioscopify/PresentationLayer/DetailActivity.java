package com.example.rickyberg.bioscopify.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
private ImageView poster;
private TextView title;
private TextView adult;
private TextView language;
private TextView genre;
private TextView time;
private TextView overview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Movie item = (Movie) getIntent().getSerializableExtra("MOVIEITEM");
        int position = (int)getIntent().getSerializableExtra("POSITION");
        poster = (ImageView) findViewById(R.id.posterTv);
        title = (TextView) findViewById(R.id.titleTv);
        adult = (TextView) findViewById(R.id.ageTv);
        language = (TextView) findViewById(R.id.languageTv);
        genre = (TextView) findViewById(R.id.genreTv);
        time = (TextView) findViewById(R.id.movietimeTV);
        overview = (TextView) findViewById(R.id.overviewTv);
        Picasso.with(this).load(item.getPosterpath()).into(poster);
        title.setText(item.getTitle());
        if (item.getAge() == true)
        {
            adult.setText("Age: 18+");
        }
        else
        {
            adult.setText("Age: 0-17");
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
    public void onClick(View view)
    {
        //TICKET SELECT SCREEN
    }
}
