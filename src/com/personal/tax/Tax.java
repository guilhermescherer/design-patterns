package com.personal.tax;

import com.personal.quote.Quote;

import java.math.BigDecimal;

public abstract class Tax {

    private final Tax next;

    public Tax(Tax next) {
        this.next = next;
    }

    protected abstract BigDecimal perform(Quote quote);

    public BigDecimal calculate(Quote quote) {
        final BigDecimal taxValue = perform(quote);
        final BigDecimal nextTaxValue = calculateNext(quote);
        return taxValue.add(nextTaxValue);
    }

    private BigDecimal calculateNext(Quote quote) {
        BigDecimal value = BigDecimal.ZERO;
        if(next != null) {
            value = next.calculate(quote);
        }
        return value;
    }
}
