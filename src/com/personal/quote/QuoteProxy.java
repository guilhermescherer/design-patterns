package com.personal.quote;

import java.math.BigDecimal;

public class QuoteProxy extends Quote {

    private BigDecimal value;
    private Quote quote;

    public QuoteProxy(Quote quote) {
        this.quote = quote;
    }

    @Override
    public BigDecimal getValue() {
        if(value == null) {
            this.value = this.quote.getValue();
        }
        return this.value;
    }
}
