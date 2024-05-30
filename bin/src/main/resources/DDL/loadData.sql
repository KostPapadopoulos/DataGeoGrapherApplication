use dataGeoGrapherDB;

load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/countries_MODIFIED.csv'
into table countries
fields terminated by  ','
enclosed by '"'
lines terminated by '\r\n'
ignore 1 lines
(@vISO,@vISO3,iso_code,@vFIPS,@vDisplay_Name,@vOfficial_Name,@vCapital,@vContinent, @vCurrencyCode, @vCurrencyName, @vPhone, @vRegion_Code, @vRegion_Name, @vSubregion_Code, @vSubregion_Name, @vIntermediate_Region_Code, @vIntermediate_Region_Name, @vStatus, @vDeveloped_or_Developing, @vSmall_Island_Developing_States, @vLand_Locked_Developing_Countries, @vLeast_Developed_Countries, @vArea_SqKm, @vPopulation)
set iso = nullif(@vISO, ''),
iso_3 = nullif(@vISO3, ''),
fips = NULLIF(@vFIPS,''),
display_name = nullif(@vDisplay_Name,''),
official_name = nullif(@vOfficial_Name,''),
capital = nullif(@vCapital,''),
continent = nullif(@vContinent,''),
currency_code = nullif(@vCurrencyCode,''),
currency_name = nullif(@vCurrencyName,''),
phone = nullif(@vPhone,''),
region_code = nullif(@vRegion_Code,''),
region_name = nullif(@vRegion_Name,''),
subregion_code = nullif(@vSubregion_Code,''),
subregion_name = nullif(@vSubregion_Name,''),
intermediate_region_code = nullif(@vIntermediate_Region_Code,''),
intermediate_region_name = nullif(@vIntermediate_Region_Name,''),
c_status = nullif(@vStatus,''),
developed_or_developing = nullif(@vDeveloped_or_Developing,''),
sids = nullif(@vSmall_Island_Developing_States,''),
lldc = nullif(@vLand_Locked_Developing_Countries,''),
ldc = nullif(@vLeast_Developed_Countries,''),
area_sqKm = nullif(@vArea_SqKm,''),
population = nullif(@vPopulation,'');

load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Climate_Disasters_Temperature_Change.csv'
into table climate_disasters_temperature_change
fields terminated by  ','
enclosed by '"'
lines terminated by '\r\n'
ignore 1 lines
(c_id,iso_code,year_,@vTemperature_change,@vDrought,@vExtreme_temperature,@vFlood,@vLlandslide,@vStorm,@vTOTAL,@vWildfire)
set temperature_change = nullif(@vTemperature_change,''),
drought = nullif(@vDrought,''),
extreme_temperature = nullif(@vExtreme_temperature,''),
flood = nullif(@vFlood,''),
landslide = nullif(@vLlandslide,''),
storm = nullif(@vStorm,''),
total_disasters = nullif(@vTOTAL,''),
wildfire = nullif(@vWildfire,'');


load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Forest_Carbon_Land_Cover.csv'
into table forest_carbon_land_cover
fields terminated by  ','
enclosed by '"'
lines terminated by '\r\n'
ignore 1 lines
(f_id,iso_code,year_,@vCarbon_stocks_in_forests, @vForest_area,@vIndex_of_carbon_stocks_in_forests, @vIndex_of_forest_exnted, @vLand_area, @vShare_of_forest_area, @vArtificial_surfaces, @vClimate_Altering_Land_Cover_Index, @vGrassland, @vHerbaceous_crops, @vInland_water_bodies, @vMangroves, @vPermanent_snow_and_glaciers, @vShrub_covered_areas, @vShrubs_and_or_herbaceous_vegetation, @vSparsely_natural_vegetated_areas, @vTerrestrial_barren_land, @vTotal_land_cover, @vTree_covered_areas, @vWoody_crops)
set carbon_stocks_in_forests = nullif(@vCarbon_stocks_in_forests,''),
forest_area = nullif(@vForest_area,''),
index_of_carbon_stocks_in_forests = nullif(@vIndex_of_carbon_stocks_in_forests,''),
index_of_forest_extent = nullif(@vIndex_of_forest_exnted,''),
land_area = nullif(@vLand_area,''),
share_of_forest_area = nullif(@vShare_of_forest_area,''),
artificial_surfaces = nullif(@vArtificial_surfaces,''),
climate_altering_land_cover_index = nullif(@vClimate_Altering_Land_Cover_Index,''),
grassland = nullif(@vGrassland,''),
herbaceous_crops = nullif(@vHerbaceous_crops,''),
inland_water_bodies = nullif(@vInland_water_bodies,''),
mangroves = nullif(@vMangroves,''),
permanent_snow_and_glaciers = nullif(@vPermanent_snow_and_glaciers,''),
shrub_covered_areas = nullif(@vShrub_covered_areas,''),
shrubs_and_or_herbaceous_vegetation = nullif(@vShrubs_and_or_herbaceous_vegetation,''),
sparsely_natural_vegetated_areas = nullif(@vSparsely_natural_vegetated_areas,''),
terrestrial_barren_land = nullif(@vTerrestrial_barren_land,''),
total_land_cover = nullif(@vTotal_land_cover,''),
tree_covered_areas = nullif(@vTree_covered_areas,''),
woody_crops = nullif(@vWoody_crops,'');
