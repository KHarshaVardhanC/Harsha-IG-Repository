import React from "react";
import { BrowserRouter as Router, Route, Routes, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

const HomePage = () => <h2 className="text-center mt-3">Home Page</h2>;
const LoginComponent = () => <h2 className="text-center mt-3">Login Page</h2>;
const SignupComponent = () => <h2 className="text-center mt-3">Signup Page</h2>;

const RoutingApp = () => {
  return (
    <Router>
      <div className="container mt-3">
        <nav className="nav nav-pills nav-justified">
          <Link className="nav-link" to="/">Home</Link>
          <Link className="nav-link" to="/login">Login</Link>
          <Link className="nav-link" to="/signup">Signup</Link>
        </nav>
        
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/login" element={<LoginComponent />} />
          <Route path="/signup" element={<SignupComponent />} />
        </Routes>
      </div>
    </Router>
  );
};

export default RoutingApp;
