package com.dnocode.google.apis.utils;

import android.util.Log;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by dino on 12/03/15.
 */
public class Network {


    public static JSONObject executeRequest(String query,String key)
            throws IOException, JSONException {

        query += "key=" + key;

        HttpClient client = new DefaultHttpClient();

        HttpGet request = new HttpGet(query);

        ResponseHandler<String> handler = new BasicResponseHandler();

        String response = client.execute(request, handler);

        Log.d("GoogleLibNetwork", "request executed = " + query);

        JSONObject jsonResponse = new JSONObject(response);

        return jsonResponse;
    }

}
