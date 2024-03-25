package com.mye030.DataGeoGrapherApplication.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.TreeMap;

@Service
public interface ClimateDisastersTemperatureChangeService {

    public TreeMap<Integer,Object> requestedClimateTemperatureMetric(int isoCode, int startYear, int endYear, String selectedMetric);
}
