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

    @Column(name = "LEVEL")
    private int level;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
