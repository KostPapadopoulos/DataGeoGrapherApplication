package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country {

    @Column(name= "iso")
    private String iso ;

    @Column(name= "iso_3")
    private String iso_3;

    @Column(name= "iso_code")
    private int iso_code;

    @Column(name = "fips")
    private String fips;

    @Column(name = "display_name")
    private String display_name;

    @Column(name = "official_name")
    private String getDisplay_name;

    @Column(name = "capital")
    private String capital;

    @Column(name = "continent")
    private String continent;

    @Column(name = "currency_code")
    private String currency_code;

    @Column(name = "currency_name")
    private String currency_name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "region_code")
    private int region_code;

    @Column(name = "region_name")
    private String region_name;

    @Column(name = "subregion_code")
    private int subregion_code;

    @Column(name = "subregion_name")
    private String subregion_name;

    @Column(name = "intermediate_region_code")
    private int intermediate_region_code;

    @Column(name = "intermediate_region_name")
    private String intermediate_region_name;

    @Column(name = "c_status")
    private String c_status;

    @Column(name = "developed_or_developing")
    private String developed_or_developing;

    @Column(name = "sids")
    private String sids;

    @Column(name = "lldc")
    private String lldc;

    @Column(name = "ldc")
    private String ldc;

    @Column(name = "area_sqKm")
    private int area_sqKm;

    @Column(name = "population")
    private int population;

    public int getIso_code() {
        return iso_code;
    }

    public String getFips() {
        return fips;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getGetDisplay_name() {
        return getDisplay_name;
    }

    public String getCapital() {
        return capital;
    }

    public String getContinent() {
        return continent;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public String getPhone() {
        return phone;
    }

    public int getRegion_code() {
        return region_code;
    }

    public String getRegion_name() {
        return region_name;
    }

    public int getSubregion_code() {
        return subregion_code;
    }

    public String getSubregion_name() {
        return subregion_name;
    }

    public int getIntermediate_region_code() {
        return intermediate_region_code;
    }

    public String getIntermediate_region_name() {
        return intermediate_region_name;
    }

    public String getC_status() {
        return c_status;
    }

    public String getDeveloped_or_developing() {
        return developed_or_developing;
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

    public int getArea_sqKm() {
        return area_sqKm;
    }

    public int getPopulation() {
        return population;
    }
}

