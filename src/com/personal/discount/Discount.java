package com.personal.discount;

import com.personal.quote.Quote;

import java.math.BigDecimal;

public abstract class Discount {

    protected Discount next;

    protected abstract BigDecimal perform(Quote quote);
    protected abstract boolean mustBeApplied(Quote quote);

    public Discount linkWith(Discount next) {
        this.next = next;
        return next;
    }

    public BigDecimal calculate(Quote quote) {
        if(mustBeApplied(quote)) {
            return perform(quote);
        }
        return calculateNext(quote);
    }

    protected BigDecimal calculateNext(Quote quote) {
        return next != null ? next.calculate(quote) : BigDecimal.ZERO;
    }
}
