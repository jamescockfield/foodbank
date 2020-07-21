import React from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import 'css/App.scss';
import Register from 'components/Register';
import Navbar from 'components/public/Navbar';
import Carousel from 'components/public/Carousel';
import Home from 'components/public/Home';
import Collect from 'components/public/Collect';
import Donate from 'components/public/Donate';
import Volunteer from 'components/public/Volunteer';
import Contact from 'components/public/Contact';
import Login from 'components/public/Login';

function App () {
    return (
        <div id="app" className="bp3-dark">
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
                <Route path="/volunteer">
                    <Volunteer/>
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
