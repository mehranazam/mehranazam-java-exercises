import { Link } from "react-router-dom";
import NavSpace from "./NavSpace";

function Nav() {
  return (
    <div className="nav">
      <Link to="/">Home</Link>
      <NavSpace />
      <Link to="agents">Show All Agents</Link>
      <NavSpace />
      <Link to="add">Add New Agent</Link>
      <NavSpace />
      <Link to="news">Agent News</Link>
    </div>
  );
}

export default Nav;
