package com.example.wilder.centrecommercialrobot;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilterList extends Filter {

    private ArrayList<ItemsModel> filterList;
    private GridAdapter adapter;

    public CustomFilterList(ArrayList<ItemsModel> filterList, GridAdapter adapter) {
        this.filterList = filterList;
        this.adapter = adapter;
    }

    @Override
    protected Filter.FilterResults performFiltering(CharSequence constraint) {
        Filter.FilterResults results = new Filter.FilterResults();

        if (constraint != null && constraint.length() > 0) {
            constraint = constraint.toString().toUpperCase();
            ArrayList<ItemsModel> filteredVideos = new ArrayList<>();

            for (int i = 0; i < filterList.size(); i++) {
                if (filterList.get(i).getName().toUpperCase().contains(constraint)) {
                    filteredVideos.add(filterList.get(i));
                }
            }

            results.count = filteredVideos.size();
            results.values = filteredVideos;
        } else {
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
        adapter.items = (ArrayList<ItemsModel>) results.values;
        adapter.notifyDataSetChanged();
    }
}
