import "./Homepage.css"; 
import React from 'react';
import GoToFilters from "./GoToFilters";

const Homepage: React.FC = () => {
  const handleButtonClick = () => {
    window.location.href = 'http://localhost:5173/filter-selection';
  };

  return (
    <div>
      <div className="background-image">
        <div className = "homepage-text" >
          <p>
            Welcome To GeoGrapher!
          </p>
        </div>
      </div>
      <GoToFilters text="Create Your Graph" onClick={handleButtonClick} />
    </div>
  );
};

export default Homepage;
