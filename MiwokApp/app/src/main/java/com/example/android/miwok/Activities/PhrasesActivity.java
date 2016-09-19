package com.example.android.miwok.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.AdapterAndModules.Word;
import com.example.android.miwok.AdapterAndModules.WordAdapter;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

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
        mWordArrayList.add(new Word("Where are you going?","Charta Ze ?"));
        mWordArrayList.add(new Word("What is your name?","Ista nom sada ?"));
        mWordArrayList.add(new Word("My name is ...","Zama nom  ...  da."));
        mWordArrayList.add(new Word("How are you feeling?","Sanga mehsos kaye ?"));
        mWordArrayList.add(new Word("I'm Good.","Za kha yam."));
        mWordArrayList.add(new Word("Are You Coming?","Tu Razey?"));
        mWordArrayList.add(new Word("Yes, I'm Coming.","Ao, Za razama."));
        mWordArrayList.add(new Word("I'm Coming.","Za Razam."));
        mWordArrayList.add(new Word("Let's go.","Raza Zo."));
        mWordArrayList.add(new Word("Come here.","Dalta Rasha."));

        mWordAdapter = new WordAdapter(this,mWordArrayList,R.color.category_phrases);
        mListView.setAdapter(mWordAdapter);






    }
}
