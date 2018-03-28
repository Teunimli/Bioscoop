package com.example.rickyberg.bioscopify.PresentationLayer;


import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.example.rickyberg.bioscopify.ApplicationLayer.MovieItemListener;
import com.example.rickyberg.bioscopify.DataAccessLayer.MovieAsyncTask;
import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener,MovieItemListener {

    private ArrayList<Movie> items = new ArrayList<>();
    private GridView gridView;
    private ArrayAdapter<Movie> adapter;
    View RootView;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        RootView = inflater.inflate(R.layout.fragment_home, container, false);
        getGridItems();
        gridView = (GridView) RootView.findViewById(R.id.movieListGrid2);
        adapter = new movieListAdapter(RootView.getContext(),items);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext().getApplicationContext(),DetailActivity.class);
                intent.putExtra("MOVIEITEM",items.get(i));
                intent.putExtra("POSITION",i);
                startActivity(intent);
            }
        });
        return RootView;
    }
    private void getGridItems()
    {
        //Aanroepen AsyncTask
        MovieAsyncTask task = new MovieAsyncTask(this);
        String[] urls = new String[] {"https://api.themoviedb.org/3/movie/now_playing?api_key=8089749884abc3ed32377451b7e348fd&language=nl-NL&page=1&region=NL"};
        task.execute(urls);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.action_bar_spinner_menu, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        spinner.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(RootView.getContext(),
                R.array.spinner_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onMoviesAvailable(Movie item) {
        items.add(item);
        adapter.notifyDataSetChanged();
    }
}
