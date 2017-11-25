package bdd.demo.springbootcxf.controller;

import bdd.weather.weatherdatatype.WeatherRequest;
import bdd.weather.weatherdatatype.WeatherResponse;

public class WeatherServiceController {

    public WeatherResponse getWeatherInformation(WeatherRequest parameters) {
        WeatherResponse response = new WeatherResponse();
        response.setReturnCode(1);
        response.setReturnText("Weather in " + parameters.getZIP() + " is fine");
        return response;
    }
    
}
