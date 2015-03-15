package com.dnocode.google.apis.places;

import android.content.Context;

import com.dnocode.google.apis.commons.mappers.Result;
import com.dnocode.google.apis.commons.query.Query;
import com.dnocode.google.apis.places.models.Place;
import com.dnocode.google.apis.places.models.PlaceDetails;
import com.dnocode.google.apis.places.query.DetailsQuery;
import com.dnocode.google.apis.places.query.NearbySearchQuery;
import com.dnocode.google.apis.places.query.TextSearchQuery;
import com.dnocode.google.apis.utils.AppUtils;
import com.dnocode.google.apis.utils.Network;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.List;

public class GooglePlaces {

	private String mApiKey = "";
	private AbstractSet<String> mSupportedPlaces;

	public GooglePlaces(String apiKey) {

        mApiKey = apiKey;
        loadSupportedPlaces();
	}


    public GooglePlaces(Context context) {

        mApiKey = AppUtils.getMetadataApplication(context, AppUtils.KEY_HOOK);
        loadSupportedPlaces();
    }
	
	public List<Place> getPlaces(String[] types, String keyword, int radius, double lat, double lon)
			throws JSONException, IOException {

        NearbySearchQuery query = new NearbySearchQuery(lat, lon);
		query.setRadius(radius);
		 query.setTypes(types);
		
		if (keyword != null && keyword != "") {
			query.setKeyword(keyword);
		}
		
		 List<Place> results = getPlaces(query);
		
		return results;
	}
	
	public  List<Place> getPlaces(String[] types, int radius, double lat, double lon)
			throws  JSONException, IOException {
		return getPlaces(types, null, radius, lat, lon);
	}
	
	public  List<Place> getPlaces(String type, String keyword, int radius, double lat, double lon)
			throws  JSONException, IOException {
		//List<String> types = Arrays.asList(type);
		return getPlaces(new String[]{type}, keyword, radius, lat, lon);
	}
	
	public  List<Place> getPlaces(String type, int radius, double lat, double lon)
			throws  JSONException, IOException {
		return getPlaces(type, null, radius, lat, lon);
	}
	
	public  List<Place> getPlaces(String searchText, double lat, double lon)
			throws  JSONException, IOException {
		TextSearchQuery query = new TextSearchQuery(searchText);
		query.setLocation(lat, lon);
        List<Place> result = getPlaces(query);
		
		return result;
	}
	
	public  List<Place> getPlaces(String searchText)
			throws  JSONException, IOException {

        TextSearchQuery query = new TextSearchQuery(searchText);

        List<Place> result = getPlaces(query);

        return result;
	}

	public List<Place> getPlaces(Query query)throws JSONException, IOException {
		JSONObject response = Network.executeRequest(query.toString(), mApiKey);


		return Result.map(response,Place.class).pullout();
	}

    public List<Place> getPredictions(Query query) throws JSONException, IOException {

        JSONObject response = Network.executeRequest(query.toString(),mApiKey);

        return Result.map(response,Place.class).pullout();
    }
	
	public PlaceDetails getDetails(String placeId)
			throws JSONException, IOException {

        DetailsQuery query = new DetailsQuery(placeId);
        PlaceDetails pd = getDetails(query);
		
		return pd;
	}
	
	public PlaceDetails getDetails(Query query)
			throws JSONException,  IOException {

        JSONObject response = Network.executeRequest(query.toString(), mApiKey);

        List<PlaceDetails> placeDetailsList=Result.map(response,PlaceDetails.class).pullout();

        return placeDetailsList.isEmpty()?null:placeDetailsList.get(0);

    }


	public boolean isSupportedPlace(String placeType) {
		return (mSupportedPlaces.contains(placeType));
	}
	

	private void loadSupportedPlaces() {
		mSupportedPlaces = new HashSet<String>();
		mSupportedPlaces.add("accounting");
		mSupportedPlaces.add("airport");
		mSupportedPlaces.add("amusement park");
		mSupportedPlaces.add("aquarium");
		mSupportedPlaces.add("art gallery");
		mSupportedPlaces.add("atm");
		mSupportedPlaces.add("bakery");
		mSupportedPlaces.add("bank");
		mSupportedPlaces.add("bar");
		mSupportedPlaces.add("beauty salon");
		mSupportedPlaces.add("bicycle store");
		mSupportedPlaces.add("book store");
		mSupportedPlaces.add("bowling alley");
		mSupportedPlaces.add("bus station");
		mSupportedPlaces.add("cafe");
		mSupportedPlaces.add("campground");
		mSupportedPlaces.add("car dealer");
		mSupportedPlaces.add("car rental");
		mSupportedPlaces.add("car repair");
		mSupportedPlaces.add("car wash");
		mSupportedPlaces.add("casino");
		mSupportedPlaces.add("cemetery");
		mSupportedPlaces.add("church");
		mSupportedPlaces.add("city hall");
		mSupportedPlaces.add("clothing store");
		mSupportedPlaces.add("convenience store");
		mSupportedPlaces.add("courthouse");
		mSupportedPlaces.add("dentist");
		mSupportedPlaces.add("department store");
		mSupportedPlaces.add("doctor");
		mSupportedPlaces.add("electrician");
		mSupportedPlaces.add("electronics store");
		mSupportedPlaces.add("embassy");
		mSupportedPlaces.add("establishment");
		mSupportedPlaces.add("finance");
		mSupportedPlaces.add("fire station");
		mSupportedPlaces.add("florist");
		mSupportedPlaces.add("food");
		mSupportedPlaces.add("funeral home");
		mSupportedPlaces.add("furniture store");
		mSupportedPlaces.add("gas station");
		mSupportedPlaces.add("general contractor");
		mSupportedPlaces.add("grocery or supermarket");
		mSupportedPlaces.add("gym");
		mSupportedPlaces.add("hair care");
		mSupportedPlaces.add("hardware store");
		mSupportedPlaces.add("health");
		mSupportedPlaces.add("hindu temple");
		mSupportedPlaces.add("home goods store");
		mSupportedPlaces.add("hospital");
		mSupportedPlaces.add("insurance agency");
		mSupportedPlaces.add("jewelry store");
		mSupportedPlaces.add("laundry");
		mSupportedPlaces.add("lawyer");
		mSupportedPlaces.add("library");
		mSupportedPlaces.add("liquor store");
		mSupportedPlaces.add("local government office");
		mSupportedPlaces.add("locksmith");
		mSupportedPlaces.add("lodging");
		mSupportedPlaces.add("meal delivery");
		mSupportedPlaces.add("meal takeaway");
		mSupportedPlaces.add("mosque");
		mSupportedPlaces.add("movie rental");
		mSupportedPlaces.add("movie theater");
		mSupportedPlaces.add("moving company");
		mSupportedPlaces.add("museum");
		mSupportedPlaces.add("night club");
		mSupportedPlaces.add("painter");
		mSupportedPlaces.add("park");
		mSupportedPlaces.add("parking");
		mSupportedPlaces.add("pet store");
		mSupportedPlaces.add("pharmacy");
		mSupportedPlaces.add("physiotherapist");
		mSupportedPlaces.add("place of worship");
		mSupportedPlaces.add("plumber");
		mSupportedPlaces.add("police");
		mSupportedPlaces.add("post office");
		mSupportedPlaces.add("real estate agency");
		mSupportedPlaces.add("restaurant");
		mSupportedPlaces.add("roofing contractor");
		mSupportedPlaces.add("rv park");
		mSupportedPlaces.add("school");
		mSupportedPlaces.add("shoe store");
		mSupportedPlaces.add("shopping mall");
		mSupportedPlaces.add("spa");
		mSupportedPlaces.add("stadium");
		mSupportedPlaces.add("storage");
		mSupportedPlaces.add("store");
		mSupportedPlaces.add("subway station");
		mSupportedPlaces.add("synagogue");
		mSupportedPlaces.add("taxi stand");
		mSupportedPlaces.add("train station");
		mSupportedPlaces.add("travel agency");
		mSupportedPlaces.add("university");
		mSupportedPlaces.add("veterinary care");
		mSupportedPlaces.add("zoo");
	}
}
