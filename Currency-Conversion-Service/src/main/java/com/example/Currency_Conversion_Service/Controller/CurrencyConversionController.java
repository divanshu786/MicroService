package com.example.Currency_Conversion_Service.Controller;

import com.example.Currency_Conversion_Service.Configuration.AppConfig;
import com.example.Currency_Conversion_Service.Model.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

@Autowired
AppConfig proxy;

    @GetMapping("currency-exchange-service/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity){
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversion> response = new RestTemplate().exchange(
                "http://localhost:8080/from/{from}/to/{to}",
                HttpMethod.GET,
                null,
                CurrencyConversion.class,
                uriVariables
        );
        CurrencyConversion obj = response.getBody();
//        CurrencyConversion obj = new RestTemplate().getForEntity("http://localhost:8080/from/{from}/to/{to}",CurrencyConversion.class,uriVariables).getBody();
        obj.setTotalCalculatedAmount(obj.getConversionMultiple().multiply(quantity));
        return obj;
    }

    @GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion feignConvertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity){
        System.out.println("hello");
        CurrencyConversion obj = proxy.currencyExchange(from,to);
//        CurrencyConversion obj = new RestTemplate().getForEntity("http://localhost:8080/from/{from}/to/{to}",CurrencyConversion.class,uriVariables).getBody();
        obj.setTotalCalculatedAmount(obj.getConversionMultiple().multiply(quantity));
        return obj;
    }

}
