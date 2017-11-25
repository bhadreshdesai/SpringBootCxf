package bdd.demo.springbootcxf;

import bdd.demo.springbootcxf.controller.WeatherServiceController;
import bdd.weather.weatherdatatype.WeatherRequest;
import bdd.weather.weatherdatatype.WeatherResponse;
import bdd.weather.weatherservice.GetWeatherInformationFault;
import bdd.weather.weatherservice.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;

public class WeatherServiceEndpoint implements WeatherService {
    @Autowired
    WeatherServiceController weatherServiceController;

    @Override
    public WeatherResponse getWeatherInformation(WeatherRequest parameters) throws GetWeatherInformationFault {
        return weatherServiceController.getWeatherInformation(parameters);
    }
}
