package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MuseumPage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_page2);
        final ImageButton backINPage2 = findViewById(R.id.back_Mus2);
        final ImageButton bookingNow2 = findViewById(R.id.booking2);

        bookingNow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MuseumPage2.this, Ticket_Booking.class);
                startActivity(intent);
            }
        });
        backINPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MuseumPage2.this, MapsActivity.class);
                startActivity(intent);

            }
        });
    }
}