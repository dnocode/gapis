package com.dnocode.google.apis.test;

import android.app.Application;
import android.location.Location;
import android.test.ApplicationTestCase;

import com.dnocode.google.apis.G;
import com.dnocode.google.apis.geocoding.models.PlaceReversed;
import com.dnocode.google.apis.places.models.Place;

import com.dnocode.google.apis.places.query.AutoCompleteSearchQuery;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testHowToUse(){


        G.api(getContext());
        /**query prepare**/
        AutoCompleteSearchQuery qry=new AutoCompleteSearchQuery();
        qry.setRadius(500);
        qry.setTypes(new String[]{"address"});
        qry.setInput("savon");

        /***places api**/
        try {

            List<Place> placesList=G.api().places().getPredictions(qry);

            for(Place place : placesList){   G.api().places().getDetails(place.placeId); }


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**geocoder**/

        Location location=new Location("dummyprovider");
        location.setLatitude(45.450532);
        location.setLongitude(9.157225);


        try {



           List<PlaceReversed> list= G.api().geocoder().reverseByLocation(location);

            for(PlaceReversed place : list){

            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}