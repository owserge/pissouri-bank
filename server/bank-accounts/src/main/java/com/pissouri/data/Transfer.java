package com.pissouri.data;

import com.pissouri.dto.TransferStatusCode;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Transfer {

    /**
     * Transfer database record id
     */
    private long id;

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
     * Bank routing information for the transfer originator (if transfer is credit, incoming)
     */
    private BankRoute originator;

    /**
     * Bank routing information for the transfer beneficiary (if transfer is debit, outgoing)
     */
    private BankRoute beneficiary;

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

    public BankRoute getOriginator() {

        return originator;
    }

    public Transfer setOriginator(BankRoute originator) {

        this.originator = originator;
        return this;
    }

    public BankRoute getBeneficiary() {

        return beneficiary;
    }

    public Transfer setBeneficiary(BankRoute beneficiary) {

        this.beneficiary = beneficiary;
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
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                ", balanceAfter=" + balanceAfter +
                ", reference='" + reference + '\'' +
                ", originator=" + originator +
                ", beneficiary=" + beneficiary +
                ", createdAt=" + createdAt +
                '}';
    }
}
