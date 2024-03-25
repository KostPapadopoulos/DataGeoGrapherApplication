package com.mye030.DataGeoGrapherApplication.model;

import javax.persistence.*;

@Entity
@Table(name = "forest_carbon_land_cover")
public class ForestCarbonLandCover {

    @Id
    @Column(name = "f_id", unique = true)
    private Integer fId;

    //@ManyToOne
    @JoinColumn(name = "iso_code",referencedColumnName = "iso_code")
    private Integer isoCode;

    @Column(name = "year_")
    private Integer year_;

    @Column(name = "carbon_stocks_in_forests")
    private Float carbonStocksInForests;

    @Column(name = "forest_area")
    private Float forestArea;

    @Column(name = "index_of_carbon_stocks_in_forests")
    private Float indexOfCarbonStocksInForests;

    @Column(name = "index_of_forest_extent")
    private Float indexOfForestExtent;

    @Column(name = "land_area")
    private Float landArea;

    @Column(name = "share_of_forest_area")
    private Float shareOfForestArea;

    @Column(name = "artificial_surfaces")
    private Float artificialSurfaces;

    @Column(name = "climate_altering_land_cover_index")
    private Float climateAlteringLandCoverIndex;

    @Column(name = "grassland")
    private Float grassland;

    @Column(name = "herbaceous_crops")
    private Float herbaceousCrops;

    @Column(name = "inland_water_bodies")
    private Float inlandWaterBodies;

    @Column(name = "mangroves")
    private Float mangroves;

    @Column(name = "permanent_snow_and_glaciers")
    private Float permanentSnowAndGlaciers;

    @Column(name = "shrub_covered_areas")
    private Float shrubCoveredAreas;

    @Column(name = "shrubs_and_or_herbaceous_vegetation")
    private Float shrubsAndOrHerbaceousVegetation;

    @Column(name = "sparsely_natural_vegetated_areas")
    private Float sparselyNaturalVegetatedAreas;

    @Column(name = "terrestrial_barren_land")
    private Float terrestrialBarrenLand;

    @Column(name = "total_land_cover")
    private Float totalLandCover;

    @Column(name = "tree_covered_areas")
    private Float treeCoveredAreas;

    @Column(name = "woody_crops")
    private Float woodyCrops;

    public Integer getfId() {
        return fId;
    }

    public Integer getIsoCode() {
        return isoCode;
    }

    public Integer getYear_() {
        return year_;
    }

    public Float getCarbonStocksInForests() {
        return carbonStocksInForests;
    }

    public Float getForestArea() {
        return forestArea;
    }

    public Float getIndexOfCarbonStocksInForests() {
        return indexOfCarbonStocksInForests;
    }

    public Float getIndexOfForestExtent() {
        return indexOfForestExtent;
    }

    public Float getLandArea() {
        return landArea;
    }

    public Float getShareOfForestArea() {
        return shareOfForestArea;
    }

    public Float getArtificialSurfaces() {
        return artificialSurfaces;
    }

    public Float getClimateAlteringLandCoverIndex() {
        return climateAlteringLandCoverIndex;
    }

    public Float getGrassland() {
        return grassland;
    }

    public Float getHerbaceousCrops() {
        return herbaceousCrops;
    }

    public Float getInlandWaterBodies() {
        return inlandWaterBodies;
    }

    public Float getMangroves() {
        return mangroves;
    }

    public Float getPermanentSnowAndGlaciers() {
        return permanentSnowAndGlaciers;
    }

    public Float getShrubCoveredAreas() {
        return shrubCoveredAreas;
    }

    public Float getShrubsAndOrHerbaceousVegetation() {
        return shrubsAndOrHerbaceousVegetation;
    }

    public Float getSparselyNaturalVegetatedAreas() {
        return sparselyNaturalVegetatedAreas;
    }

    public Float getTerrestrialBarrenLand() {
        return terrestrialBarrenLand;
    }

    public Float getTotalLandCover() {
        return totalLandCover;
    }

    public Float getTreeCoveredAreas() {
        return treeCoveredAreas;
    }

    public Float getWoodyCrops() {
        return woodyCrops;
    }
}
