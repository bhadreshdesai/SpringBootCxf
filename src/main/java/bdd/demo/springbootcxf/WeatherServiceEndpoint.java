package bdd.demo.springbootcxf;

import bdd.weather.weatherdatatype.WeatherRequest;
import bdd.weather.weatherdatatype.WeatherResponse;
import bdd.weather.weatherservice.GetWeatherInformationFault;
import bdd.weather.weatherservice.WeatherService;

/**
 *
 * @author desabh
 */
public class WeatherServiceEndpoint implements WeatherService {

    @Override
    public WeatherResponse getWeatherInformation(WeatherRequest parameters) throws GetWeatherInformationFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
