package bdd.demo.springbootcxf;

import bdd.demo.springbootcxf.configuration.WebServiceConfiguration;
import bdd.weather.weatherdatatype.WeatherRequest;
import bdd.weather.weatherdatatype.WeatherResponse;
import bdd.weather.weatherservice.GetWeatherInformationFault;
import bdd.weather.weatherservice.WeatherService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCxfApplicationTests {
    
    public WeatherService getWeatherService() throws GetWeatherInformationFault {
        JaxWsProxyFactoryBean jaxWsProxyFactory = new JaxWsProxyFactoryBean();
        jaxWsProxyFactory.setServiceClass(WeatherService.class);
        jaxWsProxyFactory.setAddress("http://localhost:8080" + WebServiceConfiguration.BASE_URL + WebServiceConfiguration.SERVICE_URL);
        return (WeatherService) jaxWsProxyFactory.create();
    }

    @Test
    public void weatherInfoMumbai() throws GetWeatherInformationFault {
        String city = "Mumbai";
        WeatherService service = getWeatherService();
        WeatherRequest parameters = new WeatherRequest();
        parameters.setZIP(city);
        WeatherResponse response = service.getWeatherInformation(parameters);
        Assert.assertEquals("Weather in Mumbai is fine", response.getReturnText());
    }
    
    @Test
    public void weatherInfoDelhi() throws GetWeatherInformationFault {
        String city = "Delhi";
        WeatherService service = getWeatherService();
        WeatherRequest parameters = new WeatherRequest();
        parameters.setZIP(city);
        WeatherResponse response = service.getWeatherInformation(parameters);
        Assert.assertEquals("Weather in Delhi is cold", response.getReturnText());
    }
    
    @Test
    public void weatherInfoTimbakTo() throws GetWeatherInformationFault {
        String city = "TimbakTo";
        WeatherService service = getWeatherService();
        WeatherRequest parameters = new WeatherRequest();
        parameters.setZIP(city);
        WeatherResponse response = service.getWeatherInformation(parameters);
        Assert.assertEquals("Unknown city", response.getReturnText());
    }

}
