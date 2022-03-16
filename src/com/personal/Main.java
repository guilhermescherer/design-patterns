package com.personal;

import com.personal.action.SendEmailOrder;
import com.personal.discount.DiscountCalculator;
import com.personal.order.GenerateOrder;
import com.personal.order.GenerateOrderHandler;
import com.personal.order.Order;
import com.personal.quote.Quote;
import com.personal.tax.ICMS;
import com.personal.tax.ISS;
import com.personal.tax.TaxCalculator;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Main {

    @Test
    public void quoteWithTax() {
        Quote quote = new Quote(new BigDecimal("100"), 1);
        TaxCalculator tax = new TaxCalculator();

        final BigDecimal icms = tax.calculate(quote, new ICMS());
        final BigDecimal iss = tax.calculate(quote, new ISS());

        assertEquals(10, icms.intValue());
        assertEquals(6, iss.intValue());
    }

    @Test
    public void quoteWithDiscount() {
        Quote quote = new Quote(new BigDecimal("300"), 6);

        DiscountCalculator discountCalculator = new DiscountCalculator();
        final BigDecimal discount = discountCalculator.calculate(quote);

        assertEquals(30, discount.intValue());
    }

    @Test
    public void order() {
        String customer = "Guilherme";
        BigDecimal value =  new BigDecimal("300");
        int itemsQuantity = 3;

        GenerateOrder generateOrder = new GenerateOrder(customer, value, itemsQuantity);
        GenerateOrderHandler handler = new GenerateOrderHandler(List.of(new SendEmailOrder(), new SendEmailOrder()));

        handler.perform(generateOrder);
    }
}
