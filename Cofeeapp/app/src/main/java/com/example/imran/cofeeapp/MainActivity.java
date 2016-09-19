package com.example.imran.cofeeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText text1;
    Button increament, decreament, order;
    TextView list, addoreder;
    CheckBox cream, cofee;
    int counter;
    int secondcounter;
    boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        secondcounter = 0;
        increament = (Button) findViewById(R.id.increament);
        decreament = (Button) findViewById(R.id.Decrement);
        list = (TextView) findViewById(R.id.list);
        order = (Button) findViewById(R.id.Order);
        text1 = (EditText) findViewById(R.id.Edittext);
        cream = (CheckBox) findViewById(R.id.cream);
        cofee = (CheckBox) findViewById(R.id.cofee);
        addoreder = (TextView) findViewById(R.id.addorder);
        calculateprise(check, check);
        increament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 100) {
                    Toast.makeText(MainActivity.this, "You can not select cofees over 100", Toast.LENGTH_SHORT).show();
                    return;
                }
                counter = counter + 1;
                addoreder.setText("your order is : " + counter + " Items");


            }
        });
        decreament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 1) {
                    Toast.makeText(MainActivity.this, "You Must be select atleast One Cofee! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                counter = counter - 1;
                addoreder.setText("your order is : " + counter + " Items");
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gettext = null;
                if (cream.isChecked()) {
                    secondcounter = secondcounter + 20;
                     gettext = text1.getText().toString();

                    list.setText("client name : " + gettext + "\nWhipped Cream : " + cream.isChecked() + "\nChocolate : " + cofee.isChecked() + "\n" + "Quantity :" + counter + "\n" + "Total price : " + secondcounter * counter + "\n" + "Thank You!");

                }

                if (cofee.isChecked()) {
                    secondcounter = secondcounter + 10;
                     gettext = text1.getText().toString();

                    list.setText("client name : " + gettext + "\nWhipped Cream : " + cream.isChecked() + "\nChocolate : " + cofee.isChecked() + "\n" + "Quantity :" + counter + "\n" + "order price : " + secondcounter * counter + "\n" + "Thank You!");

                }
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT,"client name : " + gettext + "\nWhipped Cream : " + cream.isChecked() + "\nChocolate : " + cofee.isChecked() + "\n" + "Quantity :" + counter + "\n" + "order price : " + secondcounter * counter + "\n" + "Thank You!" );
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }


        });
    }

    private int calculateprise(boolean addwhipecream, boolean addchocolate) {
        int baseprise = 0;
        if (addwhipecream) {
            baseprise = baseprise + 20;
        }
        if (addchocolate) {
            baseprise = baseprise + 10;
        }
        return counter * baseprise;
    }

}


