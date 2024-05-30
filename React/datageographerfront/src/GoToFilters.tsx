import "./GoToFilters.css";
import React from "react";

const GoToFilters = ({ text, onClick }) => {
  return (
    <div className="GoToFilters">
      <button onClick={onClick}>{text}</button>
    </div>
  );
};

export default GoToFilters;
