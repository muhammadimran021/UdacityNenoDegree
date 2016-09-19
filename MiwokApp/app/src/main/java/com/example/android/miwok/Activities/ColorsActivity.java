package com.example.android.miwok.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.AdapterAndModules.Word;
import com.example.android.miwok.AdapterAndModules.WordAdapter;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private Word words;
    private ArrayList<Word> mWordArrayList ;
    private WordAdapter mWordAdapter;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        mListView = (ListView) findViewById(R.id.rootView);

        mWordArrayList = new ArrayList<>();
        mWordArrayList.add(new Word("White","Spin",R.drawable.color_white));
        mWordArrayList.add(new Word("Black","Tor",R.drawable.color_black));
        mWordArrayList.add(new Word("Red","Sur",R.drawable.color_red));
        mWordArrayList.add(new Word("Green","Shina",R.drawable.color_green));
        mWordArrayList.add(new Word("Yellow","Zairh",R.drawable.color_mustard_yellow));
        mWordArrayList.add(new Word("Dusty Yellow","Doroh Zairh",R.drawable.color_dusty_yellow));
        mWordArrayList.add(new Word("Brown","Naswari",R.drawable.color_brown));

        mWordAdapter = new WordAdapter(this,mWordArrayList,R.color.category_colors);
        mListView.setAdapter(mWordAdapter);






    }
}
