import Agents from "./Agents";
import { useState } from "react";

function App() {
  const [agents, setAgents] = useState([]);
  function deleteAgent(id) {
    let newAgentsArray = [...agents];
    setAgents(newAgentsArray.filter((agent) => agent.id !== id));
  }
  return (
    <div className="App">
      <Agents />
    </div>
  );
}

export default App;
