package com.dnocode.google.apis.geocoding;

import android.content.Context;
import android.location.Location;

import com.dnocode.google.apis.commons.mappers.Result;
import com.dnocode.google.apis.geocoding.models.PlaceReversed;
import com.dnocode.google.apis.places.models.Place;
import com.dnocode.google.apis.geocoding.query.ReverseGeocodeQuery;
import com.dnocode.google.apis.utils.AppUtils;
import com.dnocode.google.apis.utils.Network;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class GoogleGeocoder {

	private String mApiKey = "";

    public GoogleGeocoder(String apiKey) {mApiKey = apiKey;}

    public GoogleGeocoder(Context context) { mApiKey = AppUtils.getMetadataApplication(context, AppUtils.KEY_HOOK);}

     public List<PlaceReversed> reverseByLocation(Location location)throws JSONException, IOException {

         ReverseGeocodeQuery rgq=new ReverseGeocodeQuery(location);

         JSONObject response = Network.executeRequest(rgq.toString(), mApiKey);
         List<PlaceReversed> geoResultList= Result.map(response, PlaceReversed.class).pullout();

         return geoResultList;
     }

	



}
