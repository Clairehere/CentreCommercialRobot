package com.example.wilder.centrecommercialrobot;

import android.content.ClipData;
import android.content.Intent;
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

import java.util.Random;

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
        LinearLayout llMove = findViewById(R.id.ll_move);
        LinearLayout llLeft = findViewById(R.id.ll_left);
        LinearLayout llTop = findViewById(R.id.ll_top);
        LinearLayout llRight = findViewById(R.id.ll_right);


        llMove.setOnDragListener(dragListener);
        llLeft.setOnDragListener(dragListener);
        llTop.setOnDragListener(dragListener);
        llRight.setOnDragListener(dragListener);
        ivhere.setOnTouchListener(onTouchListener);
        Animation zoomAnimation = AnimationUtils.loadAnimation(MapsActivity.this, R.anim.zoom);
        ivhere.startAnimation(zoomAnimation);
        tv_here.startAnimation(zoomAnimation);

        Animation alphaAnimation = AnimationUtils.loadAnimation(MapsActivity.this, R.anim.alpha);

        String request = getIntent().getStringExtra("request");

        if (request != null && request.equals("caddy")) {
            ivCaddy1.startAnimation(alphaAnimation);
            ivCaddy2.startAnimation(alphaAnimation);

        } else if (request != null && request.equals("home")) {

        }

        String shop = getIntent().getStringExtra("shop");


        Button btnList = findViewById(R.id.btn_list);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, ListActivity.class);
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

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:


                    if (view.getId() == R.id.iv_here && v.getId() == R.id.ll_left) {

                        TextView tvTime = findViewById(R.id.tv_teleportation);
                        tvTime.setVisibility(View.VISIBLE);
                        tvTime.setText(R.string.time1);
                    }

                    else if (view.getId() == R.id.iv_here && v.getId() == R.id.ll_right) {

                        TextView tvTime = findViewById(R.id.tv_teleportation);
                        tvTime.setVisibility(View.VISIBLE);
                        tvTime.setText(R.string.time2);
                    } else if (view.getId() == R.id.iv_here && v.getId() == R.id.ll_top) {

                        TextView tvTime = findViewById(R.id.tv_teleportation);
                        tvTime.setVisibility(View.VISIBLE);
                        tvTime.setText(R.string.time3);


                    }

                    break;


            }

            return true;
        }
    };
}




