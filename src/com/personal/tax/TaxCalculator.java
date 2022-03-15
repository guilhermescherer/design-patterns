package com.personal.tax;

import com.personal.quote.Quote;

import java.math.BigDecimal;

// Strategy Pattern
public class TaxCalculator {

    public BigDecimal calculate(Quote quote, Tax tax) {
        return tax.calculate(quote);
    }
}
