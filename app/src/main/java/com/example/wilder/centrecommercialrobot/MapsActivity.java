package com.example.wilder.centrecommercialrobot;

import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MapsActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        ImageView ivCaddy1 = findViewById(R.id.iv_caddy1);
        ImageView ivCaddy2 = findViewById(R.id.iv_caddy2);
        ImageView ivHome = findViewById(R.id.iv_home);
        ImageView ivhere = findViewById(R.id.iv_here);
        final ImageView ivRobot = findViewById(R.id.iv_robot);
        TextView tvHere = findViewById(R.id.tv_here);
        TextView tvLocalisation = findViewById(R.id.tv_localisation);

        LinearLayout llLeft = findViewById(R.id.ll_left);
        LinearLayout llTop = findViewById(R.id.ll_top);
        LinearLayout llRight = findViewById(R.id.ll_right);

        Button btnList = findViewById(R.id.btn_list);
        Button btnBack = findViewById(R.id.btn_back);

        String request = getIntent().getStringExtra("request");
        String nameShop = getIntent().getStringExtra("nameShop");

        llLeft.setOnDragListener(dragListener);
        llTop.setOnDragListener(dragListener);
        llRight.setOnDragListener(dragListener);
        ivhere.setOnTouchListener(onTouchListener);
        Animation zoomAnimation = AnimationUtils.loadAnimation(MapsActivity.this, R.anim.zoom);
        ivhere.startAnimation(zoomAnimation);
        tvHere.startAnimation(zoomAnimation);

        Animation alphaAnimation = AnimationUtils.loadAnimation(MapsActivity.this, R.anim.alpha);

        if (request != null && request.equals("caddy")) {
            ivCaddy1.startAnimation(alphaAnimation);
            ivCaddy2.startAnimation(alphaAnimation);


        } else if (request != null && request.equals("home")) {
            ivHome.startAnimation(alphaAnimation);
        }

        if (nameShop != null && (nameShop.equals("A1") || nameShop.equals("A2"))) {
            tvLocalisation.setVisibility(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ObjectAnimator.ofFloat(ivRobot, "translationY", 0, -550).setDuration(400).start();
                    ObjectAnimator.ofFloat(ivRobot, "translationX", 0, -150).setDuration(400).start();


                }
            }, SPLASH_TIME_OUT);
        }
        if (nameShop != null && (nameShop.equals("B1") || nameShop.equals("B2") || nameShop.equals("B3"))) {
            tvLocalisation.setVisibility(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ObjectAnimator.ofFloat(ivRobot, "translationY", 0, -700).setDuration(400).start();


                }
            }, SPLASH_TIME_OUT);

        }
        if (nameShop != null && (nameShop.equals("C1") || nameShop.equals("C2"))) {
            tvLocalisation.setVisibility(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ObjectAnimator.ofFloat(ivRobot, "translationY", 0, -350).setDuration(400).start();
                    ObjectAnimator.ofFloat(ivRobot, "translationX", 0, 150).setDuration(400).start();


                }
            }, SPLASH_TIME_OUT);
        }


        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, ListActivity.class);
                MapsActivity.this.startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MainActivity.class);
                MapsActivity.this.startActivity(intent);
            }
        });
    }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            String time1 = "Temps de marche : 1 min";
            String time2 = "Temps de marche : 2 min";
            String time3 = "Temps de marche : 3 min";

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:


                    if (view.getId() == R.id.iv_here && v.getId() == R.id.ll_left) {

                        actionMove(time2);
                    } else if (view.getId() == R.id.iv_here && v.getId() == R.id.ll_right) {

                        actionMove(time1);
                    } else if (view.getId() == R.id.iv_here && v.getId() == R.id.ll_top) {

                        actionMove(time3);


                    }

                    break;
            }

            return true;
        }
    };

    public void actionMove(String time) {
        final TextView tvTime = findViewById(R.id.tv_teleportation);
        tvTime.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvTime.setVisibility(View.INVISIBLE);
            }
        }, SPLASH_TIME_OUT);

        tvTime.setText(time);
    }
}




