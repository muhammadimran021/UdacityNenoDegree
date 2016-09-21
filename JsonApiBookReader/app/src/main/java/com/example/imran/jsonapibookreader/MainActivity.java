package com.example.imran.jsonapibookreader;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Modules> ArrayList;
    private ListView listVie;
    private Button button;
    static final String API_URL = "https://www.googleapis.com/books/v1/volumes?q=";
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listVie = (ListView) findViewById(R.id.listview);
        textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.VISIBLE);
        imageView = (ImageView) findViewById(R.id.imageUri);

        ArrayList = new ArrayList<Modules>();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.alert_layout, null);
                final EditText editText = (EditText) view.findViewById(R.id.editText);


                builder.setTitle("Search Book Name");
                builder.setPositiveButton("Search Book", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String KeySearch = editText.getText().toString();
                        if (KeySearch.equals("")) {
                            textView.setText("Plz enter A Book Name !");
                            textView.setVisibility(View.VISIBLE);
                            listVie.setVisibility(View.GONE);
                        } else {
                            imageView.setVisibility(View.GONE);
                            new FetchList().execute(API_URL + KeySearch);
                        }
                    }
                });
                builder.setView(view);
                builder.create().show();
            }
        });

    }

    public void RetriveBooksData() {

    }

public class FetchList extends AsyncTask<String, Void, String> {
    MainActivity mainActivity = null;
    ArrayList<Modules> modulesArrayList = new ArrayList<>();


    @Override
    protected String doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            if (urlConnection.getResponseCode() == 200) {
                InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder builder = new StringBuilder();

                String Line;
                while ((Line = bufferedReader.readLine()) != null) {
                    builder.append(Line);
                }

                JSONObject StarJsonObject = new JSONObject(builder.toString());
                JSONArray ItemsBooks = StarJsonObject.getJSONArray("items");

                for (int i = 0; i < ItemsBooks.length(); i++) {
                    JSONObject book = ItemsBooks.getJSONObject(i);
                    JSONObject volumeInfo = book.getJSONObject("volumeInfo");
//book title
                    String title = volumeInfo.getString("title");

                    //auther

                    JSONArray author = volumeInfo.getJSONArray("authors");
                    String[] authers = new String[author.length()];
                    for (int j = 0; j < author.length(); j++) {
                        authers[j] = author.getString(j);
                    }

                    //get date


                    int date = volumeInfo.getInt("publishedDate");

                    JSONObject imageget = volumeInfo.getJSONObject("imageLinks");
                    String imagelink = imageget.getString("smallThumbnail");

                    modulesArrayList.add(new Modules(title, authers, imagelink, date));

                    urlConnection.disconnect();

                }
            } else {
                urlConnection.disconnect();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (modulesArrayList.size() == 0) {
                    textView.setVisibility(View.VISIBLE);
                } else {

                    textView.setVisibility(View.GONE);
                    listVie.setVisibility(View.VISIBLE);
                }
                listVie.setAdapter(new Adapter(MainActivity.this, modulesArrayList));
                MainActivity.this.ArrayList = modulesArrayList;
            }
        });

    }

}

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(MainActivity.this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);




    }
}
