package ru.bugmakers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bugmakers.dto.ReturnToConsole;
import ru.bugmakers.dto.ReturnToMobile;
import ru.bugmakers.entity.Point;
import ru.bugmakers.service.impl.KanavaServiceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ivan
 */
@RestController
@RequestMapping("/")
public class Controller {

    KanavaServiceImpl kanavaService;
    @Autowired
    public void setKanavaService(KanavaServiceImpl kanavaService) {
        this.kanavaService = kanavaService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getquality")
    public @ResponseBody
    List<Point> getRoadsQuality() {
        List<Point> points = kanavaService.getAllPoints();
        points.sort(Comparator.comparingLong(Point::getId));
        return points;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/setquality", params = {"lat", "lng", "value"})
    public @ResponseBody
    ResponseEntity setRoadsQuality(@RequestParam("lat") String lat, @RequestParam("lng") String lng, @RequestParam("value") String value) {
        kanavaService.savePoint(lat, lng, value);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getkml")
    public @ResponseBody
    ReturnToConsole getKml() {
        return kanavaService.getKml();
    }

}
