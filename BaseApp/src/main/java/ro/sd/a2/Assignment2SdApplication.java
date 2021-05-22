package ro.sd.a2;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableRabbit
public class Assignment2SdApplication {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    };

    public static void main(String[] args) {
        SpringApplication.run(Assignment2SdApplication.class, args);
    }

}
