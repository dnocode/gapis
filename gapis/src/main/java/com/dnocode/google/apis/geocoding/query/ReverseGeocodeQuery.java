package com.dnocode.google.apis.geocoding.query;


import android.location.Location;

/**
 * @author  dino
 */

public class ReverseGeocodeQuery extends SearchQuery {

    public  ReverseGeocodeQuery(Location location){

        setLocation(location);
    }

    @Override
    public String getUrl() {

        return "https://maps.googleapis.com/maps/api/geocode/json";
    }
}
