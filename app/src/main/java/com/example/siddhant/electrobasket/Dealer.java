package com.example.siddhant.electrobasket;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Dealer extends AppCompatActivity {

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
        setContentView(R.layout.activity_dealer);
        name=findViewById(R.id.name);
        Intent intent =getIntent();
        if(intent.hasExtra("email"))
            email= intent.getStringExtra("email");
        if(intent.hasExtra("name"))
            nametxt= intent.getStringExtra("name");
        name.setText(nametxt);
    }


    public void ViewProfile(View view)
    {
        Intent i=new Intent(this,DealerViewProfile.class);
        i.putExtra("email",email);
        startActivity(i);
    }

    public void ViewOrders(View view)
    {
        Intent i=new Intent(this,DealerViewOrders.class);
        startActivity(i);
    }

    public void ViewAnalytics(View view)
    {
        Intent i=new Intent(this,DealerAnalytics.class);
        startActivity(i);
    }

    public void ViewStock(View view)
    {
        Intent i=new Intent(this,DealerViewStock.class);
        startActivity(i);
    }

    public void Mapping(View view)
    {
        Intent i=new Intent(this,DealerExecutive.class);
        startActivity(i);
    }

    public void Project(View view)
    {
        Intent i=new Intent(this,DealerProjectGoods.class);
        startActivity(i);
    }
}
