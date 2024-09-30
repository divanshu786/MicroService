package com.example.Currency_Conversion_Service.Configuration;

import com.example.Currency_Conversion_Service.Model.Currency;
import com.example.Currency_Conversion_Service.Model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "Currency-Exchange-Service")
public interface AppConfig {


    @GetMapping("from/{from}/to/{to}")
    CurrencyConversion currencyExchange(@PathVariable String from, @PathVariable String to);
}
