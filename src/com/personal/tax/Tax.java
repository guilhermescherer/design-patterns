package com.personal.tax;

import com.personal.quote.Quote;

import java.math.BigDecimal;

public interface Tax {

    BigDecimal calculate(Quote quote);

}
