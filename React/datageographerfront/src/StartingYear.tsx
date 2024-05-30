import React from "react";
import "./StartingYear.css";

interface StartingYearProps {
  selectedYear: number;
  setSelectedYear: (year: number) => void;
  disabled: boolean; // Add this prop to the component interface
}

const StartingYear: React.FC<StartingYearProps> = ({
  selectedYear,
  setSelectedYear,
  disabled, // Destructure the new prop here
}) => {
  const generateYears = (start: number, end: number): number[] => {
    const years = [];
    for (let year = start; year <= end; year++) {
      years.push(year);
    }
    return years;
  };

  const years = generateYears(1961, 2022);

  const handleChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const value = event.target.value;
    setSelectedYear(value === "" ? 1961 : parseInt(value, 10));
  };

  return (
    <div>
      <div className="starting-year-text">
        <p>Select Starting Year:</p>
      </div>
      <select
        value={selectedYear}
        onChange={handleChange}
        disabled={disabled}
        className="starting-year-dropdown"
      >
        <option value=""></option>
        {years.map((year) => (
          <option key={year} value={year}>
            {year}
          </option>
        ))}
      </select>
    </div>
  );
};

export default StartingYear;
