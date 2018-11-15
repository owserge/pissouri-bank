package com.pissouri.common;

import org.junit.Test;

import java.util.Currency;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrenciesUTest {

    @Test
    public void available_returnsSetOfApplicationSupportedCurrencyInstances() {

        Set<Currency> currencySet = Currencies.available();

        assertThat(currencySet).hasSize(4);

        assertThat(currencySet).extracting(Currency::getCurrencyCode).contains("EUR");
        assertThat(currencySet).extracting(Currency::getCurrencyCode).contains("GBP");
        assertThat(currencySet).extracting(Currency::getCurrencyCode).contains("USD");
        assertThat(currencySet).extracting(Currency::getCurrencyCode).contains("AUD");
    }
}
