import Heading from "./Heading";
import Numbers from "./Numbers";
import Movies from "./Movies";

function App() {
  return (
    <>
      <Heading message={"Hello World!"} />
      <Heading message={"Hello Folks!"} />
      <Heading message={"Hello Sun!"} />
      <Numbers min={4} max={17} />
      <Movies />
    </>
  );
}

export default App;