import React from 'react';
import '../css/App.scss';

var Login = () => (
    <div className="padding-large">
        <p className="medium-text padding-medium">
            This is the login page 
        </p>
        <form>
            <input placeholder="Email"/>
            <input placeholder="Password"/>
            <button>Submit</button>
        </form>
    </div>
);

export default Login;
