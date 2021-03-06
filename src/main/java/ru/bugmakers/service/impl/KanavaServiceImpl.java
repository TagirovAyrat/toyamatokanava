package ru.bugmakers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bugmakers.da.PointRepo;
import ru.bugmakers.dto.ReturnToConsole;
import ru.bugmakers.entity.Point;
import ru.bugmakers.service.KanavaService;
import ru.bugmakers.utils.KmlUtil;

import java.util.Comparator;
import java.util.List;

/**
 * Created by ivan
 */
@Service
public class KanavaServiceImpl implements KanavaService {
    private PointRepo pointRepo;

    @Autowired
    public void setPointRepo(PointRepo pointRepo) {
        this.pointRepo = pointRepo;
    }

    @Transactional
    public Point savePoint(String lat, String lng, String value) {
        Point point = new Point(lng, lat, value);
        return pointRepo.save(point);
    }

    public List<Point> getAllPoints() {
        return pointRepo.findAll();
    }

    public String getKml() {

        List<Point> points = getAllPoints();
        points.sort(Comparator.comparingLong(Point::getId));
        String fileName = KmlUtil.createKml(points);
        return fileName;
    }
}
