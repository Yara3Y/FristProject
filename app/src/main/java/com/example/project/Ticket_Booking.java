package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Ticket_Booking extends AppCompatActivity {

    EditText t1;
    EditText t2;
    EditText t3;
    EditText t4;
    EditText t5;
    EditText t6;
    EditText t7;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://project1-c7378-default-rtdb.firebaseio.com/");
    public static final String UserNameP = "name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_booking);

        //actionbar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Enter ticket information ");

        //EditText
        final EditText mNameEt = findViewById(R.id.nameEt);
        final EditText mEmailEt = findViewById(R.id.emailEt);
        final EditText mPhoneEt = findViewById(R.id.phoneEt);
        final EditText mPeople = findViewById(R.id.peopleEt);

        final EditText mDate = findViewById(R.id.date);
        final EditText mTime = findViewById(R.id.time);

        //Button

        Spinner museum=findViewById(R.id.Select);

        Intent intent = getIntent();
        String User_NameText = intent.getStringExtra(UserNameP);
        Button mSaveBtn = findViewById(R.id.saveButton);
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = mNameEt.getText().toString();
                final String email = mEmailEt.getText().toString();
                final String phone = mPhoneEt.getText().toString();
                final String People = mPeople.getText().toString();
                final String Museum = museum.getSelectedItem().toString();
                final String Date = mDate.getText().toString();
                final String Time = mTime.getText().toString();


//                databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        //sending data to database
//                        //all the details are under the username and username is unique
//                        databaseReference.child("users").child(User_NameText).child("NumberOF_people").setValue(People);
//                        databaseReference.child("users").child(User_NameText).child("Museum").setValue(Museum);
//                        databaseReference.child("users").child(User_NameText).child("date").setValue(Date);
//                        databaseReference.child("users").child(User_NameText).child("time").setValue(Time);
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//
//                });

                //activity intent
                Intent intent2 = new Intent(Ticket_Booking.this, DisplayTicket.class);

                intent2.putExtra("NAME", name);
                intent2.putExtra("PHONE", phone);
                intent2.putExtra("number of people", People);
                intent2.putExtra("Museum", Museum);
                intent2.putExtra("Date", Date);
                intent2.putExtra("Time", Time);

                startActivity(intent2);


            }
        });
        t1 = findViewById(R.id.nameEt);
        t2 = findViewById(R.id.emailEt);
        t3 = findViewById(R.id.phoneEt);
        t4 = findViewById(R.id.peopleEt);
        t6 = findViewById(R.id.date);
        t7 = findViewById(R.id.time);

        Button clear1 = findViewById(R.id.clear);
        clear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.getText().clear();
                t2.getText().clear();
                t3.getText().clear();
                t4.getText().clear();
                t5.getText().clear();
                t6.getText().clear();
                t7.getText().clear();
            }
        });

        Button cancel1 = (Button) findViewById(R.id.cancel1);
        cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Ticket_Booking.this, MapsActivity.class);
                startActivity(intent3);
            }
        });

    }
}