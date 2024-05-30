import React from "react";
import "./EndingYear.css";

interface EndingYearProps {
  selectedYear: number;
  setSelectedYear: (year: number) => void;
  disabled: boolean; // Add the disabled prop here
}

const EndingYear: React.FC<EndingYearProps> = ({
  selectedYear,
  setSelectedYear,
  disabled, // Destructure the new prop
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
    setSelectedYear(value === "" ? 2022 : parseInt(value, 10));
  };

  return (
    <div>
      <div className="ending-year-text">
        <p>Select Ending Year:</p>
      </div>
      <select
        value={selectedYear}
        onChange={handleChange}
        disabled={disabled} // Apply the prop here
        className="ending-year-dropdown"
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

export default EndingYear;
