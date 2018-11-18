package com.example.siddhant.electrobasket;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DealerViewOrders extends AppCompatActivity {
    TextView display;
    DatabaseReference db;
    StringBuffer sb=new StringBuffer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_view_orders);
        display=findViewById(R.id.display);
        db=FirebaseDatabase.getInstance().getReference("Users");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    if(ds.child("type").getValue(String.class).equals("Sub-Dealer"))
                    {
                        sb.append("\n").append(ds.child("name").getValue(String.class)).append("\n")
                                .append("   Surface Lights: ").append(ds.child("Orders").child("Surface Lights").getValue(Integer.class)).append("\n")
                                .append("   Bulbs: ").append(ds.child("Orders").child("Bulbs").getValue(Integer.class)).append("\n")
                                .append("   Led Batten: ").append(ds.child("Orders").child("Led Batten").getValue(Integer.class)).append("\n")
                                .append("   Architectural Lights: ").append(ds.child("Orders").child("Architectural Lights").getValue(Integer.class)).append("\n")
                                .append("   Facade Lights: ").append(ds.child("Orders").child("Facade Lights").getValue(Integer.class)).append("\n")
                                .append("   Panels: ").append(ds.child("Orders").child("Panels").getValue(Integer.class)).append("\n");
                    }
                }
                display.setText(sb.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

}
