package com.example.siddhant.electrobasket;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SubDealerPlaceOrder extends AppCompatActivity {
    CardView sadd,ssub,badd,bsub,aadd,asub,fadd,fsub,padd,psub,ladd,lsub;
    TextView sshow,bshow,ashow,lshow,fshow,pshow;
    int scounter=0,bcounter=0,acounter=0,fcounter=0,pcounter=0,lcounter=0;
    String key;
    DatabaseReference d,place;
    Button placeOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_dealer_place_order);
        placeOrder=findViewById(R.id.viewprofile);
        Intent in=getIntent();
        final String email=in.getStringExtra("email");

        place= FirebaseDatabase.getInstance().getReference("Users");
        d= FirebaseDatabase.getInstance().getReference("Users");
        d.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                    if(ds.child("email").getValue(String.class).equals(email))
                        key=ds.getKey();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place.child(key+"/Orders").child("Surface Lights").setValue(scounter);
                place.child(key+"/Orders").child("Bulbs").setValue(bcounter);
                place.child(key+"/Orders").child("Led Batten").setValue(lcounter);
                place.child(key+"/Orders").child("Architectural Lights").setValue(acounter);
                place.child(key+"/Orders").child("Facade Lights").setValue(fcounter);
                place.child(key+"/Orders").child("Panels").setValue(pcounter);
                Toast.makeText(SubDealerPlaceOrder.this, "Order placed", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        sadd=findViewById(R.id.surfaceadd);
        sshow= findViewById(R.id.surfacetext );
        sadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scounter++;
                sshow.setText(scounter+"");
            }
        });
        ssub=findViewById(R.id.surfacesub);

        ssub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scounter--;
                sshow.setText(scounter+"");
            }
        });
        bsub=findViewById(R.id.bublsub);
        badd=findViewById(R.id.bulbadd);
        bshow=findViewById(R.id.bubltext);
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bcounter++;
                bshow.setText(bcounter+"");
            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bcounter--;
                bshow.setText(bcounter+"");
            }
        });

        ladd=findViewById(R.id.ledadd);
        lshow=findViewById(R.id.ledtext);
        lsub=findViewById(R.id.ledsub);
        ladd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lcounter++;
                lshow.setText(lcounter+"");
            }
        });
        lsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lcounter--;
                lshow.setText(lcounter+"");
            }
        });

        aadd=findViewById(R.id.arcadd);
        ashow=findViewById(R.id.arctext);
        asub=findViewById(R.id.arcsub);

        aadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acounter++;
                ashow.setText(acounter+"");
            }
        });
        asub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acounter--;
                ashow.setText(acounter+"");
            }
        });

        fadd=findViewById(R.id.fasadadd);
        fsub=findViewById(R.id.fasadsub);
        fshow=findViewById(R.id.fasadtext);

        fadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcounter++;
                fshow.setText(fcounter+"");
            }
        });

        fsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcounter--;
                fshow.setText(fcounter+"");
            }
        });

        padd=findViewById(R.id.panelsadd);
        psub=findViewById(R.id.panelsub);
        pshow=findViewById(R.id.paneltext);

        padd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pcounter++;
                pshow.setText(pcounter+"");
            }
        });

        psub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pcounter--;
                pshow.setText(pcounter+"");
            }
        });



    }
}
