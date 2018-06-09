package com.example.wilder.centrecommercialrobot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        GridView gridView = findViewById(R.id.grid_view);
        SearchView searchView = findViewById(R.id.search_view);
        Button btnBack = findViewById(R.id.btn_back);

        final ArrayList<ItemsModel> shopList = new ArrayList<>();
        shopList.add(new ItemsModel("Necminus femi", "A1"));
        shopList.add(new ItemsModel("Secreto", "A2"));
        shopList.add(new ItemsModel("Permissa", "B1"));
        shopList.add(new ItemsModel("Convictus", "B2"));
        shopList.add(new ItemsModel("Carnifex", "B3"));
        shopList.add(new ItemsModel("Obnoxiae", "C1"));
        shopList.add(new ItemsModel("Similium", "C2"));


        final GridAdapter gridAdapter = new GridAdapter(this, shopList);
        gridView.setAdapter(gridAdapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                gridAdapter.getFilter().filter(s);
                return false;
            }
        });

       btnBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(ListActivity.this, MapsActivity.class);
               startActivity(intent);
           }
       });

    }
}
