package com.personal.order;

import com.personal.quote.Budgetable;

import java.util.List;

public class GenerateOrder {

    private String customer;
    private List<Budgetable> item;

    public GenerateOrder(String customer, List<Budgetable> item) {
        this.customer = customer;
        this.item = item;
    }

    public String getCustomer() {
        return customer;
    }

    public List<Budgetable> getItem() {
        return item;
    }
}
