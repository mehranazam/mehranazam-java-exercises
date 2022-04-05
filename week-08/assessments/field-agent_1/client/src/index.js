import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import { render } from "react-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App";
import Home from "./Home";
import Nav from "./Nav";
import Header from "./Header";
import Agents from "./Agents";
import AddAgent from "./AddAgent";
import AgentNews from "./AgentNews";

ReactDOM.render(
  <BrowserRouter>
    <Header />
    <Nav />
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="agents" element={<Agents />} />
      <Route path="/add" element={<AddAgent />} />
      <Route path="news" element={<AgentNews />} />
    </Routes>
  </BrowserRouter>,
  document.getElementById("root")
);
