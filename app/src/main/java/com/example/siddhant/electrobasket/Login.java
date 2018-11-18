package com.example.siddhant.electrobasket;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

     Button login;
     EditText username,pass;
     TextView signup;
     String name;
     private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.loginbtn);
        username=findViewById(R.id.userid);
        pass=findViewById(R.id.pass);
        signup=findViewById(R.id.signup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String user=username.getText().toString();
                    String p=pass.getText().toString();
                if (user.equals(""))
                    username.setError("Username is required");
                else if (p.equals(""))
                    pass.setError("Password is required");
                else
                    login(user,p);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),SignUp.class));
            }
        });

    }
    void login(final String email, final String pass)
    {
        db= FirebaseDatabase.getInstance().getReference("Users");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot d: dataSnapshot.getChildren())
                {
                    if(d.child("email").getValue(String.class).equals(email))
                    {
                        name=d.child("name").getValue(String.class);
                        if(d.child("pass").getValue(String.class).equals(pass))
                        {
                            if(d.child("type").getValue(String.class).equals("Dealer"))
                            {
                                Intent i=new Intent(Login.this,Dealer.class);
                                i.putExtra("email",email);
                                i.putExtra("name",name);
                                startActivity(i);
                                finish();
                            }
                            else if(d.child("type").getValue(String.class).equals("Sub-Dealer"))
                            {
                                Intent i=new Intent(Login.this,SubDealer.class);
                                i.putExtra("email",email);
                                i.putExtra("name",name);
                                startActivity(i);
                                finish();
                            }
                            else if(d.child("type").getValue(String.class).equals("Salesman"))
                            {
                                Intent i=new Intent(Login.this,Salesman.class);
                                i.putExtra("email",email);
                                i.putExtra("name",name);
                                startActivity(i);
                                finish();
                            }

                        }
                        else
                            Toast.makeText(Login.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    }
