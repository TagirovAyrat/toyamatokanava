package ru.bugmakers.dto;

import ru.bugmakers.entity.Point;

import java.util.List;

/**
 * Created by Ayrat on 13.10.2017.
 */
public class ReturnToMobile {

    private List<Point> points;

    public ReturnToMobile() {
    }

    public ReturnToMobile(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
