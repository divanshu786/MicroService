package com.example.Currency_Exchange_Service.Controller;

import com.example.Currency_Exchange_Service.Model.Currency;
import com.example.Currency_Exchange_Service.Repo.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyController {
    @Autowired
    CurrencyRepo repo;
    @Autowired
    Environment environment;


    @GetMapping("from/{from}/to/{to}")
    public Currency currencyExchange(@PathVariable String from,@PathVariable String to){
        System.out.println("hello");
        Currency currency = repo.findByFromAndTo(from,to);
        String port = environment.getProperty("server.port");
        currency.setEnvironment(port + "currency exchange");
        return currency;
    }
}
