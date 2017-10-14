package ru.bugmakers.da;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bugmakers.entity.Point;

/**
 * Created by Ayrat on 14.10.2017.
 */
public interface PointRepo extends JpaRepository<Point, Integer> {
}
