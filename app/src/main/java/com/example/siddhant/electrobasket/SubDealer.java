package com.example.siddhant.electrobasket;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SubDealer extends AppCompatActivity {
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
        setContentView(R.layout.activity_sub_dealer);
        name=findViewById(R.id.name);
        Intent intent =getIntent();
        if(intent.hasExtra("email"))
            email= intent.getStringExtra("email");
        if(intent.hasExtra("name"))
            nametxt= intent.getStringExtra("name");
        name.setText(nametxt);

            }


    public void ViewPro(View view)
    {
        Intent i=new Intent(this,SubDealerViewProfile.class);
        i.putExtra("email",email);
        startActivity(i);
    }

    public void SubViewStock(View view)
    {
        Intent i=new Intent(this,SubDealerViewStock.class);
        i.putExtra("email",email);
        startActivity(i);
    }

    public void SubViewOrder(View view)
    {
        Intent i=new Intent(this,SubDealerViewOrder.class);
        i.putExtra("email",email);
        startActivity(i);
    }

    public void SubMapping(View view)
    {
        Intent i=new Intent(this,SubDealerMapping.class);
        i.putExtra("email",email);
        startActivity(i);
    }

    public void PlaceOrder(View view)
    {
        Intent i=new Intent(this,SubDealerPlaceOrder.class);
        i.putExtra("email",email);
        startActivity(i);
    }

    public void Retail(View view)
    {
        Intent i=new Intent(this,SubDealerRetailGoods.class);
        i.putExtra("email",email);
        startActivity(i);
    }

}
