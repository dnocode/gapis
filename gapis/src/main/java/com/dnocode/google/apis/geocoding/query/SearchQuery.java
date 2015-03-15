package com.dnocode.google.apis.geocoding.query;

import android.location.Location;

import com.dnocode.google.apis.commons.query.Query;
import com.dnocode.google.apis.geocoding.enums.ResultTypes;
import com.google.android.gms.maps.model.LatLng;


abstract class SearchQuery extends Query {

	private StringBuilder mResultTypes = new StringBuilder();
	
	public void setLocation(double latitude, double longitude) {

        String location = Double.toString(latitude) + "," + Double.toString(longitude);

        mQueryBuilder.addParameter("latlng", location);

	}

	public void setLocation(Location location) {setLocation(location.getLatitude(), location.getLongitude());}

    public void setLocation(LatLng location) {
        setLocation(location.latitude, location.longitude);
    }
	
	public void setRadius(int radius) {mQueryBuilder.addParameter("radius", Integer.toString(radius));}
	
	public void setKey(String key) {
		mQueryBuilder.addParameter("key", key);
	}

	public void addResultType(ResultTypes type) {

        mResultTypes.append(type.toString());

        mResultTypes.append("|");
	}
	
	@Override
	public String toString() {
		return (getUrl() + mQueryBuilder.toString());
	}

    public void setTypes(String[] types) {

        for (String type : types) {

            mResultTypes.append(type);
            mResultTypes.append("|");
        }

        mResultTypes.deleteCharAt(mResultTypes.length() - 1);
        mQueryBuilder.removeParameter("types");
        mQueryBuilder.addParameter("types", mResultTypes.toString());
    }
}
