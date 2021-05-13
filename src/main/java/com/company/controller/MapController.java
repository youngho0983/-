package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/map")
public class MapController {
    @RequestMapping(method = RequestMethod.GET)
    public String goMap(){
        System.out.println("go kakaoMap");
        return "/map/map";
    }
}
