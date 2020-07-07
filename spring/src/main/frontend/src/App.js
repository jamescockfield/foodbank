import React, {Component, useState, useEffect} from 'react';
import './App.scss';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

function App () {
    return (
        <div id="app">
            <Router>
            <div id="navbar">
                <div id="logoIcon">
                    <h1>fb</h1>
                </div>
                <div>
                    <h1 id="logoText">foodbank</h1>
                </div>
                <div/>
                <div>
                    <Link to="/collect"><h5>Collect</h5></Link>
                    <Link to="/donate"><h5>Donate</h5></Link>
                    <Link to="/contact"><h5>Contact</h5></Link>
                    <Link to="/login"><h5>Login</h5></Link>
                </div>
            </div>
            <img id="banner" src="http://localhost:8080/img/banner.jpg"/>
            <p className="App-intro">
                To get started, edit <code>src/App.js</code> and save to reload.
            </p>
            <Switch>
                <Route path="/">
                    
                </Route>
                <Route path="/collect">
                    
                </Route>
                <Route path="/donate">
                    
                </Route>
                <Route path="/contact">
                    
                </Route>
                <Route path="/login">
                    
                </Route>
            </Switch>
            </Router>
        </div>
    )
}

export default App;
