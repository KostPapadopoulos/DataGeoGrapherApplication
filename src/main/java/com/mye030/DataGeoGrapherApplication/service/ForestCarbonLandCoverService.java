package com.mye030.DataGeoGrapherApplication.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;

@Service
public interface ForestCarbonLandCoverService {

    public TreeMap<Integer,Object> requestedForestLandMetric(int isoCode, int startYear, int endYear, String selectedMetric);

    public List<String> getMetrics();
}
