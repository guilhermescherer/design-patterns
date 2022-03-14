package com.personal.tax;

import com.personal.quote.Quote;

import java.math.BigDecimal;

public class ISS implements Tax {

    private static final BigDecimal TAX_ISS = new BigDecimal("0.06");

    public BigDecimal calculate(Quote quote) {
        return quote.getValue().multiply(TAX_ISS);
    }
}
