package com.mye030.DataGeoGrapherApplication.service;

import com.mye030.DataGeoGrapherApplication.dao.CountryDAO;
import com.mye030.DataGeoGrapherApplication.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryDAO countryDAO;

    public CountryServiceImpl(){
        super();
    }


    @Override
    public List<Integer> requestedCountry(List<String> displayNames) {
        List<Country> countries = countryDAO.findAll();
        List<Integer> requestedIsoCodes = new ArrayList<>();
        for (int i = 0; i < countries.size(); i++) {
            if (displayNames.contains(countries.get(i).getDisplayName())){
                requestedIsoCodes.add(countries.get(i).getIsoCode());
            }
        }
        return requestedIsoCodes;
    }


    @Override
    public HashMap<Integer, String> getMapOfCountries() {
        List<Country> countries = countryDAO.findAll();
        HashMap<Integer, String> allCountries = new HashMap<>();
        for (int i = 0; i < countries.size(); i++) {
            allCountries.put(countries.get(i).getIsoCode(), countries.get(i).getDisplayName());
        }
        return allCountries;
    }

    @Override
    public List<String> getMetrics() {
        List<String> countryMetrics = Country.getAttributeNames(Country.class);

        Set<String> allMetrics = new HashSet<>();
        allMetrics.addAll(countryMetrics);
        List<String> countryMetricsList = filterNonGraphableAttributes(allMetrics);

        return countryMetricsList;
    }

    @Override
    public TreeMap<Integer, Object> requestedCountryMetric(int isoCode, String metricName) {
        List<Country> countries = countryDAO.findAll();
        TreeMap<Integer, Object> metricValueMap = new TreeMap<>();
        int metricValue = 0;
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getIsoCode() == isoCode ){
                if (metricName.equals("Population")){
                    metricValue = countries.get(i).getPopulation();
                    metricValueMap.put(metricValue,0);
                } else if (metricName.equals("Area Sq Km")){
                    metricValue = countries.get(i).getAreaSqKm();
                    metricValueMap.put(metricValue,0);

                }
            }
        }
        return metricValueMap;

    }


    public List<String> filterNonGraphableAttributes(Set<String> badMetrics) {
        badMetrics.remove("isoCode");
        badMetrics.remove("iso");
        badMetrics.remove("iso3");
        badMetrics.remove("displayName");
        badMetrics.remove("fips");
        badMetrics.remove("officialName");
        badMetrics.remove("capital");
        badMetrics.remove("continent");
        badMetrics.remove("currencyCode");
        badMetrics.remove("currencyName");
        badMetrics.remove("phone");
        badMetrics.remove("regionCode");
        badMetrics.remove("regionName");
        badMetrics.remove("subregionCode");
        badMetrics.remove("subregionName");
        badMetrics.remove("intermediateRegionCode");
        badMetrics.remove("intermediateRegionName");
        badMetrics.remove("cStatus");
        badMetrics.remove("developedOrDeveloping");
        badMetrics.remove("sids");
        badMetrics.remove("ldc");
        badMetrics.remove("lldc");
        List<String> fixedMetrics = new ArrayList<>(badMetrics);

        return fixedMetrics;

    }
}
