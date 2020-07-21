import { Toaster, Intent } from '@blueprintjs/core';
import { validate } from 'email-validator';

const TOASTER = Toaster.create();

async function getCsrf() {

    let response = await fetch('/api/csrf');
    let json = await response.json();
    return json.token;
}

async function helpSubmitForm(path, body, successMessage, successCallback) {

    console.log("todo: implement frontend validation");
    console.log(validate(body.email));

    let response = await fetch(path, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': await getCsrf()
        },
        body: JSON.stringify(body)
    });
    
    if (response.status === 200) {
    
        TOASTER.show({
            message: successMessage,
            intent: Intent.SUCCESS
        });

        successCallback && successCallback();

    } else if (response.status >= 400) {
    
        TOASTER.show({
            message: response.statusText,
            intent: Intent.DANGER
        });
    }
}

export default helpSubmitForm;
