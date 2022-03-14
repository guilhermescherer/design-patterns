package com.personal.tax;

import com.personal.quote.Quote;

import java.math.BigDecimal;

public class ICMS implements Tax {

    private static final BigDecimal TAX_ICMS = new BigDecimal("0.1");

    public BigDecimal calculate(Quote quote) {
        return quote.getValue().multiply(TAX_ICMS);
    }
}
