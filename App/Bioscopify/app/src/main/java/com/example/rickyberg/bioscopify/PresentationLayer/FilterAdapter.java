package com.example.rickyberg.bioscopify.PresentationLayer;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.rickyberg.bioscopify.DomainLayer.Genre;
import com.example.rickyberg.bioscopify.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ricky on 30/03/2018.
 */

public class FilterAdapter extends BaseAdapter {

    Activity activity;
    List<Genre> genres;
    LayoutInflater inflater;

    //short to create constructer using command+n for mac & Alt+Insert for window


    public FilterAdapter(Activity activity) {
        this.activity = activity;
    }

    public FilterAdapter(Activity activity, List<Genre> genres) {
        this.activity = activity;
        this.genres = genres;
        inflater = activity.getLayoutInflater();
    }


    @Override
    public int getCount() {
        if(genres == null)
            return 0;
        return genres.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if (view == null){

            view = inflater.inflate(R.layout.listview_genre, viewGroup, false);

            holder = new ViewHolder();

            holder.tvUserName = (TextView)view.findViewById(R.id.tvCheckbock);
            holder.ivCheckBox = (ImageView) view.findViewById(R.id.ivCheck);

            view.setTag(holder);
        }else
            holder = (ViewHolder)view.getTag();

        Genre genre = genres.get(i);

        holder.tvUserName.setText(genre.getGenre());

        if (genre.isSelected())
            holder.ivCheckBox.setBackgroundResource(R.drawable.checked);

        else
            holder.ivCheckBox.setBackgroundResource(R.drawable.check);

        return view;

    }

    public void updateRecords(List<Genre> genres){
        this.genres = genres;

        notifyDataSetChanged();
    }

    class ViewHolder{

        TextView tvUserName;
        ImageView ivCheckBox;

    }
}

// extends ArrayAdapter<String>{
//
//    private String genre;
//    RadioButton btn;
//
//    public FilterAdapter(Context context, ArrayList<String> items)
//    {
//        super(context, 0, items);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent)
//    {
//        genre = getItem(position);
//        if (convertView == null)
//        {
//            convertView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.listview_genre,
//                    parent,
//                    false
//            );
//        }
//        btn = (RadioButton) convertView.findViewById(R.id.rbAdapter);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (btn.isChecked())
//                {
//                    SelectedGenres.getInstance().removeGenre(genre);
//                    btn.setChecked(false);
//                    Log.i("=====", "Just unchecked " + btn.getText());
//                }
//                else
//                {
//                    Log.i("======", "AFTER " + btn.toString());
//                    SelectedGenres.getInstance().addGenre(genre);
//                    Log.i("=====", "Just checked");
//                }
//            }
//        });
//        btn.setText(genre);
//        return convertView;
//    }
//}
