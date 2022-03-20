package com.personal.quote.situation;

import com.personal.quote.Quote;

import java.math.BigDecimal;

public class Approved extends QuoteSituation {

    @Override
    public BigDecimal calculateExtraDiscountValue(Quote quote) {
        return quote.getValue().multiply(new BigDecimal("0.02"));
    }

    @Override
    public void finish(Quote quote) {
        quote.setSituation(new Finished());
    }
}
