import React from 'react';
import 'css/App.scss';

var Map = () => (
    <div id="map">
        <iframe 
            title="local"
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1975.3617785203026!2d10.311484608650515!3d53.92971350656599!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47b23e3b21b88ed5%3A0xe1ab43a417e6aed7!2sSegeberger%20Tafel%20e.V.!5e0!3m2!1sen!2sde!4v1594390060605!5m2!1sen!2sde" 
            width="600" 
            height="450" 
            frameBorder="0" 
            style={{border:0}} 
            allowFullScreen="" 
            aria-hidden="false" 
            tabIndex="0">
        </iframe>
    </div>
);

export default Map;
