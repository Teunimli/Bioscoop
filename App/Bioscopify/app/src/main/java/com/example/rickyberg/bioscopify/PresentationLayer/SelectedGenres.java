package com.example.rickyberg.bioscopify.PresentationLayer;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Ricky on 30/03/2018.
 */

public class SelectedGenres {
    private static final SelectedGenres ourInstance = new SelectedGenres();

    public static SelectedGenres getInstance() {
        return ourInstance;
    }
    ArrayList<String> genres = new ArrayList<>();

    private SelectedGenres() {
    }

    public void addGenre(String genre)
    {
        if(!genres.contains(genre))
        genres.add(genre);
    }

    public ArrayList<String> getGenres(String genre)
    {
        return genres;
    }

    public void removeGenre(String genre)
    {
        genres.remove(genre);
    }

    public void clearGenres()
    {
        genres.clear();
    }
}
