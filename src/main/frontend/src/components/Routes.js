import React from 'react'; 
import { Route, Redirect } from 'react-router-dom';
import { connect } from 'react-redux';
import { Role } from 'state/role';

/**
 * Renders a routemap into a list of route components, to reduce boilerplate code
 * across long lists of potential routes
 */
export const routeMapper = (routeMap, RouteComponentType) => {

    let routeComponents = Object.keys(routeMap).map((path, i) => {

        let ViewComponent = routeMap[path];

        return <RouteComponentType path={ path } key={ i }>
            <ViewComponent/>
        </RouteComponentType>
    });

    return () => routeComponents;
};

const PrivateRouteComponent = ({ children, roleRequirement, ...rest }) => (

    <Route { ...rest }
        render={ ({ location }) =>

            rest.role === roleRequirement ?
                children :
                <Redirect to={{
                    pathname: "/login",
                    state: { from: location }
                }} />
        }
    />
);

const mapStateToProps = state => ({
    role: state.role
});

export const PrivateRoute = connect(mapStateToProps)(PrivateRouteComponent);

export const VolunteerRoute = ({ children, ...rest }) => (
    <PrivateRoute { ...rest } roleRequirement={ Role.ROLE_VOLUNTEER }>
        { children }
    </PrivateRoute>
);

export const ManagerRoute = ({ children, ...rest }) => (
    <PrivateRoute { ...rest } roleRequirement={ Role.ROLE_MANAGER }>
        { children }
    </PrivateRoute>
);
