package com.example.rickyberg.bioscopify.DomainLayer;

/**
 * Created by Michael on 27/03/2018.
 */

public class Movie {
    private int id;
    private String title;
    private int age;
    private int genre;
    private String Language;
    private String posterpath;
    private String overview;

    public Movie(int id, String title, int age, int genre, String language, String posterpath, String overview) {
        this.id = id;
        this.title = title;
        this.age = age;
        this.genre = genre;
        Language = language;
        this.posterpath = posterpath;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getPosterpath() {
        return posterpath;
    }

    public void setPosterpath(String posterpath) {
        this.posterpath = posterpath;
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
                ", age=" + age +
                ", genre=" + genre +
                ", Language='" + Language + '\'' +
                ", posterpath='" + posterpath + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }
}
