package com.dnocode.google.apis.commons.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by dino on 15/03/15.
 */
public class Location implements Serializable {

    @Expose
    public double lat;
    @Expose
    public double lng;

    }
