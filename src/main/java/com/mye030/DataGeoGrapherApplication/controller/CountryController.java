package com.mye030.DataGeoGrapherApplication.controller;

import com.mye030.DataGeoGrapherApplication.model.ChartData;
import com.mye030.DataGeoGrapherApplication.model.Country;
import com.mye030.DataGeoGrapherApplication.service.ClimateDisastersTemperatureChangeService;
import com.mye030.DataGeoGrapherApplication.service.CountryService;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mye030.DataGeoGrapherApplication.service.ForestCarbonLandCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private ClimateDisastersTemperatureChangeService climateDisastersTemperatureChangeService;

    @Autowired
    private ForestCarbonLandCoverService forestCarbonLandCoverService;

    private static final Pattern CAMEL_CASE_PATTERN = Pattern.compile("([a-z])([A-Z])");

    private static final Pattern SNAKE_CASE_PATTERN = Pattern.compile("_");

    @Autowired
    public CountryController(){

    }

    @RequestMapping("api/get-countries")
    public HashMap<Integer, String> getCountries(){

        HashMap<Integer, String> allCountries = countryService.getMapOfCountries();
        return allCountries;
    }

    @RequestMapping("api/get-all-metrics")
    public List<String> getAllMetrics(){

        List<String> countryMetrics = countryService.getMetrics();
        List<String> climateMetrics = climateDisastersTemperatureChangeService.getMetrics();
        List<String> forestMetrics = forestCarbonLandCoverService.getMetrics();
        List<String> allMetrics = new ArrayList<>();

        allMetrics.addAll(countryMetrics);
        allMetrics.addAll(climateMetrics);
        allMetrics.addAll(forestMetrics);

        List<String> finalList = new ArrayList<>();
        for (String metric : allMetrics) {
            finalList.add(formatAttributeName(metric));
        }

        return finalList;
    }

    public static String formatAttributeName(String attributeName) {
        // Replace camelCase boundaries with a space
        Matcher matcher = CAMEL_CASE_PATTERN.matcher(attributeName);
        String formatted = matcher.replaceAll("$1 $2");

        formatted = SNAKE_CASE_PATTERN.matcher(formatted).replaceAll(" ");

        // Capitalize the first letter of each word
        String[] words = formatted.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                builder.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return builder.toString().trim();
    }

    @PostMapping("api/get-graph-values")
    public HashMap<String,HashMap<String, TreeMap<Integer, Object>>> getGraphValues(@RequestBody ChartData chartData){

            List<String> countries = chartData.getCountries();
            List<String> metrics = chartData.getMetrics();
            int startYear = chartData.getStartYear();
            int endYear = chartData.getEndYear();

            List<Integer> isoCodes = countryService.requestedCountry(countries);
            HashMap<String,HashMap<String, TreeMap<Integer, Object>>> finalData = new HashMap<>();

            TreeMap<Integer, Object> foundData = new TreeMap<>();
            for (int i = 0; i < isoCodes.size(); i++) {
                HashMap<String, TreeMap<Integer, Object>> proccessedData = new HashMap<>();
                for (String metric : metrics) {
                    foundData = null;
                    if (metric.equals("Temperature Change") || metric.equals("Drought") || metric.equals("Extreme Temperature") || metric.equals("Flood") || metric.equals("Landslide") || metric.equals("Storm") || metric.equals("Total Disasters") || metric.equals("Wildfire")) {
                        foundData = climateDisastersTemperatureChangeService.requestedClimateTemperatureMetric(isoCodes.get(i), startYear, endYear, metric);
                    } else if (metric.equals("Population") || metric.equals("Area Sq Km")){
                        foundData = countryService.requestedCountryMetric(isoCodes.get(i), metric);
                    }
                    else {
                        foundData = forestCarbonLandCoverService.requestedForestLandMetric(isoCodes.get(i), startYear, endYear, metric);
                    }
                    proccessedData.put(metric, foundData);
                }
                finalData.put(countries.get(i), proccessedData);
            }
            return finalData;
    }


}
