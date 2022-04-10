import { Link } from "react-router-dom";

function NavBar({ userStatus }) {
  return (
    <nav>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/add">Add</Link>
        </li>
        {userStatus.user ? (
          <li>
            <button onClick={userStatus.logout}>
              Logout {userStatus.user}
            </button>
          </li>
        ) : (
          <li>
            <Link to="/login">Login</Link>
          </li>
        )}
      </ul>
    </nav>
  );
}

export default NavBar;
