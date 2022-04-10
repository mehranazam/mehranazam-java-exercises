import {
  BrowserRouter as Router,
  Route,
  Switch,
  Redirect,
} from "react-router-dom";
import { useState } from "react";
import Confirmation from "./components/Confirmation";
import Error from "./components/Error";
import Home from "./components/Home";
import NavBar from "./components/NavBar";
import NotFound from "./components/NotFound";
import SightingForm from "./components/SightingForm";
import Login from "./components/Login";

function App() {
  const [userStatus, setUserStatus] = useState({
    user: null,
    login(username) {
      // Use previous state to preserve login and logout methods when updating user
      setUserStatus((prev) => ({ ...prev, user: username }));
    },
    logout() {
      // "token" must match the name used in "/Login" route
      localStorage.removeItem("token");
      setUserStatus((prev) => ({ ...prev, user: null }));
    },
  });

  return (
    <Router>
      <NavBar />

      <Switch>
        <Route path={["/edit/:id", "/add"]}>
          <SightingForm />
        </Route>

        <Route path="/confirmation">
          <Confirmation />
        </Route>

        <Route path="/error">
          <Error />
        </Route>
        <Route>
          {userStatus.user ? (
            <Redirect to="/" />
          ) : (
            <Login userStatus={userStatus} />
          )}
        </Route>
        <Route exact path="/">
          <Home />
        </Route>

        <Route>
          <NotFound />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
