import React from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import '../css/App.scss';
import Navbar from './Navbar.js';
import Carousel from './Carousel.js';
import Home from './Home.js';
import Collect from './Collect.js';
import Donate from './Donate.js';
import Contact from './Contact.js';
import Login from './Login.js';

function App () {
    return (
        <div id="app">
            <Router>
            <Navbar/>
            <Carousel/>
            <Switch>
                <Route path="/collect">
                   <Collect/> 
                </Route>
                <Route path="/donate">
                   <Donate/> 
                </Route>
                <Route path="/contact">
                   <Contact/> 
                </Route>
                <Route path="/login">
                   <Login/> 
                </Route>
                <Route path="/">
                   <Home/> 
                </Route>
            </Switch>
            </Router>
        </div>
    )
}

export default App;
