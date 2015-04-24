
package com.dnocode.google.apis.commons.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AddressComponent implements Serializable{

    @SerializedName("long_name")
    public String longName;
    @SerializedName("short_name")
    public String shortName;
    public List<String> types = new ArrayList<String>();
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
