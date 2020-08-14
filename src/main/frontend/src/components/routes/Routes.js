import React from 'react'; 
import { Route, Redirect } from 'react-router-dom';
import { connect } from 'react-redux';
import { Spinner } from '@blueprintjs/core';
import { Role } from 'state/role';

/**
 * Renders a routemap into a list of route components, to reduce boilerplate code
 * across long lists of potential routes
 */
export const routeMapper = (routeMap, RouteComponentType) =>
    Object.keys(routeMap).map((path, i) => {
    
            let ViewComponent = routeMap[path];
    
            return (<RouteComponentType path={ path } key={ i }>
                <ViewComponent/>
            </RouteComponentType>);
        }
    );

const PrivateRouteComponent = ({ children, roleRequirement, ...rest }) => 
    rest.updating ? 
        <Spinner/> : 
        <Route { ...rest } render={ ({ location }) =>
            rest.role === roleRequirement || rest.role === Role.MANAGER ?
                children : 
                <Redirect to={{
                    pathname: "/login",
                    state: { from: location }
                }}/>
        }/>;

const mapStateToProps = state => ({
    role: state.role,
    updating: state.updating
});

export const PrivateRoute = connect(mapStateToProps)(PrivateRouteComponent);

export const VolunteerRoute = ({ children, ...rest }) => (
    <PrivateRoute { ...rest } roleRequirement={ Role.VOLUNTEER }>
        { children }
    </PrivateRoute>
);

export const ManagerRoute = ({ children, ...rest }) => (
    <PrivateRoute { ...rest } roleRequirement={ Role.MANAGER }>
        { children }
    </PrivateRoute>
);
