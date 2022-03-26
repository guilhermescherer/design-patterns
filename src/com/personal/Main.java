package com.personal;

import com.personal.action.OrderLog;
import com.personal.action.SaveOrderInDatabase;
import com.personal.action.SendEmailOrder;
import com.personal.discount.DiscountCalculator;
import com.personal.order.GenerateOrder;
import com.personal.order.GenerateOrderHandler;
import com.personal.quote.Quote;
import com.personal.quote.QuoteItem;
import com.personal.tax.ICMS;
import com.personal.tax.ISS;
import com.personal.tax.TaxCalculator;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Main {

    @Test
    public void quoteWithTax() {
        QuoteItem item = new QuoteItem(new BigDecimal("100"));
        Quote quote = new Quote();
        quote.addItem(item);

        TaxCalculator tax = new TaxCalculator();

        final BigDecimal icmsWithIss = tax.calculate(quote, new ICMS(new ISS(null)));

        assertEquals(16, icmsWithIss.intValue());
    }

    @Test
    public void quoteWithDiscount() {
        QuoteItem item = new QuoteItem(new BigDecimal("100"));
        Quote quote = new Quote();
        quote.addItem(item);

        DiscountCalculator discountCalculator = new DiscountCalculator();
        final BigDecimal discount = discountCalculator.calculate(quote);

        assertEquals(30, discount.intValue());
    }

    @Test
    public void order() {
        QuoteItem item = new QuoteItem(new BigDecimal("300"));
        String customer = "Guilherme";

        GenerateOrder generateOrder = new GenerateOrder(customer, List.of(item));
        GenerateOrderHandler handler = new GenerateOrderHandler(
                List.of(new SendEmailOrder(),
                        new SaveOrderInDatabase(),
                        new OrderLog()
                ));

        handler.perform(generateOrder);
    }

    @Test
    public void quoteComposite(){
        Quote oldQuote = new Quote();
        oldQuote.addItem(new QuoteItem(new BigDecimal("100")));
        oldQuote.disapprove();

        Quote newQuote = new Quote();
        newQuote.addItem(new QuoteItem(new BigDecimal("500")));
        newQuote.addItem(oldQuote);

        System.out.println(newQuote.getValue());
    }
}
