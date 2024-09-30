package com.example.Currency_Exchange_Service.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Currency {
    @Id
    private int id;
    @Column(name ="fromCurrency")
    private String from;
    @Column(name ="toCurrency")
    private String to;
    
    private BigDecimal conversionMultiple;
    private String environment;

    public Currency(int id, String from, String to, BigDecimal value) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple =value;
    }

    public Currency() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String port) {
        this.environment = port;
    }
}
