package com.example.wilder.centrecommercialrobot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class GridAdapter extends BaseAdapter implements Filterable {

    private final Context mContext;
    public ArrayList<ItemsModel> items;

    private ArrayList<ItemsModel> filterList;
    private CustomFilterList filter;


    public GridAdapter(Context context, ArrayList<ItemsModel> items) {
        this.mContext = context;
        this.items = items;
        this.filterList = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ItemsModel items = this.items.get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_list, null);
        }

        final TextView tvName = convertView.findViewById(R.id.tv_name);
        TextView tvLocalisation = convertView.findViewById(R.id.tv_localisation);


        tvName.setText(items.getName());
        tvLocalisation.setText(items.getLocalisation());



        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(mContext, ListActivity.class);

                mContext.startActivity(intent);
            }
        });


        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilterList(filterList, this);
        }
        return filter;
    }
}
