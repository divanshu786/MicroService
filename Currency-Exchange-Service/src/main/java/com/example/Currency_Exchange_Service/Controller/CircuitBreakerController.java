package com.example.Currency_Exchange_Service.Controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CircuitBreakerController {


    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("simpleRest")
    @Retry(name = "default")
    public String simple(){
        logger.info("api accessing");

        ResponseEntity<String> entity = new RestTemplate().getForEntity("localhost:8080/get",String.class);
        return entity.getBody();
    }
}
