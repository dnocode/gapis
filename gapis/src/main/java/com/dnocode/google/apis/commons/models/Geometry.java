
package com.dnocode.google.apis.commons.models;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Geometry implements Serializable{

    public Location location;
    public String locationType;
    public Viewport viewport;
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();




}
