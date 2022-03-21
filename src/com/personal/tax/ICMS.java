package com.personal.tax;

import com.personal.quote.Quote;

import java.math.BigDecimal;

public class ICMS extends Tax {

    private static final BigDecimal TAX_ICMS = new BigDecimal("0.1");

    public ICMS(Tax next) {
        super(next);
    }

    public BigDecimal perform(Quote quote) {
        return quote.getValue().multiply(TAX_ICMS);
    }
}
