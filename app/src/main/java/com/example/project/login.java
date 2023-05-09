package com.example.project;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class login extends AppCompatActivity {
    private EditText userName, userEmail;
    private Button btnSend;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://project1-c7378-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         final EditText Username_1=findViewById(R.id.Username_1);
         final EditText password_1=findViewById(R.id.password_1);

         final ImageButton next=findViewById(R.id.next);
        final Button forgot=findViewById(R.id.forgot_IN_page);

        final Button create_IN_page=findViewById(R.id.create_IN_page);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final String userNameText=Username_1.getText().toString();
            final String passwordText=password_1.getText().toString();

            if(userNameText.isEmpty()||passwordText.isEmpty()){
                Toast.makeText(login.this,"Please enter your userName OR password",Toast.LENGTH_SHORT).show();
            }
            else{
                databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //check if username is exist OR not in database
                        if(snapshot.hasChild(userNameText)){

                            //now get password of user from database and match it with user enter
                            final String getpassword=snapshot.child(userNameText)
                                    .child("password").getValue(String.class);
                            if(getpassword.equals(passwordText)){
                                Toast.makeText(login.this,"Successfully logged in ",Toast.LENGTH_SHORT).show();;

                                //page after login
                                Intent intent=new Intent(login.this,MapsActivity.class);
                                intent.putExtra(Ticket_Booking.UserNameP,userNameText);
                                startActivity(intent);


                            }
                            else{
                                Toast.makeText(login.this,"Password is NOT correct ",Toast.LENGTH_SHORT).show();;
                            }
                        }
                        else{
                            Toast.makeText(login.this,"Username is NOT Found ",Toast.LENGTH_SHORT).show();;
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
            }
        });
        create_IN_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,MainActivity.class);
                 startActivity(intent);

            }
        });
    }
}