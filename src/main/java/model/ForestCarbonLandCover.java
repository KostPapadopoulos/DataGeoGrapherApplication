package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "forest_carbon_land_cover")
public class ForestCarbonLandCover {

    @Column(name = "f_id")
    private int f_id;

    @Column(name = "iso_code")
    private int iso_code;

    @Column(name = "year_")
    private int year_;

    @Column(name = "carbon_stocks_in_forests")
    private float carbon_stocks_in_forests;

    @Column(name = "forest_area")
    private float forest_area;

    @Column(name = "index_of_carbon_stocks_in_forests")
    private float index_of_carbon_stocks_in_forests;

    @Column(name = "index_of_forest_extent")
    private float index_of_forest_extent;

    @Column(name = "land_area")
    private float land_area;

    @Column(name = "share_of_forest_area")
    private float share_of_forest_area;

    @Column(name = "artificial_surfaces")
    private float artificial_surfaces;

    @Column(name = "climate_altering_land_cover_index")
    private float climate_altering_land_cover_index;

    @Column(name = "grassland")
    private float grassland;

    @Column(name = "herbaceous_crops")
    private float herbaceous_crops;

    @Column(name = "inland_water_bodies")
    private float inland_water_bodies;

    @Column(name = "mangroves")
    private float mangroves;

    @Column(name = "permanent_snow_and_glaciers")
    private float permanent_snow_and_glaciers;

    @Column(name = "shrub_covered_areas")
    private float shrub_covered_areas;

    @Column(name = "shrubs_and_or_herbaceous_vegetation")
    private float shrubs_and_or_herbaceous_vegetation;

    @Column(name = "sparsely_natural_vegetated_areas")
    private float sparsely_natural_vegetated_areas;

    @Column(name = "terrestrial_barren_land")
    private float terrestrial_barren_land;

    @Column(name = "total_land_cover")
    private float total_land_cover;

    @Column(name = "tree_covered_areas")
    private float tree_covered_areas;

    @Column(name = "woody_crops")
    private float woody_crops;

    public int getF_id() {
        return f_id;
    }

    public int getIso_code() {
        return iso_code;
    }

    public int getYear_() {
        return year_;
    }

    public float getCarbon_stocks_in_forests() {
        return carbon_stocks_in_forests;
    }

    public float getForest_area() {
        return forest_area;
    }

    public float getIndex_of_carbon_stocks_in_forests() {
        return index_of_carbon_stocks_in_forests;
    }

    public float getIndex_of_forest_extent() {
        return index_of_forest_extent;
    }

    public float getLand_area() {
        return land_area;
    }

    public float getShare_of_forest_area() {
        return share_of_forest_area;
    }

    public float getArtificial_surfaces() {
        return artificial_surfaces;
    }

    public float getClimate_altering_land_cover_index() {
        return climate_altering_land_cover_index;
    }

    public float getGrassland() {
        return grassland;
    }

    public float getHerbaceous_crops() {
        return herbaceous_crops;
    }

    public float getInland_water_bodies() {
        return inland_water_bodies;
    }

    public float getMangroves() {
        return mangroves;
    }

    public float getPermanent_snow_and_glaciers() {
        return permanent_snow_and_glaciers;
    }

    public float getShrub_covered_areas() {
        return shrub_covered_areas;
    }

    public float getShrubs_and_or_herbaceous_vegetation() {
        return shrubs_and_or_herbaceous_vegetation;
    }

    public float getSparsely_natural_vegetated_areas() {
        return sparsely_natural_vegetated_areas;
    }

    public float getTerrestrial_barren_land() {
        return terrestrial_barren_land;
    }

    public float getTotal_land_cover() {
        return total_land_cover;
    }

    public float getTree_covered_areas() {
        return tree_covered_areas;
    }

    public float getWoody_crops() {
        return woody_crops;
    }
}
