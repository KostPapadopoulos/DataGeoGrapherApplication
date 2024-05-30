package com.mye030.DataGeoGrapherApplication.dao;

import com.mye030.DataGeoGrapherApplication.model.ForestCarbonLandCover;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForestCarbonLandCoverDAO extends JpaRepository<ForestCarbonLandCover, Integer> {
    public List<ForestCarbonLandCover> findByisoCode(int iso_code);

}
