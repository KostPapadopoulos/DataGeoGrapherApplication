import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Homepage from "./Homepage"; // Ensure the import path is correct
import FilterSelection from "./FilterSelection"; // Assuming you have a Home component
import GraphPage from "./GraphPage";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/filter-selection" element={<FilterSelection />} />
        <Route path="/graph" element={<GraphPage />} />
        <Route path="/" element={<Homepage />} />
      </Routes>
    </Router>
  );
}

export default App;
