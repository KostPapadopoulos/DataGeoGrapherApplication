package com.mye030.DataGeoGrapherApplication.service;

import com.mye030.DataGeoGrapherApplication.model.Country;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

@Service
public interface CountryService {

    public List<Integer> requestedCountry(List<String> displayNames);

    public HashMap<Integer, String> getMapOfCountries();

    public List<String> getMetrics();

    public TreeMap<Integer, Object> requestedCountryMetric(int isoCode, String metricName);


}

