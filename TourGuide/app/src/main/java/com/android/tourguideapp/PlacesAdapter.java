package com.android.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kamran ALi on 8/2/2016.
 */
public class PlacesAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<Description> mArrayList;
    private Context mContext;

    public PlacesAdapter(ArrayList<Description> arrayList, Context context) {
        mArrayList = arrayList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.adapter_layout, null);
        TextView placeNameView = (TextView) view.findViewById(R.id.name_view);
        TextView descriptionView = (TextView) view.findViewById(R.id.description_view);
        TextView locationView = (TextView) view.findViewById(R.id.location_view);
        ImageView imgView = (ImageView) view.findViewById(R.id.imageView_adapter);

        Description description = mArrayList.get(position);
        placeNameView.setText(description.getPlaceName().toString());
        descriptionView.setText(description.getDescription().toString());
        locationView.setText(description.getLocaton().toString());
        imgView.setImageResource(description.getImageResourceID());

        return view;

    }
}
