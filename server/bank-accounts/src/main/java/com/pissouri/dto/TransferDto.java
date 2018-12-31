package com.pissouri.dto;

import com.pissouri.common.TransferStatusCode;

import java.time.ZonedDateTime;
import java.util.Objects;

public class TransferDto {

    /**
     * Transfer unique record identification number
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
     * Bank routing information for the transfer originator (if transfer is credit, incoming)
     */
    private BankRouteDto originator;

    /**
     * Bank routing information for the transfer beneficiary (if transfer is debit, outgoing)
     */
    private BankRouteDto beneficiary;

    /**
     * Account balance after the transfer has been processed
     */
    private long balanceAfter;

    /**
     * Identification code provided by the entity that requested the transfer
     */
    private String reference;

    /**
     * The exact date and time for when this transfer was executed
     */
    private ZonedDateTime createdAt;

    public long getId() {

        return id;
    }

    public TransferDto setId(long id) {

        this.id = id;
        return this;
    }

    public long getAmount() {

        return amount;
    }

    public TransferDto setAmount(long amount) {

        this.amount = amount;
        return this;
    }

    public String getCurrency() {

        return currency;
    }

    public TransferDto setCurrency(String currency) {

        this.currency = currency;
        return this;
    }

    public String getStatus() {

        return status;
    }

    public TransferDto setStatus(String status) {

        this.status = status;
        return this;
    }

    public BankRouteDto getOriginator() {

        return originator;
    }

    public TransferDto setOriginator(BankRouteDto originator) {

        this.originator = originator;
        return this;
    }

    public BankRouteDto getBeneficiary() {

        return beneficiary;
    }

    public TransferDto setBeneficiary(BankRouteDto beneficiary) {

        this.beneficiary = beneficiary;
        return this;
    }

    public long getBalanceAfter() {

        return balanceAfter;
    }

    public TransferDto setBalanceAfter(long balanceAfter) {

        this.balanceAfter = balanceAfter;
        return this;
    }

    public String getReference() {

        return reference;
    }

    public TransferDto setReference(String reference) {

        this.reference = reference;
        return this;
    }

    public ZonedDateTime getCreatedAt() {

        return createdAt;
    }

    public TransferDto setCreatedAt(ZonedDateTime createdAt) {

        this.createdAt = createdAt;
        return this;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferDto that = (TransferDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {

        return "TransferDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                ", originator=" + originator +
                ", beneficiary=" + beneficiary +
                ", balanceAfter=" + balanceAfter +
                ", reference='" + reference + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
