import { routeMapper, VolunteerRoute } from 'components/Routes';
import Calendar from 'components/volunteer/Calendar';
import Settings from 'components/volunteer/Settings';

const routes = {
    '/calendar': Calendar,
    '/settings': Settings
};

const VolunteerRoutes = routeMapper(routes, VolunteerRoute);

export default VolunteerRoutes;
