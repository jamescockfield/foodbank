export const Role = {
    ANONYMOUS: 'ROLE_ANONYMOUS',
    VOLUNTEER: 'ROLE_VOLUNTEER',
    MANAGER: 'ROLE_MANAGER'
}

const UPDATE_ROLE = 'UPDATE_ROLE';
export const updateRole = role => ({
    type: UPDATE_ROLE,
    role 
});

export const roleReducer = (state = Role.ANONYMOUS, action) =>  {

    switch (action.type) {

        case UPDATE_ROLE:
            return Object.values(Role).includes(action.role) ? action.role : state;

        default:
            return state;
    }
}

const UPDATING = 'UPDATING';
export const setUpdating = updating => ({
    type: UPDATING,
    updating
});

export const updatingReducer = (state = false, action) => 
    action.type === UPDATING ? action.updating : state;

export const getRole = store => {

    store.dispatch(setUpdating(true));

    fetch('/api/auth')
        .then(res => res.text())
        .then(res => {
            store.dispatch(updateRole(res));
            store.dispatch(setUpdating(false));
        });
}
