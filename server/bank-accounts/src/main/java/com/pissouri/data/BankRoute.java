package com.pissouri.data;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Bank routing details for a registered bank account, associated with an {@link Account} record
 */
public class BankRoute {

    /**
     * Bank route database record id
     */
    private long id;

    /**
     * Account database record id
     */
    private long accountId;

    /**
     * International bank account number
     */
    private String iban;

    /**
     * Bank institution code
     */
    private String bic;

    /**
     * Bank SWIFT code
     */
    private String swiftCode;

    /**
     * UK account number
     */
    private String accountNumber;

    /**
     * UK sort code number
     */
    private String sortCode;

    /**
     * Address street and number
     */
    private String street;

    /**
     * Address city
     */
    private String city;

    /**
     * Address state, if applicable
     */
    private String state;

    /**
     * Address postal code
     */
    private String postalCode;

    /**
     * Address country, in ISO 3166 alpha 2 code (i.e. CY)
     */
    private String country;

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

    public BankRoute setId(long id) {

        this.id = id;
        return this;
    }

    public long getAccountId() {

        return accountId;
    }

    public BankRoute setAccountId(long accountId) {

        this.accountId = accountId;
        return this;
    }

    public String getIban() {

        return iban;
    }

    public BankRoute setIban(String iban) {

        this.iban = iban;
        return this;
    }

    public String getBic() {

        return bic;
    }

    public BankRoute setBic(String bic) {

        this.bic = bic;
        return this;
    }

    public String getSwiftCode() {

        return swiftCode;
    }

    public BankRoute setSwiftCode(String swiftCode) {

        this.swiftCode = swiftCode;
        return this;
    }

    public String getAccountNumber() {

        return accountNumber;
    }

    public BankRoute setAccountNumber(String accountNumber) {

        this.accountNumber = accountNumber;
        return this;
    }

    public String getSortCode() {

        return sortCode;
    }

    public BankRoute setSortCode(String sortCode) {

        this.sortCode = sortCode;
        return this;
    }

    public String getStreet() {

        return street;
    }

    public BankRoute setStreet(String street) {

        this.street = street;
        return this;
    }

    public String getCity() {

        return city;
    }

    public BankRoute setCity(String city) {

        this.city = city;
        return this;
    }

    public String getState() {

        return state;
    }

    public BankRoute setState(String state) {

        this.state = state;
        return this;
    }

    public String getPostalCode() {

        return postalCode;
    }

    public BankRoute setPostalCode(String postalCode) {

        this.postalCode = postalCode;
        return this;
    }

    public String getCountry() {

        return country;
    }

    public BankRoute setCountry(String country) {

        this.country = country;
        return this;
    }

    public ZonedDateTime getCreatedAt() {

        return createdAt;
    }

    public BankRoute setCreatedAt(ZonedDateTime createdAt) {

        this.createdAt = createdAt;
        return this;
    }

    public ZonedDateTime getUpdatedAt() {

        return updatedAt;
    }

    public BankRoute setUpdatedAt(ZonedDateTime updatedAt) {

        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankRoute bankRoute = (BankRoute) o;
        return id == bankRoute.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {

        return "BankRoute{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                ", swiftCode='" + swiftCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
