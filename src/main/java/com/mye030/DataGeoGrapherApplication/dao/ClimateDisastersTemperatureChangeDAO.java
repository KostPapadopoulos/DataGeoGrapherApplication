package com.mye030.DataGeoGrapherApplication.dao;

import com.mye030.DataGeoGrapherApplication.model.ClimateDisastersTemperatureChange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClimateDisastersTemperatureChangeDAO extends JpaRepository<ClimateDisastersTemperatureChange, Integer> {

    public List<ClimateDisastersTemperatureChange> findByisoCode(int isoCode);

}

