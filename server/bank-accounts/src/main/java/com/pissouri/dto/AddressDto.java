package com.pissouri.dto;

import java.util.Objects;

public class AddressDto {

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

    public String getStreet() {

        return street;
    }

    public AddressDto setStreet(String street) {

        this.street = street;
        return this;
    }

    public String getCity() {

        return city;
    }

    public AddressDto setCity(String city) {

        this.city = city;
        return this;
    }

    public String getState() {

        return state;
    }

    public AddressDto setState(String state) {

        this.state = state;
        return this;
    }

    public String getPostalCode() {

        return postalCode;
    }

    public AddressDto setPostalCode(String postalCode) {

        this.postalCode = postalCode;
        return this;
    }

    public String getCountry() {

        return country;
    }

    public AddressDto setCountry(String country) {

        this.country = country;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return Objects.equals(street, that.street) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {

        return Objects.hash(street, city, state, postalCode, country);
    }

    @Override
    public String toString() {

        return "AddressDto{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
