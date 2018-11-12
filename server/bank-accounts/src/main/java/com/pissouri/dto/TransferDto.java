package com.pissouri.dto;

import org.springframework.boot.origin.Origin;

import java.time.ZonedDateTime;
import java.util.Objects;

public class TransferDto {
    private long id;
    private long amount;
    private String currency;
    private String status;
    private OriginatorDto originator;
    private BeneficiaryDto beneficiary;
    private long balanceAfter;
    private String reference;
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

    public OriginatorDto getOriginator() {
        return originator;
    }

    public TransferDto setOriginator(OriginatorDto originator) {
        this.originator = originator;
        return this;
    }

    public BeneficiaryDto getBeneficiary() {
        return beneficiary;
    }

    public TransferDto setBeneficiary(BeneficiaryDto beneficiary) {
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
