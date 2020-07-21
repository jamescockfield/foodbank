import React from 'react';
import { Link } from 'react-router-dom';
import { Icon, Menu, Popover, Position } from '@blueprintjs/core';
import { IconNames } from '@blueprintjs/icons';

var user = {
    isLoggedIn: true,
    userType: 'Manager'
};

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
        icon: IconNames.CALENDAR
    },
    'Settings': {
        href: "/settings",
        icon: IconNames.COG
    },
    'Log Out': {
        href: "/logout",
        icon: IconNames.LOG_OUT
    }
} 

function renderOptions(options) {
    return Object.getOwnPropertyNames(options).map(name =>
        <Menu.Item 
            key={ name } 
            text={ name } 
            href={ 
                options[name].href && options[name].href 
            } 
            labelElement={
                options[name].icon && <Icon icon={ options[name].icon }/>
            }
        />
    )
}

var UserButton = () => {

    return !user.isLoggedIn ?
        <Link to="/login"><h5>Login</h5></Link> :
        <Popover content={ loggedInMenu } position={ Position.BOTTOM_LEFT }>
            <Icon icon={IconNames.USER} iconSize={25} className="underline"/>
        </Popover>;
}

var loggedInMenu = (
    <Menu>
        { user.userType === 'Manager' ?
            renderOptions({ ...MANAGER_OPTIONS, ...ALL_USER_OPTIONS }) :
            renderOptions({ ...ALL_USER_OPTIONS })
        }
    </Menu>
);

export default UserButton;
