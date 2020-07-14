import React, { Component } from 'react';
import Slider from 'infinite-react-carousel';

class Carousel extends Component {
  render() {
    const settings =  {
      arrowsBlock: false,
      autoplay: true,
      autoplaySpeed: 4000
    };
    return (
      <div id="banner">
        <Slider { ...settings }>
          <div>
            <img alt='' src="http://localhost:8080/img/banner-1.jpg"/>
          </div>
          <div>
            <img alt='' src="http://localhost:8080/img/banner-2.jpg"/>
          </div>
          <div>
            <img alt='' src="http://localhost:8080/img/banner-3.jpg"/>
          </div>
          <div>
            <img alt='' src="http://localhost:8080/img/banner-4.jpg"/>
          </div>
        </Slider>
      </div>
    );
  }
}

export default Carousel;
