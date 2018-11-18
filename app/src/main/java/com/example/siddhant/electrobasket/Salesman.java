package com.example.siddhant.electrobasket;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Salesman extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    String email,nametxt;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slaesman);
        name=findViewById(R.id.name);
        Intent intent =getIntent();
        if(intent.hasExtra("email"))
            email= intent.getStringExtra("email");
        if(intent.hasExtra("name"))
            nametxt= intent.getStringExtra("name");
        name.setText(nametxt);
    }

    public void SalesmanViewProfile(View view)
    {
        Intent i=new Intent(this,SalesmanViewProfile.class);
        i.putExtra("email",email);
        startActivity(i);
    }

    public void ViewPlacedOrders(View view)
    {
        Intent i=new Intent(this,SalesmanViewPlacedOrders.class);
        startActivity(i);
    }

    public void SalesmanPlaceOrder(View view)
    {
        Intent i=new Intent(this,SalesmanPlaceOrders.class);
        startActivity(i);
    }

    public void Location(View view)
    {
        Intent i=new Intent(this,SalesmanGiveLocation.class);
        startActivity(i);
    }


}
