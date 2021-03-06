package com.example.rickyberg.bioscopify.DataAccessLayer;


import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import java.util.ArrayList;

/**
 * Created by Kevin on 27/03/2018.
 */

public interface MovieRepositoryInterface {

    Movie getMovie(int id);
    ArrayList<Movie> getAll();
    boolean addMovie(Movie movie);
    boolean deleteMovie(int id);

}
