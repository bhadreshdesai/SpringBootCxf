package bdd.demo.springbootcxf.configuration;

import bdd.demo.springbootcxf.WeatherServiceEndpoint;
import bdd.weather.weatherservice.Weather;
import bdd.weather.weatherservice.WeatherService;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfiguration {

    public static final String BASE_URL = "/soapservices";
    public static final String SERVICE_URL = "/WeatherService";

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), BASE_URL + "/*");
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), weatherService());
        endpoint.setServiceName(weather().getServiceName());
        endpoint.setWsdlLocation(weather().getWSDLDocumentLocation().toString());
        endpoint.publish(SERVICE_URL);
        
        LoggingFeature logFeature = new LoggingFeature();
        logFeature.setPrettyLogging(true);
        logFeature.initialize(springBus());
        endpoint.getFeatures().add(logFeature);      
        
        return endpoint;
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Weather weather() {
        return new Weather();
    }

    @Bean
    public WeatherService weatherService() {
        return new WeatherServiceEndpoint();
    }
}
