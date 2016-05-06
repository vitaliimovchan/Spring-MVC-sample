package com.roads.optimalservice.model.direction;

public class ArrivalDepartureLocations {

    private Point arrival;
    private Point departure;

    public void setArrival(Point arrival) {
        this.arrival = arrival;
    }

    public void setDeparture(Point departure) {
        this.departure = departure;
    }

    public Point getArrival() {
        return arrival;
    }

    public Point getDeparture() {
        return departure;
    }

    @Override
    public String toString() {
        return "ArrivalDepartureLocations{" +
                "arrival=" + arrival +
                ", departure=" + departure +
                '}';
    }
}
