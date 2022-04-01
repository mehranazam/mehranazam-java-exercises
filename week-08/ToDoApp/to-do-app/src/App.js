import Heading from "./Heading";
import Container from "./Container";
import Form from "./Form";
import List from "./List";
import { useState } from "react";

function App() {
  const [toDo, setToDo] = useState([]);

  function buttonHandler() {
    setToDo(todoapp.toDo);
  }

  function deleteToDo(id) {
    let newToDoArray = [...toDo];
    setToDo(newToDoArray.filter((toDo) => toDo.id !== id));
  }

  function addToDo(toDoNum, e) {
    e.preventDefault();
    let newToDoArray = [...toDo];
    let foundToDo = newToDoArray.filter(toDo => toDo.num === toDoNum);
    let allNewToDoArray = [...];
  }
}

export default App;
