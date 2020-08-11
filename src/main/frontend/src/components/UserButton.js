import React from 'react';
import { Link } from 'react-router-dom';
import { Icon, Menu, Popover, Position } from '@blueprintjs/core';
import { IconNames } from '@blueprintjs/icons';
import Role from 'helpers/Role';
import helpSubmitForm from 'helpers/FormHelper';

const MANAGER_OPTIONS = {
    'Manage Donors': {
        href: "/manage/donors"
    },
    'Manage Volunteers': {
        href: "/manage/volunteers"
    } 
};

const ALL_USER_OPTIONS = {
    'Calendar': {
        href: "/calendar",
        labelElement: IconNames.CALENDAR
    },
    'Settings': {
        href: "/settings",
        labelElement: IconNames.COG
    },
    'Log Out': {
        labelElement: IconNames.LOG_OUT,
        onClick: () => {
            helpSubmitForm('/api/logout', {}, 'Logout successful')
        }
    }
} 

function renderOptions(options) {
    return Object.getOwnPropertyNames(options).map(name =>
        <Menu.Item 
            {...{
                key: name,
                text: name,
                ...options[name],
                labelElement: options[name].labelElement && <Icon icon={ options[name].labelElement }/>
            }}
        />
    )
}

class UserButton extends React.Component {

    constructor(props) {

        super(props);
        this.state = {};
    }

    componentDidMount() {

        fetch('/api/auth')
            .then(res => res.text())
            .then(res => this.setState({role: res}));
    }

    render() {

        return this.state.role === Role.ANONYMOUS ?
            <Link to="/login"><h5>Login</h5></Link> :
            <Popover content={ loggedInMenu(this.state.role) } position={ Position.BOTTOM_LEFT }>
                <Icon icon={IconNames.USER} iconSize={25} className="underline"/>
            </Popover>;
    }
}

var loggedInMenu = role => (
    <Menu>
        { role === Role.MANAGER ?
            renderOptions({ ...MANAGER_OPTIONS, ...ALL_USER_OPTIONS }) :
            renderOptions({ ...ALL_USER_OPTIONS })
        }
    </Menu>
);

export default UserButton;
