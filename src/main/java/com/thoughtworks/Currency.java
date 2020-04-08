package com.thoughtworks;

public enum Currency {

    EUR(2, 1),
    USD(7, 2),
    CNY(2, 3),
    HKD(15, 4),
    JPY(null, 5);

    private Integer multiple;

    private Integer order;

    public Integer getOrder() {
        return order;
    }

    Currency(Integer multiple, Integer order) {
        this.multiple = multiple;
        this.order = order;
    }

    public Integer multipleFrom(Currency convertCurrency) {
        if (convertCurrency.order > this.order) {
            throw new RuntimeException("Illegal Operation");
        }
        Integer multiple = 1;
        for (Currency currency : Currency.values()) {
            if (this == currency || this == convertCurrency) {
                break;
            }
            if (currency.order >= convertCurrency.order) {
                multiple = multiple * currency.multiple;
            }
        }
        return multiple;
    }

    public static Currency from(String currencyStr) {
        for (Currency currency : Currency.values()) {
            if (currencyStr.equals(currency.name())) {
                return currency;
            }
        }
        throw new RuntimeException(String.format("%s is invalid", currencyStr));
    }
}
