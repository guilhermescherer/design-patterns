package com.personal.tax;

import com.personal.quote.Quote;

import java.math.BigDecimal;

public class ISS extends Tax {

    private static final BigDecimal TAX_ISS = new BigDecimal("0.06");

    public ISS(Tax next) {
        super(next);
    }

    public BigDecimal perform(Quote quote) {
        return quote.getValue().multiply(TAX_ISS);
    }
}
