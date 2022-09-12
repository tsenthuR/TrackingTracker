package com.example.kisho.trackingtracker.user;

public class FlagingItems {
    private final String place,descrption,rating;

    public String getPlace() {
        return place;
    }

    public String getDescrption() {
        return descrption;
    }

    public String getRating() {
        return rating;
    }

    public FlagingItems(String place, String descrption, String ratinf) {
        this.place = place;
        this.descrption = descrption;
        this.rating = ratinf;
    }
}
