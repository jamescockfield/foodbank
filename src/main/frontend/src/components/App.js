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
import PublicRoutes from 'components/public/PublicRoutes';
import VolunteerRoutes from 'components/volunteer/VolunteerRoutes';
import ManagerRoutes from 'components/manager/ManagerRoutes';

function App () {
    return (
        <div id="app" className="bp3-dark">
            <Router>
            <Navbar/>
            <Carousel/>
            <Switch>
                <VolunteerRoutes/>
                <ManagerRoutes/>
                <Route path="/register">
                   <Register/> 
                </Route>
                <PublicRoutes/>
            </Switch>
            </Router>
        </div>
    )
}

export default App;
