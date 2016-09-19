package com.example.imran.databaseproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MyStucture> arrayList = new ArrayList<>();
    private Database database = new Database(this);
    private Adapters adapters;
    private MyStucture stucture;
    private ArrayList<String> arrayData;
    private ArrayAdapter<String> adapterFordays;
    private ListView listView;
    private Spinner spinner;
    private EditText title_text;

    private Button add_Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayData = new ArrayList<String>();
        adapterFordays = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayData);
        adapterFordays.add("Sunday");
        adapterFordays.add("Monday");
        adapterFordays.add("Tuseday");
        adapterFordays.add("Wednesday");
        adapterFordays.add("Thursday");
        adapterFordays.add("Friday");
        adapterFordays.add("Saturday");
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(adapterFordays);

        RetriveData();
        AddItems();

    }

    private void AddItems() {
        add_Data = (Button) findViewById(R.id.addButton);
        add_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                title_text = (EditText) findViewById(R.id.Titlename);

                String data_title = title_text.getText().toString();
                stucture = new MyStucture(data_title, spinner.getSelectedItem().toString(), 0);
                Log.d("TAG", "Title " + data_title + " description" + spinner.getSelectedItem().toString());
                arrayList.add(stucture);
                database.saveData(stucture);
                database.getdata();
                adapters.notifyDataSetChanged();
                title_text.setText("");
            }
        });
    }

    private void RetriveData() {
        listView = (ListView) findViewById(R.id.listview);
        arrayList = database.getdata();


        adapters = new Adapters(arrayList, this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Update or Delete Data !!!");
                builder.setTitle("Update Or Delete Items...");
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int id = arrayList.get(position).getId();
                        arrayList.remove(position);
                        database.Delete_Item(id);
                        adapters.notifyDataSetChanged();
                    }
                });
                builder.setPositiveButton("Update ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                        View view1 = inflater.inflate(R.layout.alertview2, null);
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                        builder1.setTitle("Do You want to update data?");
                        builder1.setMessage("Update data...");
                        final EditText title = (EditText) findViewById(R.id.Titlename);

                        final Spinner spinner1 = (Spinner) view1.findViewById(R.id.spinner);
                        spinner1.setAdapter(adapterFordays);

                        builder1.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                String spinnerText = spinner1.getSelectedItem().toString();

                                int id = arrayList.get(position).getId();
                                stucture = new MyStucture(arrayList.get(position).getTitle(), spinnerText, 0);
                                Log.d("TAG", "Values PAss : " + id + " " + spinnerText);
                                arrayList.set(position, stucture);
                                database.Update_Items(id, spinnerText);
                                adapters.notifyDataSetChanged();
                            }
                        });
                        builder1.setNegativeButton("cancel", null);
                        builder1.setView(view1);
                        builder1.show();
                    }
                });

                builder.show();
            }
        });
        listView.setAdapter(adapters);

    }


}
