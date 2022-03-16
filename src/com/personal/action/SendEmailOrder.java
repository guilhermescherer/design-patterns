package com.personal.action;

import com.personal.quote.Quote;

public class SendEmailOrder implements ActionAfterGenerateOrder {

    public void perform(Quote quote) {
        System.out.println("Enviando e-mail com dados do pedido");
    }
}
