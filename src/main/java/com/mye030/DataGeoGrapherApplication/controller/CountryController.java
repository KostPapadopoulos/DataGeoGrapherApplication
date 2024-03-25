package com.mye030.DataGeoGrapherApplication.controller;

import com.mye030.DataGeoGrapherApplication.model.Country;
import com.mye030.DataGeoGrapherApplication.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CountryController {

    @Autowired
    private CountryService testCountry;

    @Autowired
    public CountryController(){

    }

     /*@RequestMapping("/")
    public String getMenu(){
        Country test = testCountry.requestedCountry("Germany");
        System.out.println(test.getOfficialName());
        return "main-menu";
    }

      */
}
