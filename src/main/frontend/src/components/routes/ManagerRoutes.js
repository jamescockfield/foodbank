import { routeMapper, ManagerRoute } from 'components/routes/Routes';
import Donors from 'components/manage/Donors';
import Volunteers from 'components/manage/Volunteers';

const routes = {
    '/manage/donors': Donors,
    '/manage/volunteers': Volunteers,
};

const ManagerRoutes = routeMapper(routes, ManagerRoute);

export default ManagerRoutes;
