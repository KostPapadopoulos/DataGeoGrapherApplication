package com.mye030.DataGeoGrapherApplication.controller;

import com.mye030.DataGeoGrapherApplication.service.ForestCarbonLandCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.TreeMap;

@Controller
public class ForestCarbonLandCoverController {

    @Autowired
    private ForestCarbonLandCoverService testService;

    @Autowired
    public ForestCarbonLandCoverController(){}

    @RequestMapping("/")
    public String getMenu(){
        TreeMap<Integer,Object> test = testService.requestedForestLandMetric(4,1992,1996,"Forest Area");
        System.out.println(test);
        return "main-menu";
    }
}
