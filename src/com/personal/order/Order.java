package com.personal.order;

import com.personal.quote.Quote;

import java.time.LocalDateTime;

public class Order {

    private String customer;
    private LocalDateTime date;
    private Quote quote;

    public Order(String customer, LocalDateTime date, Quote quote) {
        this.customer = customer;
        this.date = date;
        this.quote = quote;
    }

    public String getCustomer() {
        return customer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Quote getQuote() {
        return quote;
    }
}
