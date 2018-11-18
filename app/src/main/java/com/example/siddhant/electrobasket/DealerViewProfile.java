package com.example.siddhant.electrobasket;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DealerViewProfile extends AppCompatActivity {

    EditText name,phone,pass,email,address,cat;
    Button edit,save;
    private DatabaseReference db;
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_view_profile);
        Intent i=getIntent();
        final String mail=i.getStringExtra("email");
        db= FirebaseDatabase.getInstance().getReference("Users");
        name=findViewById(R.id.nameText);
        phone=findViewById(R.id.phonrText);
        email=findViewById(R.id.EmailText);
        address=findViewById(R.id.AddressText);
        pass=findViewById(R.id.passText);
        cat=findViewById(R.id.categoryText);
        edit=findViewById(R.id.edit);
        save=findViewById(R.id.save);
        disable();
        save.setVisibility(View.GONE);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot d: dataSnapshot.getChildren())
                {
                    if(d.child("email").getValue(String.class).equals(mail))
                    {
                        key=d.getKey();
                        name.setText(d.child("name").getValue(String.class));
                        email.setText(d.child("email").getValue(String.class));
                        phone.setText(d.child("phone").getValue(String.class));
                        pass.setText(d.child("pass").getValue(String.class));
                        address.setText(d.child("address").getValue(String.class));
                        cat.setText(d.child("type").getValue(String.class));

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DealerViewProfile.this, "Cannot display profile", Toast.LENGTH_SHORT).show();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enable();
                save.setVisibility(View.VISIBLE);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DealerViewProfile.this, "data saved", Toast.LENGTH_SHORT).show();
                db.child(key).child("name").setValue(name.getText().toString());
                db.child(key).child("email").setValue(email.getText().toString());
                db.child(key).child("pass").setValue(pass.getText().toString());
                db.child(key).child("phone").setValue(phone.getText().toString());
                db.child(key).child("address").setValue(address.getText().toString());
                disable();
                save.setVisibility(View.GONE);
            }
        });
    }
    void enable()
    {
        name.setEnabled(true);
        phone.setEnabled(true);
        email.setEnabled(true);
        pass.setEnabled(true);
        address.setEnabled(true);
    }
    void disable()
    {
        name.setEnabled(false);
        phone.setEnabled(false);
        email.setEnabled(false);
        pass.setEnabled(false);
        address.setEnabled(false);
        cat.setEnabled(false);
    }

}
