import React from 'react';
import 'css/App.scss';
import helpSubmitForm from 'helpers/FormHelper.js';

class Register extends React.Component {

    handleSubmit(e) {
    
        e.preventDefault();

        helpSubmitForm('/api/register', {
            email: this.email.value,
            password: this.password.value,
            userType: this.userType.value
        }, 'Account created');
    }

    render() {
        return (
            <div className="padding-large">
                <p className="medium-text padding-medium">This is the register page</p>
                <form onSubmit={ e => this.handleSubmit(e) }>
                    <input placeholder="Email" ref={ node => this.email = node } />
                    <input placeholder="Password" type="password" ref={ node => this.password = node } />
                    <input placeholder="Repeat Password" type="password" ref={ node => this.repeatPassword = node } />
                    <select ref={ node => this.userType = node }>
                        <option value="Volunteer">Volunteer</option>
                        <option value="Manager">Manager</option>
                    </select>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        );
    }
}

export default Register;
