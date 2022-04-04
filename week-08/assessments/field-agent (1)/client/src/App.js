import Agents from "./Agents";
import { useState } from "react";

function App() {
  const [agents, setAgents] = useState([]);
  return (
    <div className="App">
      <Agents />
    </div>
  );
}

export default App;
