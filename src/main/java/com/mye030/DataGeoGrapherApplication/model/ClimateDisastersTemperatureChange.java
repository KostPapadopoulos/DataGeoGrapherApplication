package com.mye030.DataGeoGrapherApplication.model;

import javax.persistence.*;

@Entity
@Table(name = "climate_disasters_temperature_change")
public class ClimateDisastersTemperatureChange {

    @Id
    @Column(name = "c_id", unique = true)
    private Integer c_id;

    //@ManyToOne
    @JoinColumn(name = "iso_code", referencedColumnName = "iso_code")
    private Integer isoCode;

    @Column(name = "year_")
    private Integer year_;

    @Column(name = "temperature_change")
    private Float temperature_change;

    @Column(name = "drought")
    private Integer drought;

    @Column(name = "extreme_temperature")
    private Integer extreme_temperature;

    @Column(name = "flood")
    private Integer flood;

    @Column(name = "landslide")
    private Integer landslide;

    @Column(name = "storm")
    private Integer storm;

    @Column(name = "total_disasters")
    private Integer total_disasters;

    @Column(name = "wildfire")
    private Integer wildfire;

    public Integer getC_id() {
        return c_id;
    }

    public Integer getIso_code() {
        return isoCode;
    }

    public Integer getYear_() {
        return year_;
    }

    public Float getTemperature_change() {
        return temperature_change;
    }

    public Integer getDrought() {
        return drought;
    }

    public Integer getExtreme_temperature() {
        return extreme_temperature;
    }

    public Integer getFlood() {
        return flood;
    }

    public Integer getLandslide() {
        return landslide;
    }

    public Integer getStorm() {
        return storm;
    }

    public Integer getTotal_disasters() {
        return total_disasters;
    }

    public Integer getWildfire() {
        return wildfire;
    }
}
