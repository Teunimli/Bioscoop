package com.example.rickyberg.bioscopify.DomainLayer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Michael on 27/03/2018.
 */

public class Movie implements Serializable {
    private int id;
    private String title;
    private boolean adult;
    private ArrayList<String> genre;
    private String language;
    private String posterPath;
    private String backdrop;
    private String overview;

    public Movie(int id, String title, boolean adult, ArrayList<String> genre, String language, String posterPath, String overview, String backdrop) {
        this.id = id;
        this.title = title;
        this.adult = adult;
        this.genre = genre;
        this.language = language;
        this.posterPath = posterPath;
        this.overview = overview;
        this.backdrop = backdrop;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getAge() {
        return adult;
    }

    public void setAge(boolean age) {
        this.adult = age;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        language = language;
    }

    public String getPosterpath() {
        return posterPath;
    }

    public void setPosterpath(String posterpath) {
        this.posterPath = posterpath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", age=" + adult +
                ", genre=" + genre.toString() +
                ", Language='" + language + '\'' +
                ", posterpath='" + posterPath + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }
}
