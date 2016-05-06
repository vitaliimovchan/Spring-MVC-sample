package com.roads.optimalservice.service.direction;

import com.google.maps.model.LatLng;
import com.roads.optimalservice.model.direction.Point;
import com.roads.optimalservice.repository.JumPointRepository;

import java.util.ArrayList;
import java.util.List;

public class OptimiseDirectionApi {

    public List<Point> optimise(List<List<LatLng>> routeList, JumPointRepository repository){

        /*
         * Step 1: get polyline points - ok
         * Step 2: get simple line - two points from polyline
         * Step 3: calculate area witch covers this points
         * Step 4: find points in repository
         * Step 5: calculate middle jump
         * Step 6: return route with min middle jump
         */

        List<Float> summary_jump_list = new ArrayList<Float>();
        // Step 1
        for (List<LatLng> list: routeList){
            for (int i=0; i < list.size() - 2; i++){
                // Step 2
                LatLng st = list.get(i);
                LatLng en = list.get(i+1);
                //

            }
        }

        return new ArrayList<Point>();
    }
}
