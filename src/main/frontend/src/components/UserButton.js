import React from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import { Icon, Menu, Popover, Position } from '@blueprintjs/core';
import { IconNames } from '@blueprintjs/icons';
import { Role, updateRole } from 'state/role';
import helpSubmitForm from 'helpers/FormHelper';

class UserButton extends React.Component {

    MANAGER_OPTIONS = {
        'Manage Donors': {
            href: "/manage/donors"
        },
        'Manage Volunteers': {
            href: "/manage/volunteers"
        } 
    };
    
    ALL_USER_OPTIONS = {
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
                helpSubmitForm('/api/logout', {}, 'Logout successful', response => {
                    response.text().then(role => {
                        this.setRole(role);
                    });
                });
            }
        }
    } 

    renderOptions(options) {
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

    loggedInMenu() {
        return <Menu>
            { this.props.role === Role.MANAGER ?
                this.renderOptions({ ...this.MANAGER_OPTIONS, ...this.ALL_USER_OPTIONS }) :
                this.renderOptions({ ...this.ALL_USER_OPTIONS })
            }
        </Menu>
    }

    render() {
        return this.props.role === Role.ANONYMOUS ?
            <Link to="/login"><h5>Login</h5></Link> :
            <Popover content={ this.loggedInMenu() } position={ Position.BOTTOM_LEFT }>
                <Icon icon={IconNames.USER} iconSize={25} className="underline"/>
            </Popover>
    }
}

const mapStateToProps = state => ({
    role: state.role
});

const mapDispatchToProps = dispatch => ({
    setRole: role => dispatch(updateRole(role))
});

export default connect(mapStateToProps, mapDispatchToProps)(UserButton);
