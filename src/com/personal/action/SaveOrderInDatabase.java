package com.personal.action;

import com.personal.quote.Quote;

public class SaveOrderInDatabase implements ActionAfterGenerateOrder {

    public void perform(Quote quote) {
        System.out.println("Salvando pedido no banco de dados");
    }
}
