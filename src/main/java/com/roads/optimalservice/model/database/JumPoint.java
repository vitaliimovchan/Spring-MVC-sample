package com.roads.optimalservice.model.database;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "motionPoint")
public class JumPoint {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "jump",nullable = false)
    private Float jump;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    public void setId(Long id) {
        this.id = id;
    }

    public void setJump(Float jump) {
        this.jump = jump;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public Float getJump() {
        return jump;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "JumPoint{" +
                "id=" + id +
                ", jump=" + jump +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
