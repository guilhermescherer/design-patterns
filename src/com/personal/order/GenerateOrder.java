package com.personal.order;

import java.math.BigDecimal;

public class GenerateOrder {

    private String customer;
    private BigDecimal quoteValue;
    private int itemsQuantity;

    public GenerateOrder(String customer, BigDecimal quoteValue, int itemsQuantity) {
        this.customer = customer;
        this.quoteValue = quoteValue;
        this.itemsQuantity = itemsQuantity;
    }

    public String getCustomer() {
        return customer;
    }

    public BigDecimal getQuoteValue() {
        return quoteValue;
    }

    public int getItemsQuantity() {
        return itemsQuantity;
    }
}
