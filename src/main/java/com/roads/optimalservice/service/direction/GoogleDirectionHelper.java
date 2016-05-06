package com.roads.optimalservice.service.direction;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.LatLng;

public class GoogleDirectionHelper {

    private static final String SERVER_KEY = "AIzaSyBhuZKYbdkayoMxb_xTbC4MXaLjl2OLxrs";

    public DirectionsResult getDirectionResult(LatLng arrival, LatLng departure){
        GeoApiContext context = new GeoApiContext().setApiKey(SERVER_KEY);

        DirectionsApiRequest request = DirectionsApi.newRequest(context)
                .origin(arrival).destination(departure).alternatives(true);

        try{return request.await();
        }catch (Exception e){e.printStackTrace();return null;}
    }
}
