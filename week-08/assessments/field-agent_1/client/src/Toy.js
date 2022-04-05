import { useState, useEffect } from "react";
function Toy() {
  const [beenClicked, setBeenClicked] = useState(false);

  useEffect(() => {
    console.log("Has been clicked: ", beenClicked);
  }, [beenClicked]);

  function toggleMode() {
    const frame = document.getElementById("frame");
    if (frame.classList.contains("dark-mode")) {
      frame.classList.remove("dark-mode");
      frame.classList.add("light-mode");
    } else {
      frame.classList.remove("light-mode");
      frame.classList.add("dark-mode");
    }
  }

  return (
    <div>
      <button onClick={() => setBeenClicked(!beenClicked)}>PUSH ME</button>;
    </div>
  );
}

export default Toy;
