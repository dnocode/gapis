package com.dnocode.google.apis.places.models;

import android.os.Parcel;

import org.json.JSONException;
import org.json.JSONObject;

public class PlaceReview  {

	public int mRating = 0;

    public String mAuthorName = "";

	public String mText = "";

	public PlaceReview(Parcel in) {
		mRating = in.readInt();
		mAuthorName = in.readString();
		mText = in.readString();
	}
	
	public PlaceReview(JSONObject jsonReview) {

        try {

				mRating = jsonReview.getJSONArray("aspects").getJSONObject(0).getInt("rating");
			    mAuthorName = jsonReview.getString("author_name");
		     	mText = jsonReview.getString("text");

        } catch(JSONException e) {
			e.printStackTrace();
		}
	}



	

}
