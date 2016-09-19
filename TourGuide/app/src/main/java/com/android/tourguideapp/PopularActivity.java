package com.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class PopularActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayList<Description> mArrayList;
    private PlacesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);
        mListView = (ListView) findViewById(R.id.rootListView);
        mArrayList = new ArrayList<>();
        mArrayList.add(new Description("Quaid-Azam Tomb", "National Mausoleum,Jinnah Mausoleum", "Karachi,Sindh Pakistan", R.drawable.mazar_quaid));
        mArrayList.add(new Description("Pakistan Maritime Museum", "Naval museum", "Karachi,Sindh Pakistan", R.drawable.maritime_museum));
        mArrayList.add(new Description("National Museum of Pakistan", "Victoria Museum, Frere Hall, Sir Bartle Frere", "Dr. Ziauddin Ahmed Road, Karachi, Pakistan", R.drawable.national_museum_of_pakistan));
        mArrayList.add(new Description("Port-Grand", "Entertainment Complex,", "Karachi,Sindh Paistan", R.drawable.port_grand));
        mArrayList.add(new Description("Empress Market", "Market", "Saddar, Karachi,Sindh Pakistan", R.drawable.empress_market));


        adapter = new PlacesAdapter(mArrayList, this);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Description description = mArrayList.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(PopularActivity.this);
                builder.setTitle(description.getPlaceName());
                builder.setMessage(description.getDescription());
                View view1 = getLayoutInflater().inflate(R.layout.alert_builder_layout, null);
                ImageView imgView = (ImageView) view1.findViewById(R.id.alertbuilder_imageView);
                imgView.setImageResource(description.getImageResourceID());
                builder.setView(view1);

                builder.create().show();
            }
        });
    }
}
