import React from 'react';
import { Link } from 'react-router-dom';
import '../css/App.scss';

var Navbar = () => (
    <div id="navbar">
        <Link to="/" id="logo">
            <div>
                <h1>fb</h1>
                <h1 id="logoIconHelper">I</h1>
            </div>
            <div>
                <h1>foodbank</h1>
            </div>
        </Link>
        <div/>
        <div>
            <Link to="/"><h5>Home</h5></Link>
            <Link to="/collect"><h5>Collect</h5></Link>
            <Link to="/donate"><h5>Donate</h5></Link>
            <Link to="/contact"><h5>Contact</h5></Link>
            <Link to="/login"><h5>Login</h5></Link>
        </div>
    </div>
);

export default Navbar;
