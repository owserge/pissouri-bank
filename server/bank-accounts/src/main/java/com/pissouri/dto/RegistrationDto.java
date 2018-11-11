package com.pissouri.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class RegistrationDto {

    /**
     * Registered customer first name
     */
    private String firstName;

    /**
     * Registered customer last (family) name
     */
    private String lastName;

    /**
     * Customer date of birth (in YYYY-mm-dd format)
     */
    @JsonProperty("dob")
    private String dateOfBirth;

    /**
     * Registered customer nationality
     */
    private String nationality;

    /**
     * Customer address information
     */
    private AddressDto address;

    public String getFirstName() {

        return firstName;
    }

    public RegistrationDto setFirstName(String firstName) {

        this.firstName = firstName;
        return this;
    }

    public String getLastName() {

        return lastName;
    }

    public RegistrationDto setLastName(String lastName) {

        this.lastName = lastName;
        return this;
    }

    public String getDateOfBirth() {

        return dateOfBirth;
    }

    public RegistrationDto setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getNationality() {

        return nationality;
    }

    public RegistrationDto setNationality(String nationality) {

        this.nationality = nationality;
        return this;
    }

    public AddressDto getAddress() {

        return address;
    }

    public RegistrationDto setAddress(AddressDto address) {

        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationDto that = (RegistrationDto) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(nationality, that.nationality);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, dateOfBirth, nationality);
    }

    @Override
    public String toString() {

        return "RegistrationDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", nationality='" + nationality + '\'' +
                ", address=" + address +
                '}';
    }
}
