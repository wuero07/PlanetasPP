package com.example.planetas;// Planet.java

import java.io.Serializable;

public class Planet implements Serializable {
    private String name;
    private int imageResId;
    private String shortDescription;
    private String longDescription;

    public Planet(String name, int imageResId, String shortDescription, String longDescription) {
        this.name = name;
        this.imageResId = imageResId;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }
}
