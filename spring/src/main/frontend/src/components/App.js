import React from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import 'css/App.scss';
import Navbar from 'components/public/Navbar.js';
import Register from 'components/Register.js';
import Carousel from 'components/public/Carousel.js';
import Home from 'components/public/Home.js';
import Collect from 'components/public/Collect.js';
import Donate from 'components/public/Donate.js';
import Contact from 'components/public/Contact.js';
import Login from 'components/public/Login.js';

function App () {
    return (
        <div id="app">
            <Router>
            <Navbar/>
            <Carousel/>
            <Switch>
                <Route path="/register">
                   <Register/> 
                </Route>
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
