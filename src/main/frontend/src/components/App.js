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
import PublicRoutes from 'components/routes/PublicRoutes';
import VolunteerRoutes from 'components/routes/VolunteerRoutes';
import ManagerRoutes from 'components/routes/ManagerRoutes';

function App () {
    return (
        <div id="app" className="bp3-dark">
            <Router>
            <Navbar/>
            <Carousel/>
            <Switch>
                { ManagerRoutes }
                { VolunteerRoutes }
                <Route path="/register">
                   <Register/> 
                </Route>
                { PublicRoutes }
            </Switch>
            </Router>
        </div>
    )
}

export default App;
