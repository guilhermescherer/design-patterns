package com.personal.quote;

import com.personal.quote.situation.Processing;

import java.math.BigDecimal;

public class Quote {

    private BigDecimal value;
    private int itemsQuantity;
    private QuoteSituation situation;

    public Quote(BigDecimal value, int itemsQuantity) {
        this.value = value;
        this.itemsQuantity = itemsQuantity;
        this.situation = new Processing();
    }

    public void applyExtraDiscount() {
        BigDecimal discountValue = this.situation.calculateExtraDiscountValue(this);
        this.value = this.value.subtract(discountValue);
    }

    public void approve() {
        this.situation.approve(this);
    }

    public void disapprove() {
        this.situation.disapprove(this);
    }

    public void finish() {
        this.situation.finish(this);
    }

    public BigDecimal getValue() {
        return value;
    }

    public int getItemsQuantity() {
        return itemsQuantity;
    }

    public QuoteSituation getSituation() {
        return situation;
    }

    public void setSituation(QuoteSituation situation) {
        this.situation = situation;
    }
}
