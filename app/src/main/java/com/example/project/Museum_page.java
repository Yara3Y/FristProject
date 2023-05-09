package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Museum_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_page);
        final ImageButton backINPage=findViewById(R.id.back_Mus);
        final ImageButton bookingNow=findViewById(R.id.booking);

        bookingNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Museum_page.this,Ticket_Booking.class);
                startActivity(intent);
            }
        });
        backINPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Museum_page.this,MapsActivity.class);
                startActivity(intent);

            }
        });
    }
}