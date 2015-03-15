package com.dnocode.google.apis.geocoding.enums;

/**
 * Created by dino on 12/03/15.
 */
public enum LocationType  {

    ROOFTOP,// restricts the results to addresses for which we have location information accurate down to street address precision.
    RANGE_INTERPOLATED,// restricts the results to those that reflect an approximation (usually on a road) interpolated between two precise points (such as intersections). An interpolated range generally indicates that rooftop geocodes are unavailable for a street address.
    GEOMETRIC_CENTER,// restricts the results to geometric centers of a location such as a polyline (for example, a street) or polygon (region).
    APPROXIMATE;// restricts the results to those that are characterized as approximate.
}
