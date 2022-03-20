package com.personal.quote.situation;

import com.personal.quote.Quote;

public class Disapproved extends QuoteSituation {

    @Override
    public void finish(Quote quote) {
        quote.setSituation(new Finished());
    }
}
