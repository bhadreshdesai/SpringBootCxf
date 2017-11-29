package bdd.demo.springbootcxf.controller;

import bdd.weather.weatherdatatype.WeatherRequest;
import bdd.weather.weatherdatatype.WeatherResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WeatherServiceController {
    private static final Map<String, String> CITY = createMap();
    private static Map<String, String> createMap() {
        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("Mumbai", "Weather in Mumbai is fine");
        myMap.put("Delhi", "Weather in Delhi is cold");
        return myMap;
    }

    /*
    private static final Map<Integer, String> myMap = Stream.of(
            new AbstractMap.SimpleEntry<>(1, "one"),
            new AbstractMap.SimpleEntry<>(2, "two"))
            .collect(Collectors.toMap((entry) -> entry.getKey(), (entry) -> entry.getValue()));
    */
    
    public WeatherResponse getWeatherInformation(WeatherRequest parameters) {
        WeatherResponse response = new WeatherResponse();
        response.setReturnCode(1);
        String text = Optional.ofNullable(CITY.get(parameters.getZIP())).orElse("Unknown city");
        //response.setReturnText("Weather in " + parameters.getZIP() + " is fine");
        response.setReturnText(text);
        return response;
    }
}
