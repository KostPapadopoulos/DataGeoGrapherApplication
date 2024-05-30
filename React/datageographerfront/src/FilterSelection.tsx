import "./FilterSelection.css";
import { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import CountriesList from "./CountriesList";
import MetricList from "./MetricList";
import GraphOptions from "./GraphTypeList";
import StartingYear from "./StartingYear";
import EndingYear from "./EndingYear";
import AggregateYears from "./AggregateYears";

interface MetricData {
  [year: string]: number | null;
}

interface CountryData {
  [metric: string]: MetricData;
}

interface GraphData {
  [country: string]: CountryData;
}

const FilterSelection = () => {
  const [countries, setCountries] = useState<string[]>([]);
  const [metrics, setMetrics] = useState<string[]>([]);
  const [startYear, setStartingYear] = useState<number>(1961);
  const [endYear, setEndingYear] = useState<number>(2022);
  const [graphType, setGraphType] = useState<string>("barchart");

  const [startingYearDisabled, setStartingYearDisabled] =
    useState<boolean>(false);
  const [endingYearDisabled, setEndingYearDisabled] = useState<boolean>(false);

  const [isAggregateChecked, setIsAggregateChecked] = useState<boolean>(false);
  const [aggregateYears, setAggregateYears] = useState<string>("");

  const [aggregateDisabled, setAggregateDisabled] = useState<boolean>(false);

  const navigate = useNavigate();

  useEffect(() => {
    const disableStartingYear =
      metrics.includes("Population") || metrics.includes("Area Sq Km");
    const disableEndingYear =
      metrics.includes("Population") || metrics.includes("Area Sq Km");
    const disableAggregate =
      metrics.includes("Population") || metrics.includes("Area Sq Km");

    setStartingYearDisabled(disableStartingYear);
    setEndingYearDisabled(disableEndingYear);
    setAggregateDisabled(disableAggregate);
  }, [metrics]);

  const handleCheckboxChange = () => {
    setIsAggregateChecked(!isAggregateChecked);
  };

  const handleRadioChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setAggregateYears(event.target.value);
  };

  const handleSubmit = async () => {
    const data = {
      countries,
      metrics,
      startYear,
      endYear,
    };

    try {
      // Make the request and assert the type to `GraphData`
      const response = await axios.post(
        "http://localhost:8080/api/get-graph-values",
        data
      );
      const graphData: GraphData = response.data;

      // Check if all values are null
      const allNull = Object.values(graphData).every(
        (countryData: CountryData) =>
          Object.values(countryData).every((metricData: MetricData) =>
            Object.values(metricData).every((value) => value === null)
          )
      );

      if (allNull) {
        alert(
          "Are you sure you selected country/countries or metric/metrics?" +
            "\n" +
            "Cannot create graph because all values are null in this year range."
        );

      } if (
        (metrics.includes("Population") || metrics.includes("Area Sq Km")) && 
        (graphType !== "barchart")
      ) {
        alert(
          "Only Bar Chart can be created when Population and/or Area Sq Km are selected."
        );
      
      } else if ((graphType === "scatterPlot") && metrics.length > 1){
        alert(
          "Only one metric is available for Scatter Plot graph"
        );
      }
      
      else {
        navigate("/graph", { state: { graphData, graphType, aggregateYears } });
      }
    } catch (error) {
      console.error("Error submitting data:", error);
    }
  };

  return (
    <div>
      <div className="filter-image">
        <div className="filter-text">
          <p>Please Select Countries, Metrics, and Graph Type</p>
        </div>
        <div>
          <CountriesList
            selectedCountries={countries}
            setSelectedCountries={setCountries}
          />
          <MetricList
            selectedMetrics={metrics}
            setSelectedMetrics={setMetrics}
          />
          <StartingYear
            selectedYear={startYear}
            setSelectedYear={setStartingYear}
            disabled={startingYearDisabled}
          />
          <EndingYear
            selectedYear={endYear}
            setSelectedYear={setEndingYear}
            disabled={endingYearDisabled}
          />
          <GraphOptions
            selectedGraphType={graphType}
            setSelectedGraph={setGraphType}
          />
          <AggregateYears
            isAggregateChecked={isAggregateChecked}
            handleCheckboxChange={handleCheckboxChange}
            aggregateYears={aggregateYears}
            handleRadioChange={handleRadioChange}
            disabled={aggregateDisabled} 
          />
        </div>
        <div className="submit">
          <button onClick={handleSubmit}>Create Graph</button>
        </div>
      </div>
    </div>
  );
};

export default FilterSelection;
