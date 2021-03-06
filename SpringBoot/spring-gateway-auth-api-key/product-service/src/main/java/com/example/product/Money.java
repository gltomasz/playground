package com.example.product;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class Money {

    private final BigDecimal value;
    private final Currency currency;

    public Money(double value, Currency currency) {
        this.value = BigDecimal.valueOf(value);
        this.currency = currency;
    }

    public double getValue() {
        return value.doubleValue();
    }

    public String getCurrency() {
        return currency.name();
    }

    public enum Currency {
        PLN, USD, EUR
    }
}
