package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
public class DisplayTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_ticket);


        //actionbar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Your ticket");
        //intent to get data
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String phone = intent.getStringExtra("PHONE");
        String people1 = intent.getStringExtra("number of people");
        String museum1 = intent.getStringExtra("Museum");
        String Date1 = intent.getStringExtra("Date");
        String Time1 = intent.getStringExtra("Time");


        //TextView
        TextView mResultTv = findViewById(R.id.resultTv);
        //setText
        displayTicKet(name, phone, people1, museum1, Date1, Time1, mResultTv);

        Button cancel2=(Button)findViewById(R.id.cancel2);

              cancel2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                Intent intent2=new Intent(DisplayTicket.this,Ticket_Booking.class);
                startActivity(intent2);
            }
        });

         Button confirm=(Button)findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(DisplayTicket.this,
                        "Your Booking has been confirmed",Toast.LENGTH_SHORT).show();;
            }
        });

    }

    private void displayTicKet(String name, String phone, String people1, String museum1, String Date1, String Time1, TextView mResultTv) {
        mResultTv.setText("Name: "+ name + "\n\nPhone: "+ phone + "\n\nnumber of people: "
                + people1 +"\n\nMuseum: "+ museum1 +"\n\nDate: "+ Date1 +"\n\nTime: "+ Time1 +"\n");
    }
}