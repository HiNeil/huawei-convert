package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CurrencyTest {

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_the_currency_order_is_greater_than_current_currency() {
        Currency.CNY.multipleFrom(Currency.JPY);
    }

    @Test
    public void should_return_1_when_the_currency_is_same_with_current_currency() {
        Integer result = Currency.CNY.multipleFrom(Currency.CNY);
        Assert.assertEquals(1, result.intValue());
    }

    @Test
    public void should_return_correct_mutiple() {
        Integer result = Currency.JPY.multipleFrom(Currency.USD);
        Assert.assertEquals(210, result.intValue());
    }

    @Test
    public void should_return_currency_from_string() {
        Currency currency = Currency.from("JPY");
        Assert.assertEquals(Currency.JPY, currency);
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_the_string_is_invalid() {
        Currency currency = Currency.from("test");
    }
}