package com.mye030.DataGeoGrapherApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="countries")
public class Country {

    public Country(){

    }

    @Column(name= "iso")
    private String iso ;

    @Column(name= "iso_3")
    private String iso3;

    @Id
    @Column(name= "iso_code", unique = true)
    private Integer isoCode;

    @Column(name = "fips")
    private String fips;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "official_name")
    private String officialName;

    @Column(name = "capital")
    private String capital;

    @Column(name = "continent")
    private String continent;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "currency_name")
    private String currencyName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "region_code")
    private Integer regionCode;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "subregion_code")
    private Integer subregionCode;

    @Column(name = "subregion_name")
    private String subregionName;

    @Column(name = "intermediate_region_code")
    private Integer intermediateRegionCode;

    @Column(name = "intermediate_region_name")
    private String intermediateRegionName;

    @Column(name = "c_status")
    private String cStatus;

    @Column(name = "developed_or_developing")
    private String developedOrDeveloping;

    @Column(name = "sids")
    private String sids;

    @Column(name = "lldc")
    private String lldc;

    @Column(name = "ldc")
    private String ldc;

    @Column(name = "area_sq_km")
    private Integer areaSqKm;

    @Column(name = "population")
    private Integer population;

    public String getIso() {
        return iso;
    }

    public String getIso_3() {
        return iso3;
    }

    public Integer getIsoCode() {
        return isoCode;
    }

    public String getFips() {
        return fips;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getOfficialName() {
        return officialName;
    }

    public String getCapital() {
        return capital;
    }

    public String getContinent() {
        return continent;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public Integer getSubregionCode() {
        return subregionCode;
    }

    public String getSubregionName() {
        return subregionName;
    }

    public Integer getIntermediateRegionCode() {
        return intermediateRegionCode;
    }

    public String getIntermediateRegionName() {
        return intermediateRegionName;
    }

    public String getcStatus() {
        return cStatus;
    }

    public String getDevelopedOrDeveloping() {
        return developedOrDeveloping;
    }

    public String getSids() {
        return sids;
    }

    public String getLldc() {
        return lldc;
    }

    public String getLdc() {
        return ldc;
    }

    public Integer getAreaSqKm() {
        return areaSqKm;
    }

    public Integer getPopulation() {
        return population;
    }

    public static List<String> getAttributeNames(Class<?> clazz) {
        List<String> attributeNames = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            attributeNames.add(field.getName());
        }
        return attributeNames;
    }
}

