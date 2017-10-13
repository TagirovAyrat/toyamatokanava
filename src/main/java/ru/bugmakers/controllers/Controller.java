package ru.bugmakers.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bugmakers.dto.ReturnToMobile;

/**
 * Created by ivan
 */
@RestController
@RequestMapping("/")
public class Controller {
    @RequestMapping(method = RequestMethod.GET, value = "/getquality")
    public @ResponseBody
    ReturnToMobile getRoadsQuality() {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/setquality", params = {"lat", "lng", "value"})
    public @ResponseBody
    ReturnToMobile setRoadsQuality(@RequestParam("lat") String lat, @RequestParam("lng") String lng, @RequestParam("value") String value) {
        return null;
    }

}
