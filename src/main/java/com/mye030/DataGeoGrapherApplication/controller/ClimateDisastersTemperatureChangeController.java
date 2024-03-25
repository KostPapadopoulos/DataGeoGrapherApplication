package com.mye030.DataGeoGrapherApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mye030.DataGeoGrapherApplication.service.ClimateDisastersTemperatureChangeService;

import java.util.HashMap;
import java.util.TreeMap;

@Controller
public class ClimateDisastersTemperatureChangeController {

    @Autowired
    private ClimateDisastersTemperatureChangeService testService;

    @Autowired
    public ClimateDisastersTemperatureChangeController(){

    }


    /*@RequestMapping("/")
    public String getMenu(){
        TreeMap<Integer,Object> test = testService.requestedClimateTemperatureMetric(4,1961,1970,"Drought");
        System.out.println(test);
        return "main-menu";
    }

     */
}
