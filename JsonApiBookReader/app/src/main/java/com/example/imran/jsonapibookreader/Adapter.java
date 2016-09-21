package com.example.imran.jsonapibookreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by imran on 9/20/2016.
 */
public class Adapter extends ArrayAdapter<Modules> {

    private Picasso picasso;

    public Adapter(Context context, ArrayList<Modules> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.inflate_view, parent, false);
        }

        Modules modules = getItem(position);

        TextView title = (TextView) view.findViewById(R.id.titleview);
        TextView auther = (TextView) view.findViewById(R.id.auther);
        TextView date = (TextView) view.findViewById(R.id.date);
        ImageView image = (ImageView) view.findViewById(R.id.imageUri);

        title.setText(modules.getTitle());
        auther.setText(modules.getAuther());
        date.setText(modules.getDate());
        picasso.with(getContext()).load(modules.getImsge()).into(image);


        return view;
    }
}
