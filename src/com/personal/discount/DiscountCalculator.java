package com.personal.discount;

import com.personal.quote.Quote;

import java.math.BigDecimal;

public class DiscountCalculator {

    public BigDecimal calculate(Quote quote) {
        final Discount discount = new DiscountValue()
                .linkWith(new DiscountQuantityItems());

        return discount.calculate(quote);
    }
}
