package com.personal.order;

import com.personal.action.ActionAfterGenerateOrder;
import com.personal.action.SaveOrderInDatabase;
import com.personal.action.SendEmailOrder;
import com.personal.quote.Quote;

import java.time.LocalDateTime;
import java.util.List;

public class GenerateOrderHandler {

    private List<ActionAfterGenerateOrder> actions;

    public GenerateOrderHandler(List<ActionAfterGenerateOrder> actions) {
        this.actions = actions;
    }

    public void perform(GenerateOrder data) {
        Quote quote = new Quote();
        quote.addItem(data.getItem());

        Order order = new Order(data.getCustomer(), LocalDateTime.now(), quote);

        SendEmailOrder sendEmailOrder = new SendEmailOrder();
        SaveOrderInDatabase saveOrderInDatabase = new SaveOrderInDatabase();

        actions.forEach(a -> a.perform(quote));
    }
}
