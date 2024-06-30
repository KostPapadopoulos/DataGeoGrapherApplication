import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Homepage from "./Homepage"; 
import FilterSelection from "./FilterSelection"; 
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
