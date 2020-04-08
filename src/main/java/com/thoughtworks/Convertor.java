package com.thoughtworks;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Convertor {

    public void convert(String currencyStr, int amount, int type) {
        Currency currentCurrency = Currency.from(currencyStr);
        Map<Currency, Integer> result = new HashMap<>();
        Integer reminder = amount;
        if (type == 0) {
            for (Currency currency : Currency.values()) {
                Integer multiple = currentCurrency.multipleFrom(currency);
                Integer num = reminder / multiple;
                if (num != 0) {
                    result.put(currency, num);
                }
                reminder = reminder % multiple;
                if (reminder == 0) {
                    break;
                }
            }
        } else {
            result.put(Currency.JPY, amount * Currency.JPY.multipleFrom(currentCurrency));
        }

        String strResult = result.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getOrder()))
                .map(entry -> entry.getValue() + entry.getKey().name())
                .reduce((r, next) -> r + "+" + next).get();
        System.out.println(amount + currencyStr + "=" + strResult);
    }
}
