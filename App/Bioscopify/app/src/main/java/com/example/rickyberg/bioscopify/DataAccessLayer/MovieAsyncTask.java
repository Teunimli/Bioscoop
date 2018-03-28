package com.example.rickyberg.bioscopify.DataAccessLayer;

import android.os.AsyncTask;
import android.util.Log;

import com.example.rickyberg.bioscopify.ApplicationLayer.JSONMovieParser;
import com.example.rickyberg.bioscopify.ApplicationLayer.MovieItemListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Ricky on 28/03/2018.
 */

public class MovieAsyncTask extends AsyncTask<String,Void, String> {

    private static final String TAG = "MovieAsyncTask";
    private MovieItemListener listener;

    public MovieAsyncTask(MovieItemListener listener) {
        Log.i(TAG, "== Task created ==");
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {

        Log.i(TAG, "== Starting task in background ==");
        BufferedReader bufferedReader = null;
        String response = "";

        try {
            URL url = new URL(params[0]);
            Log.i(TAG, "== Fetching content from URL ==");
            URLConnection connection = url.openConnection();

            bufferedReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            response = bufferedReader.readLine().toString();
            String line;
            while( (line = bufferedReader.readLine()) != null) {
                response += line;
            }


        } catch (Exception e) {
            return null;
        } finally {
            if( bufferedReader != null ) {
                try {
                    bufferedReader.close();
                    Log.i(TAG, "== DATA retreived ==");
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return response;
    }

    protected void onPostExecute(String response) {
        JSONMovieParser.getMovies(response, listener);
    }
}
