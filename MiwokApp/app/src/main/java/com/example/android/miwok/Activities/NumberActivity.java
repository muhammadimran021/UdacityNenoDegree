package com.example.android.miwok.Activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.miwok.R;
import com.example.android.miwok.AdapterAndModules.Word;
import com.example.android.miwok.AdapterAndModules.WordAdapter;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {
    private Word words;

    private WordAdapter mWordAdapter;
    private ListView mListView;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        mListView = (ListView) findViewById(R.id.rootView);

        final ArrayList<Word> mWordArrayList = new ArrayList<>();
        mWordArrayList.add(new Word("One", "Yao", R.drawable.number_one,R.raw.number_one));
        mWordArrayList.add(new Word("Two", "Dua", R.drawable.number_two,R.raw.number_two));
        mWordArrayList.add(new Word("Three", "Dray", R.drawable.number_three,R.raw.number_three));
        mWordArrayList.add(new Word("Four", "Saloor", R.drawable.number_four,R.raw.number_four));
        mWordArrayList.add(new Word("Five", "Pinza", R.drawable.number_five,R.raw.number_five));
        mWordArrayList.add(new Word("Six", "Ishpag", R.drawable.number_six,R.raw.number_six));
        mWordArrayList.add(new Word("Seven", "Woah", R.drawable.number_seven,R.raw.number_seven));
        mWordArrayList.add(new Word("Eight", "Atta", R.drawable.number_eight,R.raw.number_eight));
        mWordArrayList.add(new Word("Nine", "Naha", R.drawable.number_nine,R.raw.number_nine));
        mWordArrayList.add(new Word("Ten", "Las", R.drawable.number_ten,R.raw.number_ten));

        mWordAdapter = new WordAdapter(this, mWordArrayList, R.color.category_numbers);
        mListView.setAdapter(mWordAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = mWordArrayList.get(position);
                String s = word.getDefaultTranslation().toString();

                Toast.makeText(NumberActivity.this, "YOu CLick "+s, Toast.LENGTH_SHORT).show();

                mMediaPlayer = MediaPlayer.create(NumberActivity.this, word.getAudioResourceID() );
                mMediaPlayer.start();
            }
        });


    }
}
