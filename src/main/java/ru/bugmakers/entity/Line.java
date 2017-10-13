package ru.bugmakers.entity;

import javax.persistence.*;

/**
 * Created by ivan
 */
@Entity
@Table(name = "LINE")
public class Line {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "FIRST_POINT")
    private Point fPoint;

    @OneToOne
    @JoinColumn(name = "SECOND_POINT")
    private Point sPoint;

    @Column(name = "LEVEL")
    private int level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getfPoint() {
        return fPoint;
    }

    public void setfPoint(Point fPoint) {
        this.fPoint = fPoint;
    }

    public Point getsPoint() {
        return sPoint;
    }

    public void setsPoint(Point sPoint) {
        this.sPoint = sPoint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
