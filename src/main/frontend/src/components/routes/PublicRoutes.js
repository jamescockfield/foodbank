import { Route } from 'react-router-dom';
import { routeMapper } from 'components/routes/Routes';
import Home from 'components/public/Home';
import Collect from 'components/public/Collect';
import Donate from 'components/public/Donate';
import Volunteer from 'components/public/Volunteer';
import Contact from 'components/public/Contact';
import Login from 'components/public/Login';

const routes = {
    '/collect': Collect,
    '/donate':  Donate,
    '/volunteer': Volunteer,
    '/contact': Contact,
    '/login': Login,
    '/': Home
};

const PublicRoutes = routeMapper(routes, Route);

export default PublicRoutes;
