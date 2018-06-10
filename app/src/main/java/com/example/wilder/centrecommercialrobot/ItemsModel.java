package com.example.wilder.centrecommercialrobot;


public class ItemsModel {
    private String name;
    private String localisation;


    public ItemsModel(String name, String localisation) {
        this.name = name;
        this.localisation = localisation;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

}