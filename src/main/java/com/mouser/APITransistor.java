package com.mouser;

import java.math.BigDecimal;

public class APITransistor {
    private String mouserPartNumber;
    private String availability;
    private String dataSheetUrl;
    private String description;
    private BigDecimal priceFor1;
    private BigDecimal priceFor10;
    private BigDecimal priceFor100;
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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getDataSheetUrl() {
        return dataSheetUrl;
    }

    public void setDataSheetUrl(String dataSheetUrl) {
        this.dataSheetUrl = dataSheetUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPriceFor1() {
        return priceFor1;
    }

    public void setPriceFor1(BigDecimal priceFor1) {
        this.priceFor1 = priceFor1;
    }

    public BigDecimal getPriceFor10() {
        return priceFor10;
    }

    public void setPriceFor10(BigDecimal priceFor10) {
        this.priceFor10 = priceFor10;
    }

    public BigDecimal getPriceFor100() {
        return priceFor100;
    }

    public void setPriceFor100(BigDecimal priceFor100) {
        this.priceFor100 = priceFor100;
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
                ", availability='" + availability + '\'' +
                ", dataSheetUrl='" + dataSheetUrl + '\'' +
                ", description='" + description + '\'' +
                ", priceFor1=" + priceFor1 +
                ", priceFor10=" + priceFor10 +
                ", priceFor100=" + priceFor100 +
                ", currency='" + currency + '\'' +
                '}';
    }
}