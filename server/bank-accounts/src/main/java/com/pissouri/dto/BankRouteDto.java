package com.pissouri.dto;

import java.util.Objects;

public class BankRouteDto {

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
     * Address associated with bank account information
     */
    private AddressDto address;

    public String getIban() {

        return iban;
    }

    public BankRouteDto setIban(String iban) {

        this.iban = iban;
        return this;
    }

    public String getBic() {

        return bic;
    }

    public BankRouteDto setBic(String bic) {

        this.bic = bic;
        return this;
    }

    public String getSwiftCode() {

        return swiftCode;
    }

    public BankRouteDto setSwiftCode(String swiftCode) {

        this.swiftCode = swiftCode;
        return this;
    }

    public String getAccountNumber() {

        return accountNumber;
    }

    public BankRouteDto setAccountNumber(String accountNumber) {

        this.accountNumber = accountNumber;
        return this;
    }

    public String getSortCode() {

        return sortCode;
    }

    public BankRouteDto setSortCode(String sortCode) {

        this.sortCode = sortCode;
        return this;
    }

    public AddressDto getAddress() {

        return address;
    }

    public BankRouteDto setAddress(AddressDto address) {

        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankRouteDto that = (BankRouteDto) o;
        return Objects.equals(iban, that.iban) &&
                Objects.equals(bic, that.bic) &&
                Objects.equals(swiftCode, that.swiftCode) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(sortCode, that.sortCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(iban, bic, swiftCode, accountNumber, sortCode);
    }

    @Override
    public String toString() {

        return "BankRouteDto{" +
                "iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                ", swiftCode='" + swiftCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", address=" + address +
                '}';
    }
}
