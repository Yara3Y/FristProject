package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //create object of database
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReferenceFromUrl("https://project1-c7378-default-rtdb.firebaseio.com/");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText full_name=findViewById(R.id.name_full);
        final EditText Username=findViewById(R.id.Username);
        final EditText password=findViewById(R.id.password);
        final EditText password_con=findViewById(R.id.passwordMatch);
        final EditText email=findViewById(R.id.email);
        final EditText phone=findViewById(R.id.phone);

        final ImageButton create_account=findViewById(R.id.create_account);
        final ImageButton back_page=findViewById(R.id.back);

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get data from EditText into string
                final String full_nameText =full_name.getText().toString();
                final String username_Text  =Username.getText().toString();
                final String  password_text =password.getText().toString();
                final String  passwordMatch_text =password_con.getText().toString();
                final String email_text  =email.getText().toString();
                final String  phone_text =phone.getText().toString();

                //check if user fill the fields before sending data
                if(full_nameText.isEmpty()||username_Text.isEmpty()||
                        password_text.isEmpty()||email_text.isEmpty()||phone_text.isEmpty()||passwordMatch_text.isEmpty()){
                    Toast.makeText(MainActivity.this,
                            "WARNING,you have Missing information",Toast.LENGTH_SHORT).show();;
                }
                //matching password each other
                else if(!password_text.equals(passwordMatch_text)){
                    Toast.makeText(MainActivity.this,
                            "WARNING,The Password aren't Matching",Toast.LENGTH_SHORT).show();;

                }

                else {

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if the username register before or net
                            if(snapshot.hasChild(username_Text)){
                                Toast.makeText(MainActivity.this,
                                        "Username is already Registered before",Toast.LENGTH_SHORT).show();;
                            }
                            else{
                                //sending data to database
                                //all the details are under the username and username is unique
                                databaseReference.child("users").child(username_Text).child("fullname").setValue(full_nameText);
                                databaseReference.child("users").child(username_Text).child("password").setValue(password_text);
                                databaseReference.child("users").child(username_Text).child("email").setValue(email_text);
                                databaseReference.child("users").child(username_Text).child("phone").setValue(phone_text);

                                Toast.makeText(MainActivity.this,
                                        "User Registered Successful",Toast.LENGTH_SHORT).show();;
//                                   next page after a create>>>>>>>>>>>
                                finish();

                            }
                            Intent intent=new Intent(MainActivity.this,login.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
               }
            }
        });
        back_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);

            }
        });

    }



}