package com.example.imran.databaseproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by imran on 8/29/2016.
 */
public class Adapters extends BaseAdapter implements ListAdapter {
    List<MyStucture> arrayStructure;
    Context con;

    public Adapters(List<MyStucture> arrayStructure, Context con) {
        this.arrayStructure = arrayStructure;
        this.con = con;
    }

    @Override
    public int getCount() {
        return arrayStructure.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayStructure.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arrayStructure.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.checkboxes,null);

        TextView title = (TextView) view.findViewById(R.id.textView);
        title.setText(arrayStructure.get(position).getTitle());

        CheckBox checksun = (CheckBox) view.findViewById(R.id.sunday);
        TextView days = (TextView) view.findViewById(R.id.days);


        String set = arrayStructure.get(position).getDescription();
        if (set.equals("Sunday")) {
            checksun.setChecked(true);
            days.setText("Sunday");
        } else if (set.equals("Monday")) {
            checksun.setChecked(true);
            days.setText("Monday");
        } else if (set.equals("Tuseday")) {
            checksun.setChecked(true);
            days.setText("Tuesday");
        } else if (set.equals("Wednesday")) {
            checksun.setChecked(true);
            days.setText("Wednesday");
        } else if (set.equals("Thursday")) {
            checksun.setChecked(true);
            days.setText("Thursday");
        } else if (set.equals("Friday")) {
            checksun.setChecked(true);
            days.setText("Friday");
        } else if (set.equals("Saturday")) {
            checksun.setChecked(true);
            days.setText("Saturday");
        }

        return view;
    }

}
