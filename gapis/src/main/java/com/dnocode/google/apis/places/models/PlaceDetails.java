package com.dnocode.google.apis.places.models;

import com.dnocode.google.apis.commons.models.AddressComponent;
import com.dnocode.google.apis.commons.models.Geometry;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PlaceDetails implements Serializable {

    @Expose
    public String id;
    @SerializedName("place_id")
    @Expose
    public String placeId;
    @Expose
    public String icon;
    @Expose
    public String vicinity;
    @Expose
    public String scope;
    @SerializedName("address_components")
    @Expose
    public List<AddressComponent> addressComponents = new ArrayList<AddressComponent>();
    @Expose
    public String name;
    @SerializedName("formatted_address")
    @Expose
    public String formattedAddress;
    @SerializedName("adr_address")
    @Expose
    public String adrAddress;
    @Expose
    public List<String> types = new ArrayList<String>();
    @Expose
    public String url;
    @Expose
    public String reference;
    @Expose
    public Geometry geometry;

}