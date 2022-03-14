package com.personal.quote;

import java.math.BigDecimal;

public class Quote {

    private BigDecimal value;
    private int itemsQuantity;

    public Quote(BigDecimal value, int itemsQuantity) {
        this.value = value;
        this.itemsQuantity = itemsQuantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public int getItemsQuantity() {
        return itemsQuantity;
    }
}
