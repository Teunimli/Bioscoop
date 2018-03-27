package com.example.rickyberg.bioscopify.PresentationLayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.rickyberg.bioscopify.DomainLayer.Movie;
import com.example.rickyberg.bioscopify.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Michael on 27/03/2018.
 */

public class movieListAdapter extends ArrayAdapter<Movie> {
    public movieListAdapter(@NonNull Context context, ArrayList<Movie> items) {
        super(context, 0,items);
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Movie item = getItem(position);
        if( convertView == null ) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.gridview_view_item,
                    parent,
                    false
            );
        }
        ImageView poster = (ImageView) convertView.findViewById(R.id.imgView);
        Picasso.with(getContext()).load(item.getPosterpath()).into(poster);
        return convertView;
    }
}
