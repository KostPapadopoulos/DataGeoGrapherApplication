import React from "react";
import "./GraphTypeList.css"; // Make sure to import the CSS for styling

interface GraphOptionsProps {
  selectedGraphType: string;
  setSelectedGraph: (graphType: string) => void;
}

const GraphOptions: React.FC<GraphOptionsProps> = ({
  selectedGraphType,
  setSelectedGraph,
}) => {
  const handleGraphChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    setSelectedGraph(event.target.value);
  };

  return (
    <div>
      <div className="graph-text">
        <p>Select Graph Type:</p>
      </div>
      <div className="graph-options">
        <select
          id="graphSelect"
          value={selectedGraphType}
          onChange={handleGraphChange}
        >
          <option value="barChart">Bar Chart</option>
          <option value="timelineChart">Timeline/Trendline Chart</option>
          <option value="scatterPlot">Scatter Plot</option>
        </select>
      </div>
    </div>
  );
};

export default GraphOptions;
