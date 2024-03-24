package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "climate_disasters_temperature_change")
public class ClimateDisastersTemperatureChange {

    @Column(name = "c_id")
    private int c_id;

    @Column(name = "iso_code")
    private int iso_code;

    @Column(name = "year_")
    private int year_;

    @Column(name = "temperature_change")
    private float temperature_change;

    @Column(name = "drought")
    private int drought;

    @Column(name = "extreme_temperature")
    private int extreme_temperature;

    @Column(name = "flood")
    private int flood;

    @Column(name = "landslide")
    private int landslide;

    @Column(name = "storm")
    private int storm;

    @Column(name = "total_disasters")
    private int total_disasters;

    @Column(name = "wildfire")
    private int wildfire;

    public int getC_id() {
        return c_id;
    }

    public int getIso_code() {
        return iso_code;
    }

    public int getYear_() {
        return year_;
    }

    public float getTemperature_change() {
        return temperature_change;
    }

    public int getDrought() {
        return drought;
    }

    public int getExtreme_temperature() {
        return extreme_temperature;
    }

    public int getFlood() {
        return flood;
    }

    public int getLandslide() {
        return landslide;
    }

    public int getStorm() {
        return storm;
    }

    public int getTotal_disasters() {
        return total_disasters;
    }

    public int getWildfire() {
        return wildfire;
    }
}
