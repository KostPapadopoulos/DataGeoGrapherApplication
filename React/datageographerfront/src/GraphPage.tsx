import React, { useEffect, useRef } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import * as d3 from "d3";
import "./GraphPage.css";

interface GraphData {
  [country: string]: { [metric: string]: { [value: string]: number } };
}

interface LocationState {
  graphData: GraphData;
  graphType: string;
  aggregateYears: string;
}

const GraphPage: React.FC = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const { graphData, graphType, aggregateYears } =
    location.state as LocationState;
  const svgRef = useRef<SVGSVGElement | null>(null);

  useEffect(() => {
    if (!graphData) {
      console.error("Graph data is missing.");
      return;
    }

    const aggregationPeriod = parseInt(aggregateYears);

    const aggregateData = (data: GraphData, period: number): GraphData => {
      const aggregatedData: GraphData = {};

      Object.keys(data).forEach((country) => {
        aggregatedData[country] = {};
        Object.keys(data[country]).forEach((metric) => {
          const yearlyData = data[country][metric];
          const aggregatedMetricData: { [yearRange: string]: number | null } = {};

          const years = Object.keys(yearlyData)
            .map(Number)
            .sort((a, b) => a - b);
          for (let i = 0; i < years.length; i += period) {
            const startYear = years[i];
            const endYear = years[Math.min(i + period - 1, years.length - 1)];
            const values = years
              .slice(i, i + period)
              .map((year) => yearlyData[year]);
            const validValues = values.filter(
              (value) => value !== null
            ) as number[];
            const averageValue =
              validValues.length > 0 ? d3.mean(validValues) : null;
            aggregatedMetricData[`${startYear}-${endYear}`] =
              averageValue !== undefined ? averageValue : null;
          }

          aggregatedData[country][metric] = aggregatedMetricData;
        });
      });

      return aggregatedData;
    };

    const processedData = aggregateYears
      ? aggregateData(graphData, aggregationPeriod)
      : graphData;

    const countryNames = Object.keys(processedData);
    if (countryNames.length === 0) {
      console.error("No country data available.");
      return;
    }

    const allMetrics = new Set<string>();
    countryNames.forEach((country) =>
      Object.keys(processedData[country]).forEach((metric) =>
        allMetrics.add(metric)
      )
    );
    const metricNames = Array.from(allMetrics);

    const specialMetrics = ["Population", "Area Sq Km"];
    const isSpecialMetric = metricNames.some((metric) =>
      specialMetrics.includes(metric)
    );

    const createBarChart = (
      filteredData: any[],
      width: number,
      height: number,
      margin: any,
      svg: any
    ) => {
      const xDomain = isSpecialMetric
        ? filteredData.map((d) => d.key)
        : Array.from(new Set(filteredData.map((d) => d.yearRange))).sort((a, b) => {
            const [startA] = a.split('-').map(Number);
            const [startB] = b.split('-').map(Number);
            return startA - startB;
          });

      const xScale = d3
        .scaleBand()
        .domain(xDomain)
        .range([0, width])
        .padding(0.3); // Increase padding to add more space between bars

      const allValues = filteredData.map((d) => d.value);
      const yMin = Math.min(0, d3.min(allValues) as number);
      const yMax = d3.max(allValues) as number;

      const yScale = d3.scaleLinear().domain([yMin, yMax]).range([height, 0]);

      const xAxis = d3.axisBottom(xScale).tickFormat((d: any) => {
        if (isSpecialMetric) {
          const parts = d.split("-");
          return parts[1]; // Return only the metric part (e.g., "Population")
        } else {
          return d; // Return the full year range for aggregated data
        }
      });
      const yAxis = d3.axisLeft(yScale);

      svg.append("g").attr("transform", `translate(0,${height})`).call(xAxis);
      svg.append("g").call(yAxis);

      const colorScale = d3.scaleOrdinal(d3.schemeCategory10);
      const keys = filteredData.map((item) => `${item.country}-${item.metric}`);
      colorScale.domain(keys);

      if (isSpecialMetric) {
        filteredData.forEach((item) => {
          svg
            .append("rect")
            .attr("x", xScale(item.key)!)
            .attr("y", yScale(Math.max(0, item.value)))
            .attr("width", xScale.bandwidth())
            .attr("height", Math.abs(yScale(item.value) - yScale(0)))
            .attr("fill", colorScale(`${item.country}-${item.metric}`))
            .append("title")
            .text(`${item.country} - ${item.metric}: ${item.value}`);
        });
      } else {
        const groupedData = d3.groups(filteredData, (d) => d.yearRange);

        groupedData.forEach(([yearRange, data]) => {
          const numBars = data.length;
          const barWidth = xScale.bandwidth() / numBars;

          data.forEach((d, i) => {
            svg
              .append("rect")
              .attr("x", xScale(yearRange)! + i * barWidth)
              .attr("y", yScale(Math.max(0, d.value)))
              .attr("width", barWidth)
              .attr("height", Math.abs(yScale(d.value) - yScale(0)))
              .attr("fill", colorScale(`${d.country}-${d.metric}`))
              .append("title")
              .text(`${d.country} - ${d.metric}: ${d.value}`);
          });
        });
      }

      svg
        .append("text")
        .attr("x", width / 2)
        .attr("y", height + margin.bottom - 10)
        .style("text-anchor", "middle")
        .text(isSpecialMetric ? "Metric" : "Year Range");

      svg
        .append("text")
        .attr("transform", "rotate(-90)")
        .attr("x", -height / 2)
        .attr("y", -margin.left + 15)
        .style("text-anchor", "middle")
        .text("Metric Value");

      const countryString = Array.from(
        new Set(filteredData.map((item) => item.country))
      );
      const metrics = Array.from(
        new Set(filteredData.map((item) => item.metric))
      );
      const countriesNames = countryString.join(", ");
      const metricsNames = metrics.join(", ");

      svg
        .append("text")
        .attr("x", width / 2)
        .attr("y", -margin.top / 2)
        .style("text-anchor", "middle")
        .style("font-size", "20px")
        .text(
          `${metricsNames} for ${countriesNames}${
            aggregateYears
              ? ` with aggregation for ${aggregateYears} years`
              : ""
          }`
        );

      const legend = svg
        .append("g")
        .attr("transform", `translate(${width + 30}, 0)`);

      const uniqueKeys = Array.from(new Set(keys));

      uniqueKeys.forEach((key, index) => {
        const legendEntry = legend
          .append("g")
          .attr("transform", `translate(0, ${index * 20})`);

        legendEntry
          .append("rect")
          .attr("width", 15)
          .attr("height", 15)
          .attr("fill", colorScale(key));

        legendEntry
          .append("text")
          .attr("x", 20)
          .attr("y", 12)
          .style("text-anchor", "start")
          .text(key);
      });
    };

    const createLineChart = (
      filteredData: any[],
      width: number,
      height: number,
      margin: any,
      svg: any
    ) => {
      const xDomain = Array.from(new Set(filteredData.map((d) => d.yearRange))).sort((a, b) => {
        const [startA] = a.split('-').map(Number);
        const [startB] = b.split('-').map(Number);
        return startA - startB;
      });
      const xScale = d3
        .scalePoint()
        .domain(xDomain)
        .range([0, width])
        .padding(0.3); // Increase padding to add more space between points

      const allValues = filteredData.map((d) => d.value);
      const yMin = Math.min(0, d3.min(allValues) as number);
      const yMax = d3.max(allValues) as number;

      const yScale = d3.scaleLinear().domain([yMin, yMax]).range([height, 0]);

      const xAxis = d3.axisBottom(xScale);
      const yAxis = d3.axisLeft(yScale);

      svg.append("g").attr("transform", `translate(0,${height})`).call(xAxis);
      svg.append("g").call(yAxis);

      const colorScale = d3.scaleOrdinal(d3.schemeCategory10);
      const line = d3
        .line()
        .x((d: any) => xScale(d.yearRange))
        .y((d: any) => yScale(d.value));

      const countryMetricGroups = d3.group(filteredData, (d) => `${d.country}-${d.metric}`);
      countryMetricGroups.forEach((values, key) => {
        svg
          .append("path")
          .datum(values)
          .attr("fill", "none")
          .attr("stroke", colorScale(key))
          .attr("stroke-width", 1.5)
          .attr("d", line);
      });

      svg
        .append("text")
        .attr("x", width / 2)
        .attr("y", height + margin.bottom - 10)
        .style("text-anchor", "middle")
        .text("Year Range");

      svg
        .append("text")
        .attr("transform", "rotate(-90)")
        .attr("x", -height / 2)
        .attr("y", -margin.left + 15)
        .style("text-anchor", "middle")
        .text("Metric Value");

      const countryString = Array.from(
        new Set(filteredData.map((item) => item.country))
      );
      const metrics = Array.from(
        new Set(filteredData.map((item) => item.metric))
      );
      const countriesNames = countryString.join(", ");
      const metricsNames = metrics.join(", ");

      svg
        .append("text")
        .attr("x", width / 2)
        .attr("y", -margin.top / 2)
        .style("text-anchor", "middle")
        .style("font-size", "20px")
        .text(
          `${metricsNames} for ${countriesNames}${
            aggregateYears
              ? ` with aggregation for ${aggregateYears} years`
              : ""
          }`
        );

      const legend = svg
        .append("g")
        .attr("transform", `translate(${width + 30}, 0)`);

      const keys = Array.from(new Set(filteredData.map((item) => `${item.country}-${item.metric}`)));
      keys.forEach((key, index) => {
        const legendEntry = legend
          .append("g")
          .attr("transform", `translate(0, ${index * 20})`);

        legendEntry
          .append("rect")
          .attr("width", 15)
          .attr("height", 15)
          .attr("fill", colorScale(key));

        legendEntry
          .append("text")
          .attr("x", 20)
          .attr("y", 12)
          .style("text-anchor", "start")
          .text(key);
      });
    };

    const createScatterPlot = (
      filteredData: any[],
      width: number,
      height: number,
      margin: any,
      svg: any
    ) => {
      const xDomain = Array.from(new Set(filteredData.map((d) => d.yearRange))).sort((a, b) => {
        const [startA] = a.split('-').map(Number);
        const [startB] = b.split('-').map(Number);
        return startA - startB;
      });
      const xScale = d3
        .scalePoint()
        .domain(xDomain)
        .range([0, width])
        .padding(0.3); // Increase padding to add more space between points

      const allValues = filteredData.map((d) => d.value);
      const yMin = Math.min(0, d3.min(allValues) as number);
      const yMax = d3.max(allValues) as number;

      const yScale = d3.scaleLinear().domain([yMin, yMax]).range([height, 0]);

      const xAxis = d3.axisBottom(xScale);
      const yAxis = d3.axisLeft(yScale);

      svg.append("g").attr("transform", `translate(0,${height})`).call(xAxis);
      svg.append("g").call(yAxis);

      const colorScale = d3.scaleOrdinal(d3.schemeCategory10);

      svg
        .selectAll("circle")
        .data(filteredData)
        .enter()
        .append("circle")
        .attr("cx", (d) => xScale(d.yearRange)!)
        .attr("cy", (d) => yScale(d.value))
        .attr("r", 5)
        .attr("fill", (d) => colorScale(`${d.country}-${d.metric}`))
        .append("title")
        .text((d) => `${d.country} - ${d.metric}: ${d.value}`);

      svg
        .append("text")
        .attr("x", width / 2)
        .attr("y", height + margin.bottom - 10)
        .style("text-anchor", "middle")
        .text("Year Range");

      svg
        .append("text")
        .attr("transform", "rotate(-90)")
        .attr("x", -height / 2)
        .attr("y", -margin.left + 15)
        .style("text-anchor", "middle")
        .text("Metric Value");

      const countryString = Array.from(
        new Set(filteredData.map((item) => item.country))
      );
      const metrics = Array.from(
        new Set(filteredData.map((item) => item.metric))
      );
      const countriesNames = countryString.join(", ");
      const metricsNames = metrics.join(", ");

      svg
        .append("text")
        .attr("x", width / 2)
        .attr("y", -margin.top / 2)
        .style("text-anchor", "middle")
        .style("font-size", "20px")
        .text(
          `${metricsNames} for ${countriesNames}${
            aggregateYears
              ? ` with aggregation for ${aggregateYears} years`
              : ""
          }`
        );

      const legend = svg
        .append("g")
        .attr("transform", `translate(${width + 30}, 0)`);

      const keys = Array.from(new Set(filteredData.map((item) => `${item.country}-${item.metric}`)));
      keys.forEach((key, index) => {
        const legendEntry = legend
          .append("g")
          .attr("transform", `translate(0, ${index * 20})`);

        legendEntry
          .append("rect")
          .attr("width", 15)
          .attr("height", 15)
          .attr("fill", colorScale(key));

        legendEntry
          .append("text")
          .attr("x", 20)
          .attr("y", 12)
          .style("text-anchor", "start")
          .text(key);
      });
    };

    const parsedData = countryNames.flatMap((country) =>
      metricNames
        .map((metric) => {
          if (specialMetrics.includes(metric)) {
            const value = +Object.keys(processedData[country][metric])[0];
            return {
              key: `${country}-${metric}`,
              country,
              metric,
              value,
            };
          } else {
            return Object.entries(processedData[country][metric] || {}).map(
              ([yearRange, value]) => ({
                key: `${country}-${metric}-${yearRange}`,
                country,
                metric,
                value: value !== null ? +value : null,
                yearRange,
              })
            );
          }
        })
        .flat()
    );

    const filteredData = parsedData.filter((item) => item.value !== null);

    const widthFactor = 50; // Increase width factor to add more space between years
    const minGraphWidth = 900;
    const maxGraphWidth = 1500; // Set a maximum width for the graph
    const width = Math.min(maxGraphWidth, Math.max(minGraphWidth, filteredData.length * widthFactor));

    const margin = { top: 40, right: 160, bottom: 50, left: 80 };
    const height = 400 - margin.top - margin.bottom;

    d3.select(svgRef.current).selectAll("*").remove();

    const svg = d3
      .select(svgRef.current)
      .attr("width", width + margin.left + margin.right + 200)
      .attr("height", height + margin.top + margin.bottom)
      .append("g")
      .attr("transform", `translate(${margin.left},${margin.top})`);

    if (graphType === "barchart") {
      createBarChart(filteredData, width, height, margin, svg);
    } else if (graphType === "timelineChart") {
      createLineChart(filteredData, width, height, margin, svg);
    } else if (graphType === "scatterPlot") {
      createScatterPlot(filteredData, width, height, margin, svg);
    }
  }, [graphData, graphType, aggregateYears]);

  return (
    <div>
      <div className="scrollable-container">
        <div className="graph-container">
          <svg ref={svgRef}></svg>
        </div>
      </div>
      <div>
        <button onClick={() => navigate(-1)} className="go-back-button">
          Back To Metric Selection
        </button>
      </div>
    </div>
  );
};

export default GraphPage;
