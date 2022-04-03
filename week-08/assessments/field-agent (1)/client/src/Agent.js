import Form from "./Form";

function Agent(props) {
  const { firstName, lastName, middleName, dob, heightInInches } =
    props.agentObj;

  return (
    <div className="agent-card">
      <p>
        <b>First Name:</b> {firstName}
      </p>
      <p>
        <b>Middle Name:</b> {middleName}
      </p>
      <p>
        <b>Last Name:</b> {lastName}
      </p>
      <p>
        <b>DOB:</b> {dob}
      </p>
      <p>
        <b>Height (in):</b> {heightInInches}
      </p>
      <Form
        agentObj={props.agentObj}
        agents={props.agents}
        setAgents={props.setAgents}
      />
    </div>
  );
}

export default Agent;
