package com.personal.quote;

import java.math.BigDecimal;

public class QuoteItem implements Budgetable {

    private BigDecimal value;

    public QuoteItem(BigDecimal value) {
        this.value = value;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }
}
