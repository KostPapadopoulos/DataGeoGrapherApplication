package com.mye030.DataGeoGrapherApplication.service;

import com.mye030.DataGeoGrapherApplication.dao.CountryDAO;
import com.mye030.DataGeoGrapherApplication.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryDAO countryDAO;

    public CountryServiceImpl(){
        super();
    }


    @Override
    public Country requestedCountry(String displayName) {
        return countryDAO.findByDisplayName(displayName);
    }


}
