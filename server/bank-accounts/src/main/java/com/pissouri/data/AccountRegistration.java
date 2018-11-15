package com.pissouri.data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Account registration details, associated with an {@link Account} record
 */
public class AccountRegistration {

    /**
     * Account registration database record id
     */
    private long id;

    /**
     * Account database record id
     */
    private long accountId;

    /**
     * Registered customer first name
     */
    private String firstName;

    /**
     * Registered customer last (family) name
     */
    private String lastName;

    /**
     * Customer date of birth
     */
    private LocalDate dateOfBirth;

    /**
     * Registered customer nationality
     */
    private String nationality;

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
     * The exact date and time for when this record was created
     */
    private ZonedDateTime createdAt;

    /**
     * The date and time for when this record was last updated
     */
    private ZonedDateTime updatedAt;

    public long getId() {

        return id;
    }

    public AccountRegistration setId(long id) {

        this.id = id;
        return this;
    }

    public long getAccountId() {

        return accountId;
    }

    public AccountRegistration setAccountId(long accountId) {

        this.accountId = accountId;
        return this;
    }

    public String getFirstName() {

        return firstName;
    }

    public AccountRegistration setFirstName(String firstName) {

        this.firstName = firstName;
        return this;
    }

    public String getLastName() {

        return lastName;
    }

    public AccountRegistration setLastName(String lastName) {

        this.lastName = lastName;
        return this;
    }

    public LocalDate getDateOfBirth() {

        return dateOfBirth;
    }

    public AccountRegistration setDateOfBirth(LocalDate dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getNationality() {

        return nationality;
    }

    public AccountRegistration setNationality(String nationality) {

        this.nationality = nationality;
        return this;
    }

    public String getStreet() {

        return street;
    }

    public AccountRegistration setStreet(String street) {

        this.street = street;
        return this;
    }

    public String getCity() {

        return city;
    }

    public AccountRegistration setCity(String city) {

        this.city = city;
        return this;
    }

    public String getState() {

        return state;
    }

    public AccountRegistration setState(String state) {

        this.state = state;
        return this;
    }

    public String getPostalCode() {

        return postalCode;
    }

    public AccountRegistration setPostalCode(String postalCode) {

        this.postalCode = postalCode;
        return this;
    }

    public String getCountry() {

        return country;
    }

    public AccountRegistration setCountry(String country) {

        this.country = country;
        return this;
    }

    public ZonedDateTime getCreatedAt() {

        return createdAt;
    }

    public AccountRegistration setCreatedAt(ZonedDateTime createdAt) {

        this.createdAt = createdAt;
        return this;
    }

    public ZonedDateTime getUpdatedAt() {

        return updatedAt;
    }

    public AccountRegistration setUpdatedAt(ZonedDateTime updatedAt) {

        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountRegistration that = (AccountRegistration) o;
        return id == that.id &&
                accountId == that.accountId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, accountId);
    }

    @Override
    public String toString() {

        return "AccountRegistration{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality='" + nationality + '\'' +
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
