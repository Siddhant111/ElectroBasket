package com.example.siddhant.electrobasket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class SalesmanPlaceOrders extends AppCompatActivity {

    CardView sadd,ssub,badd,bsub,aadd,asub,fadd,fsub,padd,psub,ladd,lsub;
    TextView sshow,bshow,ashow,lshow,fshow,pshow;
    int scounter=0;
    int bcounter=0;
    int acounter=0;
    int fcounter=0;
    int pcounter=0;
    int lcounter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salesman_place_orders);

        sadd=findViewById(R.id.surfaceadd);
        sshow= findViewById(R.id.surfacetext );
        sadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scounter++;
                sshow.setText(Integer.toString(scounter));

            }
        });
        ssub=findViewById(R.id.surfacesub);

        ssub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scounter--;
                sshow.setText(Integer.toString(scounter));
            }
        });
        bsub=findViewById(R.id.bublsub);
        badd=findViewById(R.id.bulbadd);
        bshow=findViewById(R.id.bubltext);
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bcounter++;
                bshow.setText(Integer.toString(bcounter));
            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bcounter--;
                bshow.setText(Integer.toString(bcounter));
            }
        });

        ladd=findViewById(R.id.ledadd);
        lshow=findViewById(R.id.ledtext);
        lsub=findViewById(R.id.ledsub);
        ladd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lcounter++;
                lshow.setText(Integer.toString(lcounter));
            }
        });
        lsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lcounter--;
                lshow.setText(Integer.toString(lcounter));
            }
        });

        aadd=findViewById(R.id.arcadd);
        ashow=findViewById(R.id.arctext);
        asub=findViewById(R.id.arcsub);

        aadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acounter++;
                ashow.setText(Integer.toString(acounter));
            }
        });
        asub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acounter--;
                ashow.setText(Integer.toString(acounter));
            }
        });

        fadd=findViewById(R.id.fasadadd);
        fsub=findViewById(R.id.fasadsub);
        fshow=findViewById(R.id.fasadtext);

        fadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcounter++;
                fshow.setText(Integer.toString(fcounter));
            }
        });

        fsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcounter--;
                fshow.setText(Integer.toString(fcounter));
            }
        });

        padd=findViewById(R.id.panelsadd);
        psub=findViewById(R.id.panelsub);
        pshow=findViewById(R.id.paneltext);

        padd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pcounter++;
                pshow.setText(Integer.toString(pcounter));
            }
        });

        psub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pcounter--;
                pshow.setText(Integer.toString(pcounter));
            }
        });

    }

}
