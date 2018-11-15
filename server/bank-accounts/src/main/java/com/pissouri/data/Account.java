package com.pissouri.data;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A registered customer bank account
 */
public class Account {

    /**
     * Account database record id
     */
    private long id;

    /**
     * Account statement number
     */
    private String number;

    /**
     * Account balance, in minor units (i.e. cents)
     */
    private long balance;

    /**
     * Account currency, in ISO 4217 Alpha 3 format (i.e. EUR)
     */
    private String currency;

    /**
     * Identification code provided by the entity that created the account
     */
    private String reference;

    /**
     * Account bank routing details
     */
    private BankRoute bankRoute;

    /**
     * Account registration details
     */
    private AccountRegistration registration;

    /**
     * The exact date and time for when this account was created
     */
    private ZonedDateTime createdAt;

    /**
     * The date and time for when this account was last updated
     */
    private ZonedDateTime updatedAt;

    public long getId() {

        return id;
    }

    public Account setId(long id) {

        this.id = id;
        return this;
    }

    public String getNumber() {

        return number;
    }

    public Account setNumber(String number) {

        this.number = number;
        return this;
    }

    public long getBalance() {

        return balance;
    }

    public Account setBalance(long balance) {

        this.balance = balance;
        return this;
    }

    public String getCurrency() {

        return currency;
    }

    public Account setCurrency(String currency) {

        this.currency = currency;
        return this;
    }

    public String getReference() {

        return reference;
    }

    public Account setReference(String reference) {

        this.reference = reference;
        return this;
    }

    public BankRoute getBankRoute() {

        return bankRoute;
    }

    public Account setBankRoute(BankRoute bankRoute) {

        this.bankRoute = bankRoute;
        return this;
    }

    public AccountRegistration getRegistration() {

        return registration;
    }

    public Account setRegistration(AccountRegistration registration) {

        this.registration = registration;
        return this;
    }

    public ZonedDateTime getCreatedAt() {

        return createdAt;
    }

    public Account setCreatedAt(ZonedDateTime createdAt) {

        this.createdAt = createdAt;
        return this;
    }

    public ZonedDateTime getUpdatedAt() {

        return updatedAt;
    }

    public Account setUpdatedAt(ZonedDateTime updatedAt) {

        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {

        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", reference='" + reference + '\'' +
                ", bankRoute=" + bankRoute +
                ", registration=" + registration +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
