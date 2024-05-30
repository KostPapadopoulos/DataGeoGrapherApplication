package com.mye030.DataGeoGrapherApplication.model;


import java.util.List;

public class ChartData {

    private List<String> countries;
    private List<String> metrics;
    private int endYear;
    private Integer startYear;
    private String chartType;

    public ChartData(List<String> countries, List<String> metrics, int startYear, int endYear) {
        this.countries = countries;
        this.metrics = metrics;
        this.startYear = startYear;
        this.endYear = endYear;
    }
    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<String> metrics) {
        this.metrics = metrics;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }
}
