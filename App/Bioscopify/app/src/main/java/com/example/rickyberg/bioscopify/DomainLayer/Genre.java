package com.example.rickyberg.bioscopify.DomainLayer;

/**
 * Created by Ricky on 30/03/2018.
 */

public class Genre {

    boolean isSelected;
    String genre;

    public Genre(String genre) {
        this.isSelected = false;
        this.genre = genre;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
