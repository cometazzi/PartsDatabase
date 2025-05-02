package com.mouser;

import java.math.BigDecimal;

public class APITransistor {
    private String mouserPartNumber;
    private BigDecimal unitPrice;
    private String currency;

    // Default constructor (required by Jackson)
    public APITransistor() {
    }

    public String getMouserPartNumber() {
        return mouserPartNumber;
    }

    public void setMouserPartNumber(String mouserPartNumber) {
        this.mouserPartNumber = mouserPartNumber;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "APITransistor{" +
                "mouserPartNumber='" + mouserPartNumber + '\'' +
                ", unitPrice=" + unitPrice +
                ", currency='" + currency + '\'' +
                '}';
    }
}