package com.personal.discount;

import com.personal.quote.Quote;

import java.math.BigDecimal;

// Chain of Responsibility Pattern
public abstract class Discount {

    protected Discount next;

    protected abstract BigDecimal perform(Quote quote);
    protected abstract boolean mustBeApplied(Quote quote);

    public Discount linkWith(Discount next) {
        this.next = next;
        return next;
    }

    // Template method Pattern
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
