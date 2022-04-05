import { useState } from "react";

function Form(props) {
  const [input, setInput] = useState("");

  function onChangeHandler(event) {
    setInput(event.target.value);
  }

  return (
    <form onSubmit={(e) => props.addToDo(input, e)}>
      <label for="toDoInputNumber">Enter To-Do Number</label>
      <br />
      <br />
      <input onChange={onChangeHandler} id="toDoInputNumber"></input>
      <button type="submit">Submit</button>
    </form>
  );
}

export default Form;
