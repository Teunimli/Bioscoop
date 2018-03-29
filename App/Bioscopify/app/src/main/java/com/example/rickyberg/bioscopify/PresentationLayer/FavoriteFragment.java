package com.example.rickyberg.bioscopify.PresentationLayer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.rickyberg.bioscopify.DataAccessLayer.MovieRepositoryInterface;
import com.example.rickyberg.bioscopify.DataAccessLayer.MovieRepositorySQL;
import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    private ArrayList<Movie> items = new ArrayList<>();
    private GridView gridView;
    private ArrayAdapter<Movie> adapter;
    View RootView;
    MovieRepositoryInterface movieRepository;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RootView = inflater.inflate(R.layout.fragment_favorite, container, false);
        setHasOptionsMenu(true);
        movieRepository = new MovieRepositorySQL(RootView.getContext());
        getGridItems();
        gridView = (GridView) RootView.findViewById(R.id.movieListFavorite);
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
        items = movieRepository.getAll();
    }

}
