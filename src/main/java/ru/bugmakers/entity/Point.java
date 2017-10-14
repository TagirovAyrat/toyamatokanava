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

    @Column(name = "LNG")
    private String lng;

    private String level;

    public Point(String lng, String lat, String level) {
        this.lng = lng;
        this.lat = lat;
        this.level = level;
    }

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

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
