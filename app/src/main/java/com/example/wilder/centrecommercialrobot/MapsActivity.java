package com.example.wilder.centrecommercialrobot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        ImageView ivCaddy1 = findViewById(R.id.iv_caddy1);
        ImageView ivCaddy2 = findViewById(R.id.iv_caddy2);
        ImageView ivHome = findViewById(R.id.iv_home);
        ImageView ivhere = findViewById(R.id.iv_here);
        TextView tv_here = findViewById(R.id.tv_here);

        Animation zoomAnimation = AnimationUtils.loadAnimation(MapsActivity.this, R.anim.zoom);
        ivhere.startAnimation(zoomAnimation);
        tv_here.startAnimation(zoomAnimation);

        Animation alphaAnimation =AnimationUtils.loadAnimation(MapsActivity.this, R.anim.alpha);

        String request = getIntent().getStringExtra("request");

        if (request.equals("caddy")){
            ivCaddy1.startAnimation(alphaAnimation);
            ivCaddy2.startAnimation(alphaAnimation);

        }else if (request.equals("home")){

        }

        String shop = getIntent().getStringExtra("shop");

        if(shop != null){

        }

        Button btnList = findViewById(R.id.btn_list);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this,ListActivity.class);
                MapsActivity.this.startActivity(intent);
            }
        });
    }
}
