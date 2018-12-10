package com.pissouri.data;

import com.pissouri.dto.TransferStatusCode;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A bank account transfer
 */
@Entity
public class Transfer {

    /**
     * Transfer database record id
     */
    @Id
    private long id;

    /**
     * Account associated with the transfer (originator or beneficiary)
     */
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    /**
     * Transfer amount, positive (credit) or negative (debit)
     */
    private long amount;

    /**
     * Transfer currency, in ISO 4217 Alpha 3 format (i.e. EUR)
     */
    private String currency;

    /**
     * Transfer status, one of {@link TransferStatusCode}
     */
    private String status;

    /**
     * Account balance after the transfer has been processed
     */
    private long balanceAfter;

    /**
     * Identification code provided by the entity that requested the transfer
     */
    private String reference;

    /**
     * Bank routing information for the transfer originator or beneficiary
     */
    @ManyToOne
    @JoinColumn(name = "bank_route_id")
    private BankRoute bankRoute;

    /**
     * The exact date and time for when this transfer was executed
     */
    private ZonedDateTime createdAt;

    public long getId() {

        return id;
    }

    public Transfer setId(long id) {

        this.id = id;
        return this;
    }

    public Account getAccount() {

        return account;
    }

    public Transfer setAccount(Account account) {

        this.account = account;
        return this;
    }

    public long getAmount() {

        return amount;
    }

    public Transfer setAmount(long amount) {

        this.amount = amount;
        return this;
    }

    public String getCurrency() {

        return currency;
    }

    public Transfer setCurrency(String currency) {

        this.currency = currency;
        return this;
    }

    public String getStatus() {

        return status;
    }

    public Transfer setStatus(String status) {

        this.status = status;
        return this;
    }

    public long getBalanceAfter() {

        return balanceAfter;
    }

    public Transfer setBalanceAfter(long balanceAfter) {

        this.balanceAfter = balanceAfter;
        return this;
    }

    public String getReference() {

        return reference;
    }

    public Transfer setReference(String reference) {

        this.reference = reference;
        return this;
    }

    public BankRoute getBankRoute() {

        return bankRoute;
    }

    public Transfer setBankRoute(BankRoute bankRoute) {

        this.bankRoute = bankRoute;
        return this;
    }

    public ZonedDateTime getCreatedAt() {

        return createdAt;
    }

    public Transfer setCreatedAt(ZonedDateTime createdAt) {

        this.createdAt = createdAt;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return id == transfer.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {

        return "Transfer{" +
                "id=" + id +
                ", account=" + account +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                ", balanceAfter=" + balanceAfter +
                ", reference='" + reference + '\'' +
                ", bankRoute=" + bankRoute +
                ", createdAt=" + createdAt +
                '}';
    }
}
