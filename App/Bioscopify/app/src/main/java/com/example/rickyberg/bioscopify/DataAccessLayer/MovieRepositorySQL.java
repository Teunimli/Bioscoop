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
        String language= cursor.getString(cursor.getColumnIndex("language"));
        String posterpath = cursor.getString(cursor.getColumnIndex("posterpath"));
        String overview = cursor.getString(cursor.getColumnIndex("overview"));

        String genre = cursor.getString(cursor.getColumnIndex("genre"));
        String[] genreParts = genre.split("");

        ArrayList<String> genreList = new ArrayList<>();

        for (int i = 0; i > genreParts.length; i++){
            genreList.add(genreParts[i]);
        }

        int adultInt = Integer.parseInt(cursor.getString(cursor.getColumnIndex("adult")));
        boolean adult;

        if (adultInt == 1){
            adult = true;
        }
        else {
            adult = false;
        }


        Movie movie = new Movie(id, title, adult, genreList, language, posterpath, overview);

        cursor.close();
        db.close(); //Hier db.close of de sqlhandler.closeConnection? of beide?

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
            String language= cursor.getString(cursor.getColumnIndex("language"));
            String posterpath = cursor.getString(cursor.getColumnIndex("posterpath"));
            String overview = cursor.getString(cursor.getColumnIndex("overview"));


            String genre = cursor.getString(cursor.getColumnIndex("genre"));
            String[] genreParts = genre.split("-");

            ArrayList<String> genreList = new ArrayList<>();

            for (int i = 0; i < genreParts.length; i++){
                genreList.add(genreParts[i]);
            }

            int adultInt = Integer.parseInt(cursor.getString(cursor.getColumnIndex("adult")));
            boolean adult;

            if (adultInt == 1){
                adult = true;
            }
            else {
                adult = false;
            }

            Movies.add(new Movie(id, title, adult, genreList, language, posterpath, overview));
            cursor.moveToNext();
        }

        cursor.close();
        db.close(); //Hier db.close of de sqlhandler.closeConnection? of beide?
        return Movies;
    }

    @Override
    public boolean addMovie(Movie movie) {
        try {
            int adult = 0;

            if (movie.getAge()==true){
                adult = 1;
            }

            String genreString = "";

            for (int i = 0; i < movie.getGenre().size(); i++){
                genreString += movie.getGenre().get(i);
                genreString += "-";
            }

            ContentValues values = new ContentValues();
            values.put("id", movie.getId());
            values.put("title", movie.getTitle());
            values.put("adult", adult);
            values.put("genre", genreString);
            values.put("language", movie.getLanguage());
            values.put("posterpath", movie.getPosterpath());
            values.put("overview", movie.getOverview());

            SQLiteDatabase db = sqlHandler.getWritableDatabase();
            db.insert("Movie", null, values);
            db.close();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteMovie(int movieId) {
        try {
            String query = "DELETE FROM Movie WHERE id = '" + movieId + "'";

            SQLiteDatabase db = sqlHandler.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);

            db.close();

            return true;
        } catch (Exception e) {

            return false;
        }
    }
}
