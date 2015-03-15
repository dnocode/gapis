package com.dnocode.google.apis.places.query;


import com.dnocode.google.apis.commons.query.Query;

public class DetailsQuery extends Query {

	public DetailsQuery(String placeId) {
		setReference(placeId);
	}
	
	public void setReference(String placeId) {
		mQueryBuilder.addParameter("placeid", placeId);
	}
	
	@Override
	public String getUrl() {
		return "https://maps.googleapis.com/maps/api/place/details/json";
	}

}