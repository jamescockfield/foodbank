import React from 'react';
import 'css/App.scss';
import Map from 'components/public/Map.js';
import ContactForm from 'components/public/ContactForm.js';

var Contact = () => (
    <div className="vertical-split">
        <div>
            <p className="medium-text">This is the contact page</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum ornare et ligula at lobortis. Integer tristique nunc quam, id dictum neque suscipit a. Vestibulum mattis imperdiet arcu, non tempor ligula eleifend et. Ut et arcu id augue iaculis dapibus vel sed ligula. Nullam varius odio non aliquam consequat. Curabitur egestas id sem et auctor. Nam vehicula ultrices elit, non commodo libero imperdiet a. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            <p>Quisque quam nibh, pulvinar ac neque at, malesuada blandit massa. Phasellus vel massa quis ante hendrerit condimentum quis pulvinar est. Sed eleifend libero et eros congue, quis dapibus mauris maximus. Nunc auctor sodales libero, at vehicula neque convallis sagittis.</p>
            <div className="padding-medium center-text">
                <p>Segeberger Tafel e.V.</p>
                <p>Efeustr. 1 - 23795 Bad Segeberg</p>
                <p>Tel.: 04551 - 2951 - Fax: 04551 - 943879</p>
                <p>E-Mail: kontakt@segeberger-tafel.de</p>
            </div>
            <Map/>
        </div>
        <div>
            <ContactForm/>
        </div>
    </div>
);

export default Contact;
