package ru.bugmakers.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ivan
 */
@Entity
@Table(name = "POLYLINE")
public class PolyLine {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    @JoinColumn(name = "POINTS")
    private List<Point> points;

    @Column(name = "LEVEL")
    private int level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
