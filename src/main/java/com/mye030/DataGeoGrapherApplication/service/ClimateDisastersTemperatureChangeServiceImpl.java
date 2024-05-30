package com.mye030.DataGeoGrapherApplication.service;

import com.mye030.DataGeoGrapherApplication.dao.ClimateDisastersTemperatureChangeDAO;
import com.mye030.DataGeoGrapherApplication.model.ClimateDisastersTemperatureChange;
import com.mye030.DataGeoGrapherApplication.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClimateDisastersTemperatureChangeServiceImpl implements ClimateDisastersTemperatureChangeService{

    @Autowired
    ClimateDisastersTemperatureChangeDAO climateDisastersTemperatureChangeDAO;

    public ClimateDisastersTemperatureChangeServiceImpl(){
        super();
    }

    @Override
    public TreeMap<Integer, Object> requestedClimateTemperatureMetric(int isoCode, int startYear, int endYear, String selectedMetric) {

        List<ClimateDisastersTemperatureChange> countryMetrics = climateDisastersTemperatureChangeDAO.findByisoCode(isoCode);
        TreeMap<Integer,Object> finalData = new TreeMap<>();
        for (int i = 0; i < countryMetrics.size(); i++) {

            if (countryMetrics.get(i).getYear_() >= startYear && countryMetrics.get(i).getYear_() <= endYear) {
                switch (selectedMetric) {
                    case "Temperature Change" -> {
                        Float tempChange = countryMetrics.get(i).getTemperature_change();
                        finalData.put(countryMetrics.get(i).getYear_(), tempChange);
                    }
                    case "Drought" -> {
                        Integer drought = countryMetrics.get(i).getDrought();
                        finalData.put(countryMetrics.get(i).getYear_(), drought);
                    }
                    case "Extreme Temperature" -> {
                        Integer extremeTemperature = countryMetrics.get(i).getExtreme_temperature();
                        finalData.put(countryMetrics.get(i).getYear_(), extremeTemperature);
                    }
                    case "Flood" -> {
                        Integer flood = countryMetrics.get(i).getFlood();
                        finalData.put(countryMetrics.get(i).getYear_(), flood);
                    }
                    case "Landslide" -> {
                        Integer landslide = countryMetrics.get(i).getLandslide();
                        finalData.put(countryMetrics.get(i).getYear_(), landslide);
                    }
                    case "Storm" -> {
                        Integer storm = countryMetrics.get(i).getStorm();
                        finalData.put(countryMetrics.get(i).getYear_(), storm);
                    }
                    case "Total Disasters" -> {
                        Integer totalDisasters = countryMetrics.get(i).getTotal_disasters();
                        finalData.put(countryMetrics.get(i).getYear_(), totalDisasters);
                    }
                    case "Wildfire" -> {
                        Integer wildfire = countryMetrics.get(i).getWildfire();
                        finalData.put(countryMetrics.get(i).getYear_(), wildfire);
                    }
                }
            }
        }
        return finalData;
    }

    @Override
    public List<String> getMetrics() {
        List<String> climateMetrics = ClimateDisastersTemperatureChange.getAttributeNames(ClimateDisastersTemperatureChange.class);

        Set<String> uniqueMetrics = new HashSet<>();

        uniqueMetrics.addAll(climateMetrics);


        List<String> climateMetricsList = filterNonGraphableAttributes(uniqueMetrics);


        return climateMetricsList;
    }

    public List<String> filterNonGraphableAttributes(Set<String> badMetrics) {
        badMetrics.remove("isoCode");
        badMetrics.remove("year_");
        badMetrics.remove("c_id");
        List<String> fixedMetrics = new ArrayList<>(badMetrics);

        return fixedMetrics;

    }

}
