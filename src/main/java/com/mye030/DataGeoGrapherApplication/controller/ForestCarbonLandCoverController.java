package com.mye030.DataGeoGrapherApplication.controller;

import com.mye030.DataGeoGrapherApplication.service.ForestCarbonLandCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class ForestCarbonLandCoverController {

    @Autowired
    private ForestCarbonLandCoverService testService;

    @Autowired
    public ForestCarbonLandCoverController(){}

}
