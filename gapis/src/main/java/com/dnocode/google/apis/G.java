package com.dnocode.google.apis;

import android.content.Context;

import com.dnocode.google.apis.geocoding.GoogleGeocoder;
import com.dnocode.google.apis.places.GooglePlaces;

import java.security.InvalidParameterException;

/**
 * Created by dino on 12/03/15.
 */
public class G {

    private static G INSTANCE;

    private GooglePlaces mGooglePlacesClient;

    private GoogleGeocoder mGooglGeocoderClient;

    private Context mContext;

    public static G api(Context ... context){


            if(INSTANCE==null&&context.length==0){ throw  new InvalidParameterException("context is required for instantiate"); }

           INSTANCE=INSTANCE==null?(INSTANCE=new G()):INSTANCE;

           INSTANCE.mContext=context.length>0?context[0]:INSTANCE.mContext;

           return INSTANCE;
    }


    public GooglePlaces places(){return mGooglePlacesClient!=null?mGooglePlacesClient:(mGooglePlacesClient=new GooglePlaces(mContext)); }

    public GoogleGeocoder geocoder(){ return mGooglGeocoderClient!=null?mGooglGeocoderClient:(mGooglGeocoderClient=new GoogleGeocoder(mContext)); }

}
