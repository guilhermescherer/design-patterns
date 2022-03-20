package com.personal.quote;

import com.personal.exception.QuoteSituationException;
import com.personal.http.HttpAdapter;

import java.util.Map;

public class QuoteRegister {

    private HttpAdapter http;

    public QuoteRegister(HttpAdapter http) {
        this.http = http;
    }

    public void register(Quote quote) {
        if(!quote.isFinished()) {
            throw new QuoteSituationException("Orçamento não finalizado");
        }

        final String url = "https://api/quote";
        final Map<String, Object> data = Map.of(
                "value", quote.getValue(),
                "quantity", quote.getItemsQuantity()
        );

        http.post(url, data);
    }
}
