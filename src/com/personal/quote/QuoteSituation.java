package com.personal.quote;

import com.personal.exception.QuoteSituationException;

import java.math.BigDecimal;

// State Pattern
public abstract class QuoteSituation {

    public BigDecimal calculateExtraDiscountValue(Quote quote) {
        return BigDecimal.ZERO;
    }

    public void approve(Quote quote) {
        throw new QuoteSituationException("Orçamento não pode ser aprovado");
    }

    public void disapprove(Quote quote) {
        throw new QuoteSituationException("Orçamento não pode ser reprovado");
    }

    public void finish(Quote quote) {
        throw new QuoteSituationException("Orçamento não pode ser finalizado");
    }
}
