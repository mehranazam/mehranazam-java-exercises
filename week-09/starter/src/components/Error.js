import { useHistory } from "react-router-dom";

function Error() {
  const history = useHistory();

  return (
    <p>
      🙅🏾‍♂️ Error{" "}
      {history.location.state ? ` - ${history.location.state.msg}` : ""}
    </p>
  );
}

export default Error;
