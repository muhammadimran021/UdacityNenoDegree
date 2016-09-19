package com.android.tourguideapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoricalActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayList<Description> mArrayList;
    private PlacesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);
        mListView = (ListView) findViewById(R.id.rootListView);
        mArrayList = new ArrayList<>();
        mArrayList.add(new Description("Mohatta Palace", "Hindu Gymkhana,Nataional Treasure", "Karachi,Sind,Pakistan", R.drawable.mohatta_palace));
        mArrayList.add(new Description("Pakistan Maritime Museum", "Naval museum", "Karachi,Sind,Pakistan", R.drawable.maritime_museum));
        mArrayList.add(new Description("National Museum of Pakistan", "Victoria Museum, Frere Hall, Sir Bartle Frere", "Dr. Ziauddin Ahmed Road, Karachi, Pakistan", R.drawable.national_museum_of_pakistan));
        mArrayList.add(new Description("Wazir Mansion", "Museum, Jinnah House", "Karachi,Sind,Paistan", R.drawable.wazir_mansion));
        mArrayList.add(new Description("Chaukhandi tombs", "Tombs,", "Saddar, Karachi,Sind Pakistan", R.drawable.chaukhandi_tombs));


        adapter = new PlacesAdapter(mArrayList, this);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Description description = mArrayList.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(HistoricalActivity.this);
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
