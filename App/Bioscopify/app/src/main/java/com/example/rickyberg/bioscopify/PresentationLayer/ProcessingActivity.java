package com.example.rickyberg.bioscopify.PresentationLayer;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;

public class ProcessingActivity extends AppCompatActivity {

    private RotateAnimation anim;
    private int SEATS;
    private String TIME;
    private Movie MOVIE;
    private double PRICE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.processing_activity);

        SEATS = (int) getIntent().getSerializableExtra("SEATS");
        TIME = (String) getIntent().getSerializableExtra("TIME");
        MOVIE  = (Movie) getIntent().getSerializableExtra("MOVIE");
        PRICE = (Double) getIntent().getSerializableExtra("PRICE");
        ImageView processing = (ImageView) findViewById(R.id.processing_iv);

        anim = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(900);
        processing.startAnimation(anim);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent mainIntent = new Intent(getApplicationContext(), ConfirmationActivity.class);
                mainIntent.putExtra("MOVIE", MOVIE);
                mainIntent.putExtra("SEATS", SEATS);
                mainIntent.putExtra("PRICE", PRICE);
                mainIntent.putExtra("TIME", TIME);
                ProcessingActivity.this.startActivity(mainIntent);
                ProcessingActivity.this.finish();
            }
        }, 3000);




    }
}
