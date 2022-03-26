package com.personal.quote;

import com.personal.quote.situation.Finished;
import com.personal.quote.situation.Processing;
import com.personal.quote.situation.QuoteSituation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Quote implements Budgetable {

    private BigDecimal value;
    private QuoteSituation situation;
    private List<Budgetable> items;

    public Quote() {
        this.value = BigDecimal.ZERO;
        this.items = new ArrayList<>();
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
        return items.size();
    }

    public void addItem(Budgetable item) {
        this.value = this.value.add(item.getValue());
        this.items.add(item);
    }

    public QuoteSituation getSituation() {
        return situation;
    }

    public void setSituation(QuoteSituation situation) {
        this.situation = situation;
    }

    public boolean isFinished() {
        return situation instanceof Finished;
    }
}
