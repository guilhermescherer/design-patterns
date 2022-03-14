package com.personal.discount;

import com.personal.quote.Quote;

import java.math.BigDecimal;

public class DiscountQuantityItems extends Discount {

    private static final int QUANTITY_MIN_ITEMS_TO_DISCOUNT = 5;
    private static final BigDecimal DISCOUNT = new BigDecimal("0.1");

    public BigDecimal perform(Quote quote) {
        return quote.getValue().multiply(DISCOUNT);
    }

    @Override
    public boolean mustBeApplied(Quote quote) {
        return quote.getItemsQuantity() > QUANTITY_MIN_ITEMS_TO_DISCOUNT;
    }
}
