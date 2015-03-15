package com.dnocode.google.apis.geocoding.models;

import com.dnocode.google.apis.commons.models.AddressComponent;
import com.dnocode.google.apis.commons.models.Geometry;
import com.dnocode.google.apis.places.models.Place;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dino on 15/03/15.
 */
public class PlaceReversed implements Serializable{

    @SerializedName("address_components")
    @Expose
    public List<AddressComponent> addressComponents = new ArrayList<AddressComponent>();
    @SerializedName("formatted_address")
    @Expose
    public String formattedAddress;
    @Expose
    public Geometry geometry;
    @SerializedName("place_id")
    @Expose
    public String placeId;
    @Expose
    public List<String> types = new ArrayList<String>();
}