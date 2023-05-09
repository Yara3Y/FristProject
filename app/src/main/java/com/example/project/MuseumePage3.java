package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MuseumePage3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museume_page3);
        final ImageButton backINPage3 = findViewById(R.id.back_Mus3);
        final ImageButton bookingNow3 = findViewById(R.id.booking3);

        bookingNow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MuseumePage3.this, Ticket_Booking.class);
                startActivity(intent);
            }
        });
        backINPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MuseumePage3.this, MapsActivity.class);
                startActivity(intent);

            }
        });
    }
}