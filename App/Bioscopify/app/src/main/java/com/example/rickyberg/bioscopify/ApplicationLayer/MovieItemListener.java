package com.example.rickyberg.bioscopify.ApplicationLayer;

import com.example.rickyberg.bioscopify.DomainLayer.Movie;

/**
 * Created by Michael on 27/03/2018.
 */

public interface MovieItemListener
{
    void onMoviesAvailable(Movie item);
}
