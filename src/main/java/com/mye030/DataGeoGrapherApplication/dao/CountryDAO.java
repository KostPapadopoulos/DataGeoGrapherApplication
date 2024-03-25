package com.mye030.DataGeoGrapherApplication.dao;

import com.mye030.DataGeoGrapherApplication.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryDAO extends JpaRepository<Country, Integer> {

    public Country findByDisplayName(String displayName);


}
