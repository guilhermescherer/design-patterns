package com.personal;

import com.personal.discount.DiscountCalculator;
import com.personal.quote.Quote;
import com.personal.tax.ICMS;
import com.personal.tax.ISS;
import com.personal.tax.TaxCalculator;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Quote quote = new Quote(new BigDecimal("100"), 1);
        TaxCalculator tax = new TaxCalculator();

        tax.calculate(quote, new ICMS());
        tax.calculate(quote, new ISS());

        Quote quoteWithDiscount = new Quote(new BigDecimal("300"), 6);

        DiscountCalculator discountCalculator = new DiscountCalculator();
        final BigDecimal discount = discountCalculator.calculate(quoteWithDiscount);
        System.out.println(discount);
    }
}
