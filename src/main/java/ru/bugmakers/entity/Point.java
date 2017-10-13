package ru.bugmakers.entity;

import javax.persistence.*;

/**
 * Created by ivan
 */
@Entity
@Table(name = "POINT")
public class Point {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "LAT")
    private String lat;

    @Column(name = "LON")
    private String lon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
