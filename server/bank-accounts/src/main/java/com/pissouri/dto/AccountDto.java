package com.pissouri.dto;

import java.time.ZonedDateTime;
import java.util.Objects;

public class AccountDto {

    private long id;
    private String number;
    private long balance;
    private String currency;
    private String reference;
    private RegistrationDto registration;
    private BankRouteDto bankRoute;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public long getId() {

        return id;
    }

    public AccountDto setId(long id) {

        this.id = id;
        return this;
    }

    public String getNumber() {

        return number;
    }

    public AccountDto setNumber(String number) {

        this.number = number;
        return this;
    }

    public long getBalance() {

        return balance;
    }

    public AccountDto setBalance(long balance) {

        this.balance = balance;
        return this;
    }

    public String getCurrency() {

        return currency;
    }

    public AccountDto setCurrency(String currency) {

        this.currency = currency;
        return this;
    }

    public String getReference() {

        return reference;
    }

    public AccountDto setReference(String reference) {

        this.reference = reference;
        return this;
    }

    public RegistrationDto getRegistration() {

        return registration;
    }

    public AccountDto setRegistration(RegistrationDto registration) {

        this.registration = registration;
        return this;
    }

    public BankRouteDto getBankRoute() {

        return bankRoute;
    }

    public AccountDto setBankRoute(BankRouteDto bankRoute) {

        this.bankRoute = bankRoute;
        return this;
    }

    public ZonedDateTime getCreatedAt() {

        return createdAt;
    }

    public AccountDto setCreatedAt(ZonedDateTime createdAt) {

        this.createdAt = createdAt;
        return this;
    }

    public ZonedDateTime getUpdatedAt() {

        return updatedAt;
    }

    public AccountDto setUpdatedAt(ZonedDateTime updatedAt) {

        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {

        return "AccountDto{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", reference='" + reference + '\'' +
                ", registration=" + registration +
                ", bankRoute=" + bankRoute +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
