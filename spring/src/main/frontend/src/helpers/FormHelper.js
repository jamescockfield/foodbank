import { Toaster, Intent } from '@blueprintjs/core';
import { validate } from 'email-validator';

const TOASTER = Toaster.create();

function helpSubmitForm(path, body, successMessage, successCallback) {

    console.log(validate(body.email));
        
    fetch(path, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    })
        .then(res => res)
        .then(res => {
            
            if (res.status === 200) {
    
                TOASTER.show({
                    message: successMessage,
                    intent: Intent.SUCCESS
                });

                successCallback && successCallback();

            } else if (res.status >= 400) {
    
                TOASTER.show({
                    message: res.statusText,
                    intent: Intent.DANGER
                });
            }
        });
}

export default helpSubmitForm;
