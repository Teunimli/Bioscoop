package com.example.rickyberg.bioscopify.DataAccessLayer;


import android.graphics.Movie;

import java.util.ArrayList;

/**
 * Created by Kevin on 27/03/2018.
 */

public interface MovieRepositoryInterface {

    public Movie getMovie(int id);
    public ArrayList<Movie> getAll();
    public boolean addMovie(Movie movie);
    public boolean deleteMovie(int id);

}
