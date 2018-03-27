package com.example.rickyberg.bioscopify.ApplicationLayer;

import android.graphics.Movie;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ricky on 27/03/2018.
 */

public abstract class JSONMovieParser {


    private static final String TAG = "JSONMovieParser";

    public static ArrayList<Movie> getMovies(String result){



        ArrayList<Movie> list = new ArrayList<>();
        try {
            Log.i(TAG, "== Converting data to JSONobject ==");
            JSONObject ObjResult = new JSONObject(result);
            JSONArray movies = ObjResult.getJSONArray("results");
            for( int idx = 0; idx < movies.length(); idx++) {
                JSONObject obj = movies.getJSONObject(idx);
                int id = obj.getInt("id");
                String title = obj.getString("title");
                boolean adult = obj.getBoolean("adult");
                String language = obj.getString("language");
                String posterpath = "https://image.tmdb.org/t/p/w500/" + obj.getString("posterpath");
                String overview = obj.getString("overview");

                ArrayList<String> genres = new ArrayList<String>();
                JSONArray arrGenres = obj.getJSONArray("genre_ids");
                for( int i = 0; i < arrGenres.length(); i++) {
                    genres.add((String) arrGenres.get(i));
                }

            }


        } catch(Exception e) {
            Log.i(TAG, "== ERROR something went wrong while trying to convert to JSON ==");
            Log.d("", e.toString());
        }

        return list;
    }
}
