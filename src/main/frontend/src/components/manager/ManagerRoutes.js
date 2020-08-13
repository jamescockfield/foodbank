import { routeMapper, ManagerRoute } from 'components/Routes';

const routes = {
    '/manage': 'div'
};

const ManagerRoutes = routeMapper(routes, ManagerRoute);

export default ManagerRoutes;
