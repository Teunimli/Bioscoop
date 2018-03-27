package com.example.rickyberg.bioscopify.DomainLayer;

/**
 * Created by Michael on 27/03/2018.
 */

public class Movie {
    private int id;
    private String title;
    private boolean adult;
    private int genre;
    private String language;
    private String posterPath;
    private String overview;

    public Movie(int id, String title, boolean adult, int genre, String language, String posterPath, String overview) {
        this.id = id;
        this.title = title;
        this.adult = adult;
        this.genre = genre;
        this.language = language;
        this.posterPath = posterPath;
        this.overview = overview;
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

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", age=" + adult +
                ", genre=" + genre +
                ", Language='" + language + '\'' +
                ", posterpath='" + posterPath + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }
}
