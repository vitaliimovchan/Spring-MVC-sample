package com.roads.optimalservice.service;

import com.google.maps.model.DirectionsResult;
import com.google.maps.model.LatLng;
import com.roads.optimalservice.model.database.JumPoint;
import com.roads.optimalservice.model.direction.ArrivalDepartureLocations;
import com.roads.optimalservice.model.direction.Point;
import com.roads.optimalservice.repository.JumPointRepository;
import com.roads.optimalservice.service.direction.GoogleDirectionHelper;
import com.roads.optimalservice.service.direction.OptimiseDirectionApi;
import com.roads.optimalservice.service.direction.PolylineParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoadsServiceImpl {

    @Autowired
    private JumPointRepository repository;

    public JumPoint savePoint(JumPoint jumPoint) {
        return repository.saveAndFlush(jumPoint);
    }

    public List<List<LatLng>> findDirection(ArrivalDepartureLocations points){
        /*
         * Step 1: get DirectionResult from GoogleApi
         */
        DirectionsResult result =  new GoogleDirectionHelper().getDirectionResult(
                new LatLng(points.getArrival().getLat(),points.getArrival().getLon()),
                new LatLng(points.getDeparture().getLat(),points.getDeparture().getLon()));

        /*
         * Step 2: parse DirectionResult & get polyline list for each route
         */
        List<List<LatLng>> polylineList = new PolylineParser().parse(result);

        /*
         * Step 3: get optimal route with database points
         */
//        List<Point> optimalRoute = new OptimiseDirectionApi().optimise(polylineList,repository);
//
//        return optimalRoute.toString();
        return polylineList;
    }
}
