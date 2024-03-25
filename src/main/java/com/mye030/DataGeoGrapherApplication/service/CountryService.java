package com.mye030.DataGeoGrapherApplication.service;

import com.mye030.DataGeoGrapherApplication.model.Country;
import org.springframework.stereotype.Service;

@Service
public interface CountryService {

    public Country requestedCountry(String displayName);
}
