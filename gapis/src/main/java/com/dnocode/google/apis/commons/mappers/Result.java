package com.dnocode.google.apis.commons.mappers;


import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Result {

    public static final String STATUS_CODE_OK = "OK";
    public static final String STATUS_CODE_ZERO_RESULTS = "ZERO_RESULTS";
    public static final String STATUS_CODE_OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT";
    public static final String STATUS_CODE_REQUEST_DENIED = "REQUEST_DENIED";
    public static final String STATUS_CODE_INVALID_REQUEST = "INVALID_REQUEST";

    protected List<Object> mResults;

    public enum StatusCode
    {
        OK,
        ZeroResults,
        OverQueryLimit,
        RequestDenied,
        InvalidRequest,
        Unknown
    }

    public enum supportedKeys
    {
        results,
        result,
        predictions,

    }



    private StatusCode mStatusCode;

    private String mStatusCodeValue = "";


    protected  Result(){}

    public StatusCode getStatusCode() {
        return mStatusCode;
    }

    public String getStatusCodeValue() {
        return mStatusCodeValue;
    }

    public boolean requestSucceeded() {return (mStatusCode == StatusCode.OK || mStatusCode == StatusCode.ZeroResults);}

    protected StatusCode getStatusCodeFromValue(String statusCodeValue) {
        if (statusCodeValue.equals(STATUS_CODE_OK)) {
            return StatusCode.OK;
        } else if (statusCodeValue.equals(STATUS_CODE_ZERO_RESULTS)) {
            return StatusCode.ZeroResults;
        } else if (statusCodeValue.equals(STATUS_CODE_OVER_QUERY_LIMIT)) {
            return StatusCode.OverQueryLimit;
        } else if (statusCodeValue.equals(STATUS_CODE_REQUEST_DENIED)) {
            return StatusCode.RequestDenied;
        } else if (statusCodeValue.equals(STATUS_CODE_INVALID_REQUEST)) {
            return StatusCode.InvalidRequest;
        } else {
            return StatusCode.Unknown;
        }
    }


    private static Result INSTANCE=null;


    public static Result map(JSONObject jsonResponse,Class clazz){

        try {


            INSTANCE=INSTANCE == null ? new Result() : INSTANCE;

            INSTANCE.mResults=new ArrayList<Object>();

            if (jsonResponse.has("status")) {

                       INSTANCE.mStatusCode = INSTANCE.getStatusCodeFromValue(jsonResponse.getString("status"));

                if (INSTANCE.mStatusCode==StatusCode.OK) {

                    String key=null;

                    for(supportedKeys supportedKey : supportedKeys.values()){

                            key= jsonResponse.has(supportedKey.toString())?  supportedKey.toString():key;

                            if(key!=null){break;}

                        }


                        JSONArray results =  jsonResponse.optJSONArray(key)!=null?jsonResponse.getJSONArray(key):new JSONArray();

                        if(key.equals(supportedKeys.result.toString())){   results.put(jsonResponse.getJSONObject(key));   }

                            for (int i = 0; i < results.length(); i++) {

                                Object obj;

                                obj = new Gson().fromJson(results.getJSONObject(i).toString(), clazz);

                                INSTANCE.mResults.add(obj);

                            }

            }

        } else {

           INSTANCE.mStatusCode = StatusCode.Unknown;
        }


        } catch (Exception e){

            throw new InvalidParameterException();
        }

        return INSTANCE;
    }



    public <T extends List> T pullout(){

        return (T) mResults;

    }




}
