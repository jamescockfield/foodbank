import React from 'react';
import 'css/App.scss';
import helpSubmitForm from 'helpers/FormHelper.js';

class Login extends React.Component {

    handleSubmit(e) {

        e.preventDefault();

        helpSubmitForm('/api/login', {
            email: this.email.value,
            password: this.password.value
        }, 'Login successful');
    }

    render() {

        return (
            <div className="padding-large">
                <p className="medium-text padding-medium">
                    This is the login page 
                </p>
                <form onSubmit={ e => this.handleSubmit(e) }>
                    <input placeholder="Email" ref={ node => this.email = node } />
                    <input placeholder="Password" type="password" ref={ node => this.password = node } />
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        );
    }
}

export default Login;
