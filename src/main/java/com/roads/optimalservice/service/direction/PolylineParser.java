package com.roads.optimalservice.service.direction;

import com.google.maps.internal.PolylineEncoding;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class PolylineParser {

    public List<List<LatLng>> parse(DirectionsResult result){
        List<List<LatLng>> polylineList = new ArrayList<List<LatLng>>();

        for (DirectionsRoute route: result.routes){

            polylineList.add(
                    route.overviewPolyline.decodePath());
            break;
        }
        return polylineList;
    }
}
