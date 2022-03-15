package com.personal.order;

import com.personal.quote.Quote;

import java.time.LocalDateTime;

public class GenerateOrderHandler {

    public void perform(GenerateOrder data) {
        Quote quote = new Quote(data.getQuoteValue(), data.getItemsQuantity());
        Order order = new Order(data.getCustomer(), LocalDateTime.now(), quote);
    }

}
