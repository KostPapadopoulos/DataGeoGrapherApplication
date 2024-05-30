import React from "react";
import "./AggregateYears.css";

interface AggregateYearsProps {
  isAggregateChecked: boolean;
  handleCheckboxChange: () => void;
  aggregateYears: string;
  handleRadioChange: (event: React.ChangeEvent<HTMLInputElement>) => void;
  disabled: boolean; // Accept disabled prop
}

const AggregateYears: React.FC<AggregateYearsProps> = ({
  isAggregateChecked,
  handleCheckboxChange,
  aggregateYears,
  handleRadioChange,
  disabled, // Destructure disabled prop
}) => {
  return (
    <div className="aggregate-container">
      <label>
        <input
          type="checkbox"
          checked={isAggregateChecked}
          onChange={handleCheckboxChange}
          disabled={disabled} 
        />
        Aggregate Years
      </label>
      {isAggregateChecked && (
        <div className="aggregate-options">
          <label>
            <input
              type="radio"
              name="aggregateYears"
              value="5"
              checked={aggregateYears === "5"}
              onChange={handleRadioChange}
              disabled={disabled} 
            />
            5 Years
          </label>
          <label>
            <input
              type="radio"
              name="aggregateYears"
              value="10"
              checked={aggregateYears === "10"}
              onChange={handleRadioChange}
              disabled={disabled}
            />
            10 Years
          </label>
        </div>
      )}
    </div>
  );
};

export default AggregateYears;
