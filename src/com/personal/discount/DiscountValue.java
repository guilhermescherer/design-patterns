package com.personal.discount;

import com.personal.quote.Quote;

import java.math.BigDecimal;

public class DiscountValue extends Discount {

    private static final BigDecimal MIN_VALUE_TO_DISCOUNT = new BigDecimal("5000");
    private static final BigDecimal DISCOUNT = new BigDecimal("0.1");

    public BigDecimal perform(Quote quote) {
        return quote.getValue().multiply(DISCOUNT);
    }

    @Override
    public boolean mustBeApplied(Quote quote) {
        return quote.getValue().compareTo(MIN_VALUE_TO_DISCOUNT) > 0;
    }
}
