package com.personal.action;

import com.personal.quote.Quote;

public class OrderLog implements ActionAfterGenerateOrder {

    @Override
    public void perform(Quote quote) {
        System.out.println("Pedido foi gerado: " + quote);
    }
}
