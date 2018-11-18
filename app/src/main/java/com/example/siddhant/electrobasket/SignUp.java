package com.example.siddhant.electrobasket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity {

private DatabaseReference db;
EditText name,phone,pass,email,address;
Button signup;
Spinner spinner1;
EditText[] edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        spinner1=findViewById(R.id.spinner1);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        address=findViewById(R.id.address);
        pass=findViewById(R.id.password);
        signup=findViewById(R.id.signup);
        db=FirebaseDatabase.getInstance().getReference("Users");

        ArrayAdapter<String> s1=new ArrayAdapter<String>(SignUp.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.name));
                s1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(s1);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit=new EditText[]{name,phone,address,email,pass};
                if(check(edit))
                {
                    String key =db.push().getKey();
                    String emailtext=email.getText().toString();
                    assert key != null;
                    db.child(key).child("name").setValue(name.getText().toString());
                    db.child(key).child("email").setValue(emailtext);
                    db.child(key).child("pass").setValue(pass.getText().toString());
                    db.child(key).child("phone").setValue(phone.getText().toString());
                    db.child(key).child("address").setValue(address.getText().toString());
                    db.child(key).child("type").setValue(spinner1.getSelectedItem().toString());

                    if(spinner1.getSelectedItem().toString().equals("Dealer"))
                    {
                        Intent i=new Intent(SignUp.this,Dealer.class);
                        i.putExtra("email",email.getText().toString());
                        startActivity(i);
                        finish();
                    }
                    else if(spinner1.getSelectedItem().toString().equals("Sub-Dealer"))
                    {
                        Intent i=new Intent(SignUp.this,SubDealer.class);
                        i.putExtra("email",email.getText().toString());
                        startActivity(i);
                        finish();
                    }
                    else if(spinner1.getSelectedItem().toString().equals("Salesman"))
                    {
                        Intent i=new Intent(SignUp.this,Salesman.class);
                        i.putExtra("email",email.getText().toString());
                        startActivity(i);
                        finish();
                    }


                }
            }
        });



    }

    private boolean check(EditText[] edit) {
        boolean check=false;
        for(EditText e: edit)
        {
            if(e.getText().toString().equals(""))
            {
                e.setError("This is required field");
                check=false;
                break;
            }
             else
                 check=true;
        }
        return check;
    }
}
