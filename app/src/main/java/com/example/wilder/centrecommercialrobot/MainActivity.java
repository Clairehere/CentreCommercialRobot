package com.example.wilder.centrecommercialrobot;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShop = findViewById(R.id.btn_shop);
        Button btnCaddy = findViewById(R.id.btn_caddy);
        Button btnCash = findViewById(R.id.btn_dollars);
        Button btnHome = findViewById(R.id.btn_home);
        Button btnHours = findViewById(R.id.btn_hours);
        final TextView tvResponse = findViewById(R.id.tv_response);
        final LinearLayout llBtn = findViewById(R.id.ll_btn);

        btnHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResponse.setVisibility(View.VISIBLE);
                llBtn.setVisibility(View.INVISIBLE);
            }
        });

        redirection(btnCaddy);
        redirection(btnCash);
        redirection(btnHome);
        redirection(btnShop);

    }

    public void redirection(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvResponse = findViewById(R.id.tv_response);
                TextView tvHelp = findViewById(R.id.tv_help);
                LinearLayout llBtn = findViewById(R.id.ll_btn);
                tvResponse.setText("Allons voir ça sur le plan");
                tvResponse.setVisibility(View.VISIBLE);
                llBtn.setVisibility(View.INVISIBLE);
                tvHelp.setVisibility(View.INVISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                        MainActivity.this.startActivity(intent);
                    }
                }, SPLASH_TIME_OUT);
            }
        });




    }
}
