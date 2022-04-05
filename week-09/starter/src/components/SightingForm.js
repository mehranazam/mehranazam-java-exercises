import { useState } from "react";
// UPDATED: Import `useHistory` from react-router-dom
import { Link, useHistory } from "react-router-dom";

const DEFAULT_SIGHTING = {
  bugType: "",
  order: "",
  description: "",
  date: "",
  interest: "",
  imageUrl: "",
};

function SightingForm() {
  const [sighting, setSighting] = useState(DEFAULT_SIGHTING);

  // NEW: Call the `useHistory` hook
  const history = useHistory();

  const handleChange = (event) => {
    const updatedSighting = { ...sighting };
    updatedSighting[event.target.name] = event.target.value;
    setSighting(updatedSighting);
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    const updatedSighting = { ...sighting };

    // NEW: Use fetch to POST to the service

    const init = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      body: JSON.stringify(updatedSighting),
    };

    fetch("http://localhost:8080/sighting", init)
      .then((response) => {
        if (response.status !== 201) {
          return Promise.reject("response is not 200 OK");
        }
        return response.json();
      })
      .then((data) => {
        // redirect the user to the confirmation route if the add is successful
        history.push("/confirmation", { msg: "👍🏾" });
      })
      .catch(() => {
        // otherwise redirect the user to the error route
        history.push("/error", { msg: "👎🏾" });
      });
  };

  return <form onSubmit={handleSubmit}>{/* snip! */}</form>;
}

export default SightingForm;
