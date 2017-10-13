package ru.bugmakers.entity;

import javax.persistence.*;

/**
 * Created by ivan
 */
@Entity
@Table(name = "PIT")
public class Pit {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "PIT_POINT")
    private Point pitPoint;

    @Column(name = "LEVEL")
    private int level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getPitPoint() {
        return pitPoint;
    }

    public void setPitPoint(Point pitPoint) {
        this.pitPoint = pitPoint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
