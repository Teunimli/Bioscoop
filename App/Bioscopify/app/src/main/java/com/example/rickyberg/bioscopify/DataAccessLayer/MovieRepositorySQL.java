package com.example.rickyberg.bioscopify.DataAccessLayer;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Movie;

import java.util.ArrayList;


/**
 * Created by Kevin on 27/03/2018.
 */

public class MovieRepositorySQL implements MovieRepositoryInterface {

    SQLiteDatabase sqLiteDatabase;
    SqlHandler sqlHandler;

    public MovieRepositorySQL() {
//        sqlHandler = new SqlHandler(getApplicationContext(),
//                "Items.db",
//                null,
//                2);
        sqLiteDatabase = sqlHandler.getDatabase();
    }

    @Override
    public Movie getMovie(int id) {
        return null;
    }

    @Override
    public ArrayList<Movie> getAll() {
        return null;
    }

    @Override
    public boolean addMovie(Movie movie) {
        return false;
    }

    @Override
    public boolean deleteMovie(int id) {
        return false;
    }
}
