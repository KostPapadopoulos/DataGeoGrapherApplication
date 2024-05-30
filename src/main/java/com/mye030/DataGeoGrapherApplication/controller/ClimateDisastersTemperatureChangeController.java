package com.mye030.DataGeoGrapherApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.mye030.DataGeoGrapherApplication.service.ClimateDisastersTemperatureChangeService;


@Controller
public class ClimateDisastersTemperatureChangeController {

    @Autowired
    private ClimateDisastersTemperatureChangeService testService;

    @Autowired
    public ClimateDisastersTemperatureChangeController(){

    }
}
