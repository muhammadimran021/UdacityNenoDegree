package com.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class BeachActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayList<Description> mArrayList;
    private PlacesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);
        mListView = (ListView) findViewById(R.id.rootListView);
        mArrayList = new ArrayList<>();
        mArrayList.add(new Description("Clifton Beach", "BeachViewPark,Arabian Sea,Sea View", "Karachi,Sindh Pakistan", R.drawable.clifton_beach));
        mArrayList.add(new Description("SandSpit Beach", "Sea View, Beach", "Karachi,Sindh Pakistan", R.drawable.sandspit_beach));
        mArrayList.add(new Description("Paradise Point", "Sea Viewm, Beach", "Karachi,Sindh Pakistan", R.drawable.paradisepoint_beach));
        mArrayList.add(new Description("French Beach", "Sea View, Beach", "Karachi,Sindh Paistan", R.drawable.french_beach));
        mArrayList.add(new Description("Neelam Point", "Sea View, Beach", " Karachi,Sindh Pakistan", R.drawable.neelamponit_beach));


        adapter = new PlacesAdapter(mArrayList, this);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Description description = mArrayList.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(BeachActivity.this);
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
