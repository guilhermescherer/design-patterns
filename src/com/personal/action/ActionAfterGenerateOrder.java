package com.personal.action;

import com.personal.quote.Quote;

public interface ActionAfterGenerateOrder {

    void perform(Quote quote);
}
