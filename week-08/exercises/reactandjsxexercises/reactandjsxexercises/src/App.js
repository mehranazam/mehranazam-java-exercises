import React from "react";
import Heading from "./Heading.js";
import Numbers from "./Numbers.js";
import Movies from "./Movies.js";
function App() {
  return (
    <>
      <Heading text={"Hello World"} />
      <Heading text={"Wubulubduuuuub"} />
      <Numbers min={2} max={15} />
      <Movies />
    </>
  );
}

export default App;
