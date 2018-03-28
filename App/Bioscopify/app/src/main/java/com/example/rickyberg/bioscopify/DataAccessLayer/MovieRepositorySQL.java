package com.example.rickyberg.bioscopify.DataAccessLayer;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rickyberg.bioscopify.DomainLayer.Movie;

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
//                1);
        }

    @Override
    public Movie getMovie(int movieId) {

        String query = "SELECT * FROM Movie WHERE id = '" + movieId + "'";
        SQLiteDatabase db = sqlHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
        String title = cursor.getString(cursor.getColumnIndex("title"));
        int adultInt = Integer.parseInt(cursor.getString(cursor.getColumnIndex("adult")));
        String genre= cursor.getString(cursor.getColumnIndex("genre"));
        String language= cursor.getString(cursor.getColumnIndex("language"));
        String posterpath = cursor.getString(cursor.getColumnIndex("posterpath"));
        String overview = cursor.getString(cursor.getColumnIndex("overview"));

        boolean adult;

        if (adultInt == 1){
            adult = true;
        }
        else {
            adult = false;
        }

        Movie movie = new Movie(id, title, adult, genre, language, posterpath, overview);

        cursor.close();
        db.close(); //Hier db.close of de sqlhandler.closeConnection? of beide?
        sqlHandler.closeConnection(); //beide denk? ze hebben beide een instantie van de DB.

        return movie;
    }

    @Override
    public ArrayList<Movie> getAll() {

        String query = "SELECT * FROM Movie";
        SQLiteDatabase db = sqlHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<Movie> Movies = new ArrayList<>();

        cursor.moveToFirst();
        while(cursor.getPosition() < cursor.getCount()) {
            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            int adultInt = Integer.parseInt(cursor.getString(cursor.getColumnIndex("adult")));
            String genre= cursor.getString(cursor.getColumnIndex("genre"));
            String language= cursor.getString(cursor.getColumnIndex("language"));
            String posterpath = cursor.getString(cursor.getColumnIndex("posterpath"));
            String overview = cursor.getString(cursor.getColumnIndex("overview"));

            boolean adult;

            if (adultInt == 1){
                adult = true;
            }
            else {
                adult = false;
            }

            Movies.add(new Movie(id, title, adult, genre, language, posterpath, overview));
            cursor.moveToNext();
        }

        cursor.close();
        db.close(); //Hier db.close of de sqlhandler.closeConnection? of beide?
        sqlHandler.closeConnection(); //beide denk? ze hebben beide een instantie van de DB.
        return Movies;
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
