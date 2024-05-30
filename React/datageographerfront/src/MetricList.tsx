// MetricList.js
import React, { useState, useEffect } from "react";
import axios from "axios";
import "./MetricList.css";

interface MetricListProps {
  selectedMetrics: string[];
  setSelectedMetrics: (metrics: string[]) => void;
}

const MetricList: React.FC<MetricListProps> = ({
  selectedMetrics,
  setSelectedMetrics,
}) => {
  const [metrics, setMetrics] = useState<string[]>([]);

  // Fetch metrics from the backend when the component mounts
  useEffect(() => {
    const fetchMetrics = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/api/get-all-metrics"
        );
        setMetrics(response.data);
      } catch (error) {
        console.error("Error fetching metrics:", error);
      }
    };

    fetchMetrics();
  }, []);

  // Handle selection change in the dropdown and update the parent state
  const handleChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedOptions = Array.from(
      event.target.selectedOptions,
      (option) => option.value
    );
    setSelectedMetrics(selectedOptions);
  };

  return (
    <div>
      <div className="metrics-text">
        <p>Select one or more metrics:</p>
      </div>
      <select
        multiple
        value={selectedMetrics}
        onChange={handleChange}
        className="selected-metrics-dropdown"
      >
        {metrics.map((metric, index) => (
          <option key={index} value={metric}>
            {metric}
          </option>
        ))}
      </select>
      <div>
        <input
          type="text"
          readOnly
          value={selectedMetrics.join(", ")}
          className="selected-metrics-input"
        />
      </div>
    </div>
  );
};

export default MetricList;
