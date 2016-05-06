package com.roads.optimalservice.controller;

import com.google.maps.model.LatLng;
import com.roads.optimalservice.model.database.JumPoint;
import com.roads.optimalservice.model.direction.ArrivalDepartureLocations;
import com.roads.optimalservice.model.direction.Point;
import com.roads.optimalservice.service.RoadsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RoadsController {

    @Autowired
    private RoadsServiceImpl roadsServiceImpl;

    /*** Welcome Page ***/
    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public @ResponseBody ModelAndView hello() {
        ModelAndView mav = new ModelAndView("welcome");
        mav.addObject("message", "Hello World!");
//        return mav;
        return new ModelAndView("welcome");
    }

    /*** Save new point from Android - POST ***/
    @RequestMapping(value = "api/savepoint", method = RequestMethod.POST)
    public @ResponseBody JumPoint savePoint(@RequestBody JumPoint jumPoint){
        return roadsServiceImpl.savePoint(jumPoint);
    }

    /*** Get optimal direction for Android - POST ***/
    @RequestMapping(value = "api/directions", method = RequestMethod.POST)
    public @ResponseBody List<List<LatLng>> findDirection(@RequestBody ArrivalDepartureLocations locations){
        return roadsServiceImpl.findDirection(locations);
    }

    /*** Example for JumPoint - GET ***/
    @RequestMapping(value = "api/example/point_body",method = RequestMethod.GET)
    public @ResponseBody JumPoint getMotionPoint(){
        JumPoint jumPoint = new JumPoint();
        jumPoint.setJump(4F);
        jumPoint.setLatitude(25.11496);
        jumPoint.setLongitude(69.11455);
        return jumPoint;
    }

    /*** Example for ArrivalDepartureLocations - GET ***/
    @RequestMapping(value = "api/example/directions_body",method = RequestMethod.GET)
    public @ResponseBody
    ArrivalDepartureLocations getArrivalDepartureLocations(){
        /* Полтава - Харьков */
        Point arrival = new Point();
        arrival.setLat(49.574327);
        arrival.setLon(34.536176);

        Point departure = new Point();
        departure.setLat(49.988277);
        departure.setLon(36.232662);

        ArrivalDepartureLocations locations = new ArrivalDepartureLocations();
        locations.setArrival(arrival);
        locations.setDeparture(departure);

        return locations;
    }
}
