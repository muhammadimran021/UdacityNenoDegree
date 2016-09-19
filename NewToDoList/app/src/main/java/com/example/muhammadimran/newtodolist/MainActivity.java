package com.example.muhammadimran.newtodolist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private String texttitle, textMessage;
    private int position;
    Message message;
    Database database = new Database(this);
    List<Message> msg = new ArrayList<Message>();
    MessageAdapter adapter = new MessageAdapter(msg, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retriveList();
        addItems();



    }

    private void addItems() {
        Button addbutton = (Button) findViewById(R.id.addbutton);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(false);
                View view1 = getLayoutInflater().inflate(R.layout.dialogbox, null);

                final EditText titletext = (EditText) view1.findViewById(R.id.addtitle);
                final EditText messagetext = (EditText) view1.findViewById(R.id.addmessage);
                final CheckBox readbox = (CheckBox) view1.findViewById(R.id.checkbox);

                builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      //  try {
                            texttitle = titletext.getText().toString();
                            textMessage = messagetext.getText().toString();
                            boolean read1 = readbox.isChecked();
                            Message msg1 = new Message(0,texttitle,textMessage,read1);
                            msg.add(msg1);
                            database.savevalues(msg1);
                            adapter.notifyDataSetChanged();
//                        } catch (Exception e) {
//                            Toast.makeText(getApplicationContext(), "sorry item can not be Added ! ", Toast.LENGTH_SHORT).show();
//                        }
                    }
                });
                builder.setNegativeButton("cancel", null);


                builder.setView(view1);
                builder.create().show();
            }
        });
    }


    public void retriveList() {
        ListView listView = (ListView) findViewById(R.id.list_View);

        
        msg = database.getPoints();

        adapter = new MessageAdapter(msg, this);
        listView.setAdapter(adapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you want to delete item from you'r List ?");
                builder.setCancelable(false);
                position = i;

                builder.setPositiveButton("Yes ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int pos) {

                        try {
                            int id = msg.get(position).getId();

                            msg.remove(position);
                            database.delete(id);
                            adapter.notifyDataSetChanged();
                            Toast.makeText(getApplicationContext(),"Item deleted ! Seccessfully  " , Toast.LENGTH_SHORT).show();

                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "sorry item can not be deleted ! ", Toast.LENGTH_SHORT).show();
                        }
                        ;


                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                builder.create().show();
                return true;

            }
        });

    }


}
