package com.example.android.miwok.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.AdapterAndModules.Word;
import com.example.android.miwok.AdapterAndModules.WordAdapter;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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

        mWordArrayList.add(new Word("Grand-Father","Nikah",R.drawable.family_grandfather));
        mWordArrayList.add(new Word("Grand-Mother","Niyah",R.drawable.family_grandmother));
        mWordArrayList.add(new Word("Father","Plar",R.drawable.family_father));
        mWordArrayList.add(new Word("Mother","Mor",R.drawable.family_mother));
        mWordArrayList.add(new Word("Son","Zoi",R.drawable.family_son));
        mWordArrayList.add(new Word("Daughter","Lor",R.drawable.family_daughter));
        mWordArrayList.add(new Word("Brother","Ror",R.drawable.family_son));
        mWordArrayList.add(new Word("Sister","Khor",R.drawable.family_older_sister));
        mWordArrayList.add(new Word("Older Brother","Mashar-Ror",R.drawable.family_older_brother));
        mWordArrayList.add(new Word("Younger Brother","Kashar-Ror",R.drawable.family_younger_brother));
        mWordArrayList.add(new Word("Younger Sister","Kashara-Khor",R.drawable.family_younger_sister));

        mWordAdapter = new WordAdapter(this,mWordArrayList,R.color.category_family);
        mListView.setAdapter(mWordAdapter);






    }
}
