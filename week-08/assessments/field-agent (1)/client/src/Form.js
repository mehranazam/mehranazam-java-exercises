import { useState } from "react";

function Form(props) {
  const [firstName, setFirstName] = useState("");
  const [lastName, setlastName] = useState("");

  function handleFirstNameChange(event) {
    setFirstName(event.target.value);
  }

  function replaceAgent(agentObj) {
    let filteredAgents = props.agents.filter(
      (agent) => agent.agentId !== agentObj.agentId
    );
    props.setAgents([agentObj, ...filteredAgents]);
  }

  function handleSubmit(e) {
    e.preventDefault();
    let agentCopy = { ...props.agentObj };
    agentCopy.firstName = firstName;

    fetch("http://localhost:8080/api/agent/" + agentCopy.agentId, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(agentCopy),
    })
      .then((response) =>
        response.ok
          ? replaceAgent(agentCopy)
          : alert("Something went wrong!" + response)
      )
      .catch((rejection) => alert(rejection));
  }

  return (
    <form onSubmit={handleSubmit}>
      <label for="first-name">First Name:</label>
      <br />
      <br />
      <input onChange={handleFirstNameChange} id="first-name"></input>
      <br />
      <button>Submit</button>
    </form>
  );
}

export default Form;
