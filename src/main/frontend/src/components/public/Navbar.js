import React from 'react';
import { Link } from 'react-router-dom';
import 'css/App.scss';
import UserButton from 'components/UserButton';

const LINKS = ['Home', 'Collect', 'Donate', 'Volunteer', 'Contact'];

var Navbar = () => (
    <div id="navbar">
        <Link to="/" id="logo">
            <div>
                <h1>fb</h1>
                <h1 id="logoIconHelper">I</h1>
            </div>
                <h1>foodbank</h1>
        </Link>
        <div/>
        <div className="navbar-link-group">
            { LINKS.map(link => {
                return link === 'Home' ?
                    <Link key="Home" to="/"><h5>Home</h5></Link> :
                    <Link key={ link } to={ '/' + link.toLowerCase() }><h5>{ link }</h5></Link>
            })}            
            <UserButton/>
        </div>
    </div>
);

export default Navbar;
