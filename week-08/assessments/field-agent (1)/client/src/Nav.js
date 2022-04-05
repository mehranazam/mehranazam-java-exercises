import { Link } from "react-router-dom";

function Nav() {
  return (
    <div className="nav">
      <Link to="/">Home</Link>
      <Link to="agents">Show All Agents</Link>
      <Link to="add">New Agent</Link>
    </div>
  );
}

export default Nav;
