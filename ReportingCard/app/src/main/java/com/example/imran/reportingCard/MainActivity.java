package com.example.faiz.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.faiz.reportcard.Adapter.ListAdapterr;
import com.example.faiz.reportcard.Models.Report;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Report> arrayList = new ArrayList<>();
        arrayList.add(new Report("Muhammad Imran",R.drawable.faiz,"A+",1,"Present"));
        arrayList.add(new Report("Kamran",R.drawable.kami,"B",2,"Present"));
        arrayList.add(new Report("Samad Muslim",R.drawable.faiz,"C",7,"Absent"));
        arrayList.add(new Report("Moosa",R.drawable.moosa,"B+",4,"Absent"));
        arrayList.add(new Report("Sami Khan",R.drawable.sami,"C+",5,"Absent"));
        arrayList.add(new Report("Fawad Khalil",R.drawable.fawad,"A",3,"Present"));
        arrayList.add(new Report("Babar Mustafa",R.drawable.adnan,"D",6,"Present"));
        arrayList.add(new Report("Kashan Zafar",R.drawable.faiz,"A+",9,"Present"));
        arrayList.add(new Report("ALi",R.drawable.faiz,"A",8,"Present"));


        ListView listView = (ListView)findViewById(R.id.list);
        ListAdapterr adapter = new ListAdapterr(MainActivity.this,arrayList);
        listView.setAdapter(adapter);
    }
}
