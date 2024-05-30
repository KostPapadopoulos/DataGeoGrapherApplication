// CountriesList.js
import React, { useState, useEffect } from "react";
import axios from "./api/axiosConfig";
import "./CountriesList.css";

type Country = {
  ISO_Code: number;
  Display_Name: string;
};

// Update the component to accept selected countries as props
interface CountriesListProps {
  selectedCountries: string[];
  setSelectedCountries: (countries: string[]) => void;
}

const CountriesList: React.FC<CountriesListProps> = ({
  selectedCountries,
  setSelectedCountries,
}) => {
  const [options, setOptions] = useState<Country[]>([]);

  // Fetch countries on component mount
  useEffect(() => {
    const fetchOptions = async () => {
      try {
        const response = await axios.get<{ [isoCode: string]: string }>(
          "http://localhost:8080/api/get-countries"
        );
        const countriesArray = Object.keys(response.data).map((isoCode) => ({
          ISO_Code: parseInt(isoCode),
          Display_Name: response.data[isoCode],
        }));
        setOptions(countriesArray);
      } catch (error) {
        console.error("Failed to fetch countries:", error);
      }
    };

    fetchOptions();
  }, []);

  // Handle selection change and update the parent's state via the setter
  const handleChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const values = Array.from(
      event.target.selectedOptions,
      (option) => option.value
    );
    setSelectedCountries(values);
  };

  return (
    <div>
      <div className="countries-text">
        <p>Select one or more countries:</p>
      </div>
      <div>
        <input
          type="text"
          readOnly
          value={selectedCountries.join(", ")}
          className="selected-countries-input"
        />
        <select multiple={true} value={selectedCountries} onChange={handleChange}>
          {options.map((option) => (
            <option key={option.ISO_Code} value={option.Display_Name}>
              {option.Display_Name}
            </option>
          ))}
        </select>
      </div>
    </div>
  );
};

export default CountriesList;
