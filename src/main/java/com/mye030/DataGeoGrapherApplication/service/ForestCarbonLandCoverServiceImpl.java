package com.mye030.DataGeoGrapherApplication.service;


import com.mye030.DataGeoGrapherApplication.dao.ForestCarbonLandCoverDAO;
import com.mye030.DataGeoGrapherApplication.model.ClimateDisastersTemperatureChange;
import com.mye030.DataGeoGrapherApplication.model.ForestCarbonLandCover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ForestCarbonLandCoverServiceImpl implements ForestCarbonLandCoverService{

    @Autowired
    ForestCarbonLandCoverDAO forestCarbonLandCoverDAO;

    public ForestCarbonLandCoverServiceImpl(){
        super();
    }

    @Override
    public TreeMap<Integer, Object> requestedForestLandMetric(int isoCode, int startYear, int endYear, String selectedMetric) {
        List<ForestCarbonLandCover> countryMetrics = forestCarbonLandCoverDAO.findByisoCode(isoCode);
        TreeMap<Integer,Object> finalData = new TreeMap<>();
        for (int i = 0; i < countryMetrics.size(); i++) {

            if (countryMetrics.get(i).getYear_() >= startYear && countryMetrics.get(i).getYear_() <= endYear) {
                switch (selectedMetric) {
                    case "Carbon Stocks In Forests" -> {
                        Float carbonStocks = countryMetrics.get(i).getCarbonStocksInForests();
                        finalData.put(countryMetrics.get(i).getYear_(), carbonStocks);
                    }
                    case "Forest Area" -> {
                        Float forestArea = countryMetrics.get(i).getForestArea();
                        finalData.put(countryMetrics.get(i).getYear_(), forestArea);
                    }
                    case "Index Of Carbon Stocks In Forests" -> {
                        Float indexOfCarbonStocksInForests = countryMetrics.get(i).getIndexOfCarbonStocksInForests();
                        finalData.put(countryMetrics.get(i).getYear_(), indexOfCarbonStocksInForests);
                    }
                    case "Index Of Forest Extent" -> {
                        Float indexOfForestExtent = countryMetrics.get(i).getIndexOfForestExtent();
                        finalData.put(countryMetrics.get(i).getYear_(), indexOfForestExtent);
                    }
                    case "Land Area" -> {
                        Float landArea = countryMetrics.get(i).getLandArea();
                        finalData.put(countryMetrics.get(i).getYear_(), landArea);
                    }
                    case "Share Of Forest Area" -> {
                        Float shareOfForestArea = countryMetrics.get(i).getShareOfForestArea();
                        finalData.put(countryMetrics.get(i).getYear_(), shareOfForestArea);
                    }
                    case "Artificial Surfaces" -> {
                        Float artificialSurfaces = countryMetrics.get(i).getArtificialSurfaces();
                        finalData.put(countryMetrics.get(i).getYear_(), artificialSurfaces);
                    }
                    case "Climate Altering Land Cover Index" -> {
                        Float climateAlteringLandCoverIndex = countryMetrics.get(i).getClimateAlteringLandCoverIndex();
                        finalData.put(countryMetrics.get(i).getYear_(), climateAlteringLandCoverIndex);
                    }
                    case "Grassland" -> {
                        Float grassland = countryMetrics.get(i).getGrassland();
                        finalData.put(countryMetrics.get(i).getYear_(), grassland);
                    }
                    case "Herbaceous Crops" -> {
                        Float herbaceousCrops = countryMetrics.get(i).getHerbaceousCrops();
                        finalData.put(countryMetrics.get(i).getYear_(), herbaceousCrops);
                    }
                    case "Inland Water Bodies" -> {
                        Float inlandWaterBodies = countryMetrics.get(i).getInlandWaterBodies();
                        finalData.put(countryMetrics.get(i).getYear_(), inlandWaterBodies);
                    }
                    case "Mangroves" -> {
                        Float mangroves = countryMetrics.get(i).getMangroves();
                        finalData.put(countryMetrics.get(i).getYear_(), mangroves);
                    }
                    case "Permanent Snow And Glaciers" -> {
                        Float permanentSnowAndGlaciers = countryMetrics.get(i).getPermanentSnowAndGlaciers();
                        finalData.put(countryMetrics.get(i).getYear_(), permanentSnowAndGlaciers);
                    }
                    case "Shrub Covered Areas" -> {
                        Float shrubCoveredAreas = countryMetrics.get(i).getShrubCoveredAreas();
                        finalData.put(countryMetrics.get(i).getYear_(), shrubCoveredAreas);
                    }
                    case "Shrubs And Or Herbaceous Vegetation" -> {
                        Float shrubsAndOrHerbaceousVegetation = countryMetrics.get(i).getShrubsAndOrHerbaceousVegetation();
                        finalData.put(countryMetrics.get(i).getYear_(), shrubsAndOrHerbaceousVegetation);
                    }
                    case "Sparsely Natural Vegetated Areas" -> {
                        Float sparselyNaturalVegetatedAreas = countryMetrics.get(i).getSparselyNaturalVegetatedAreas();
                        finalData.put(countryMetrics.get(i).getYear_(), sparselyNaturalVegetatedAreas);
                    }
                    case "Terrestrial Barren Land" -> {
                        Float terrestrialBarrenLand = countryMetrics.get(i).getTerrestrialBarrenLand();
                        finalData.put(countryMetrics.get(i).getYear_(), terrestrialBarrenLand);
                    }
                    case "Total Land Cover" -> {
                        Float totalLandCover = countryMetrics.get(i).getTotalLandCover();
                        finalData.put(countryMetrics.get(i).getYear_(), totalLandCover);
                    }
                    case "Tree Covered Areas" -> {
                        Float treeCoveredAreas = countryMetrics.get(i).getTreeCoveredAreas();
                        finalData.put(countryMetrics.get(i).getYear_(), treeCoveredAreas);
                    }
                    case "Woody Crops" -> {
                        Float woodyCrops = countryMetrics.get(i).getWoodyCrops();
                        finalData.put(countryMetrics.get(i).getYear_(), woodyCrops);
                    }
                }
            }
        }

        return finalData;
    }

    @Override
    public List<String> getMetrics() {
        List<String> forestCarbonLandCoverMetrics = ForestCarbonLandCover.getAttributeNames(ForestCarbonLandCover.class);

        Set<String> uniqueMetrics = new HashSet<>();

        uniqueMetrics.addAll(forestCarbonLandCoverMetrics);
        List<String> forestCarbonLandCoverMetricsList = filterNonGraphableAttributes(uniqueMetrics);

        return forestCarbonLandCoverMetricsList;
    }

    public List<String> filterNonGraphableAttributes(Set<String> badMetrics){
        badMetrics.remove("year_");
        badMetrics.remove("fId");
        badMetrics.remove("isoCode");
        List<String> fixedMetrics = new ArrayList<>(badMetrics);

        return fixedMetrics;

    }
}
