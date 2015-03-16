
package com.dnocode.google.apis.commons.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Viewport implements Serializable {

    public Northeast northeast;
    public Southwest southwest;
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
