package com.roads.optimalservice.model.direction;

public class Point {

    private double lat;
    private double lon;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Point{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
