--create database dataGeoGrapherDB;
--use dataGeoGrapherDB;

drop table if exists climate_disasters_temperature_change;
drop table if exists forest_carbon_land_cover;
drop table if exists countries;

create table countries (
    iso varchar(5) default null,
    iso_3 varchar(5) default null,
    iso_code int(10) unique not null,
    fips varchar(5) default null,
    display_name varchar(100) default null,
    official_name varchar(100) default null,
    capital varchar(100) default null,
    continent varchar(100) default null,
    currency_code varchar(100) default null,
    currency_name varchar(100) default null,
    phone varchar(100) default null,
    region_code int(10) default null,
    region_name varchar(100) default null,
    subregion_code int(10) default null,
    subregion_name varchar(100) default null,
    intermediate_region_code int(10) default null,
    intermediate_region_name varchar(100) default null,
    c_status varchar(100) default null,
    developed_or_developing varchar(100) default null,
    sids varchar(20) default null,
    lldc varchar(20) default null,
    ldc varchar(20) default null,
    area_sq_km int(20) default null,
    population int(50) default null,

    PRIMARY KEY (iso_code)
);

create table climate_disasters_temperature_change(
    c_id int(10) unique not null,
    iso_code int(10) not null,
    year_ int(10) not null,
    temperature_change float(10) default null,
    drought int(5) default null,
    extreme_temperature int(5) default null,
    flood int(5) default null,
    landslide int(5) default null,
    storm int(5) default null,
    total_disasters int(5) default null,
    wildfire int(5) default null,

    PRIMARY KEY (c_id),
    FOREIGN KEY (iso_code) REFERENCES countries(iso_code)
);

create table forest_carbon_land_cover(
    f_id int(10) unique not null,
    iso_code int(10) not null,
    year_ int(10) not null,
    carbon_stocks_in_forests float(10) default null,
    forest_area float(10) default null,
    index_of_carbon_stocks_in_forests float(10) default null,
    index_of_forest_extent float(10) default null,
    land_area float(10) default null,
    share_of_forest_area float(10) default null,
    artificial_surfaces float(10) default null,
    climate_altering_land_cover_index float(10) default null,
    grassland float(10) default null,
    herbaceous_crops float(10) default null,
    inland_water_bodies float(10) default null,
    mangroves float(10) default null,
    permanent_snow_and_glaciers float(10) default null,
    shrub_covered_areas float(10) default null,
    shrubs_and_or_herbaceous_vegetation float(10) default null,
    sparsely_natural_vegetated_areas float(10) default null,
    terrestrial_barren_land float(10) default null,
    total_land_cover float(10) default null,
    tree_covered_areas float(10) default null,
    woody_crops float(10) default null,

    PRIMARY KEY (f_id),
    FOREIGN KEY (iso_code) REFERENCES countries(iso_code)
);