import { Toaster, Intent } from '@blueprintjs/core';

const TOASTER = Toaster.create();

async function getCsrf() {

    let response = await fetch('/api/csrf');
    let json = await response.json();
    return json.token;
}

async function helpSubmitForm(path, body, successMessage, successCallback) {

    let response = await fetch(path, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': await getCsrf()
        },
        body: JSON.stringify(body)
    });
    
    if (response.status === 200 || response.status === 302) {
    
        successMessage && TOASTER.show({
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

    if (response.redirected) {
    
        window.location = response.url;
    }
}

export default helpSubmitForm;
