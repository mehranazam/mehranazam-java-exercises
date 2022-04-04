import { useState } from "react";
import Agent from "./Agent";
import AddAgent from "./AddAgent";

function Agents() {
  const [agents, setAgents] = useState([]);

  function errorHandler(rejectionMessage) {
    console.log(rejectionMessage);
  }

  function fetchAgents() {
    fetch("http://localhost:8080/api/agent")
      .then((response) => response.json())
      .then((jsonData) => setAgents(jsonData))
      .catch((rejection) => () => errorHandler(rejection));
  }

  function AgentFactory() {
    return agents.map((agentObj) => (
      <Agent
        key={agentObj.agentId}
        agentObj={agentObj}
        agents={agents}
        setAgents={setAgents}
      />
    ));
  }

  return (
    <>
      <AddAgent agents={AddAgent} />
      <button onClick={fetchAgents}>Retrieve Agents</button>
      {AgentFactory()}
    </>
  );
}

export default Agents;
