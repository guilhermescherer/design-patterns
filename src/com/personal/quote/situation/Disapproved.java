package com.personal.quote.situation;

import com.personal.quote.Quote;
import com.personal.quote.QuoteSituation;

public class Disapproved extends QuoteSituation {

    @Override
    public void finish(Quote quote) {
        quote.setSituation(new Finished());
    }
}
