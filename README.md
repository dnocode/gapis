# GAPIS

Its android library for using of   google api services.
was forked from  https://github.com/igor-korotenko/PlaceAutocompleteLibrary 
thanks to 
https://github.com/igor-korotenko

right now it includes:

* Google places API https://developers.google.com/places/
  
    1. Place Searches return a list of Places based on a user's location or search string.
    2. Place Details requests return more detailed information about a specific Place, including user reviews.
    3. Place Add allow you to supplement the data in Google's Places database with data from your application.
    4. Place Autocomplete can be used to automatically fill in the name and/or address of a place as you type.
    5. Query Autocomplete can be used to provide a query prediction service for text-based geographic searches, by returning suggested queries as you type.

* Google geocoding API Request https://developers.google.com/maps/documentation/geocoding/
    1. reverse geocoding

## REQUIRED

To use the library is necessary to enter in the manifest the google server key as below.

 *<meta-data android:name="com.dnocode.google.apis.key" android:value="@string/KEY" />*

## CODE EXAMPLE
 
        G.api(getContext());
        
        /**query prepare**/
        
        AutoCompleteSearchQuery qry=new AutoCompleteSearchQuery();
        
        qry.setRadius(500);
        
        qry.setTypes(new String[]{"address"});
        
        qry.setInput("savon");

            /**get place with autocomplete api**/
            List<Place> placesList=G.api().places().getPredictions(qry);
            
            Place place=placesList.get(0);
            
            /**get place details**/
            G.api().places().getDetails(place.placeId); 
            
            
             Location location=new Location("dummyprovider");
                    location.setLatitude(45.450532);
                    location.setLongitude(9.157225);
                    
                    
                      List<PlaceReversed> list= G.api().geocoder().reverseByLocation(location);




that's all i hope gonna  be useful .

## Contributors

https://github.com/igor-korotenko

## License



Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.