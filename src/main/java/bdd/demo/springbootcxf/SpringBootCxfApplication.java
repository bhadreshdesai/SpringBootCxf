package bdd.demo.springbootcxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("bdd.demo.springbootcxf")
public class SpringBootCxfApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCxfApplication.class, args);
    }
}
