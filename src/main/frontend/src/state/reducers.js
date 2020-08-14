import { combineReducers } from 'redux';
import { 
    roleReducer as role, 
    updatingReducer as updating 
} from 'state/role';

export default combineReducers({
    role,
    updating
});
