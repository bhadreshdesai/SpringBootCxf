package bdd.demo.springbootcxf.configuration;

import bdd.demo.springbootcxf.controller.WeatherServiceController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public WeatherServiceController weatherServiceController() {
        return new WeatherServiceController();
    }
}
