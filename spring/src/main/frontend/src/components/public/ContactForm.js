import React from 'react';
import 'css/App.scss';
import helpSubmitForm from 'helpers/FormHelper.js';

const INITIAL_STATE = {
    name: '',
    email: '',
    message: '',
    submitDisabled: false
};

class ContactForm extends React.Component {

    constructor(props) {

        super(props);
        this.state = INITIAL_STATE;
    }

    handleChange(e) {

        this.setState({ [e.target.placeholder.toLowerCase()]: e.target.value });
    }

    handleSubmit(e) {

        e.preventDefault();

        let payload = { ...this.state };
        delete payload.submitDisabled;

        helpSubmitForm('/api/contact', payload, 'Message sent', () => {

            this.setState({ ...INITIAL_STATE, submitDisabled: true });

            setTimeout(() => {

                this.setState({ submitDisabled: false });
            }, 2000);
        });
    }

    render() {

        return (
            <form id="contact-form" onSubmit={ e => this.handleSubmit(e) }>
                <input placeholder="Name" value={ this.state.name } onChange={ e => this.handleChange(e) }/>
                <input placeholder="Email" value={ this.state.email } onChange={ e => this.handleChange(e) }/>
                <textarea placeholder="Message" value={ this.state.message } onChange={ e => this.handleChange(e) }/>
                <input type="submit" value="Submit" disabled={ this.state.submitDisabled }/>
            </form>
        );
    }
}

export default ContactForm;
