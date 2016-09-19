package com.example.android.miwok.AdapterAndModules;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miwok.R;

import java.util.ArrayList;

/**
 * Created by Kamran ALi on 8/1/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    private Context mContext;
    private ArrayList<Word> mArrayList;
    private int mColorID;

    public WordAdapter(Context context,ArrayList<Word> arrayList,int colorID) {
        super(context, 0, arrayList);
        this.mColorID = colorID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false
            );
        }
        Word currentWord = getItem(position);

        TextView engTextView = (TextView) listItemView.findViewById(R.id.default_textView);
        engTextView.setText(currentWord.getDefaultTranslation());
        TextView pashtoTextView = (TextView) listItemView.findViewById(R.id.translated_textView);
        pashtoTextView.setText(currentWord.getPashtoTranslation());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.img_View );
        if (currentWord.hasImage()){
            imageView.setImageResource(currentWord.getImageResourceID());
            imageView.setVisibility(View.VISIBLE);

        }else {
            imageView.setVisibility(View.GONE);
        }
        View container = listItemView.findViewById(R.id.textContainer);

        int color = ContextCompat.getColor(getContext(),mColorID);
        container.setBackgroundColor(color);
        return listItemView;
    }


}
