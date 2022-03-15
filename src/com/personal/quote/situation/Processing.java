package com.personal.quote.situation;

import com.personal.quote.Quote;
import com.personal.quote.QuoteSituation;

import java.math.BigDecimal;

public class Processing extends QuoteSituation {

    @Override
    public BigDecimal calculateExtraDiscountValue(Quote quote) {
        return quote.getValue().multiply(new BigDecimal("0.05"));
    }

    @Override
    public void approve(Quote quote) {
        quote.setSituation(new Approved());
    }

    @Override
    public void disapprove(Quote quote) {
        quote.setSituation(new Disapproved());
    }
}
