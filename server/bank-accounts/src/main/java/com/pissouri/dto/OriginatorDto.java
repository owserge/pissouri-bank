package com.pissouri.dto;

public class OriginatorDto {

    private String iban;
    private String bic;
    private String swiftCode;
    private String accountNumber;
    private String sortCode;
    private AddressDto address;

    public String getIban() {
        return iban;
    }

    public OriginatorDto setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public String getBic() {
        return bic;
    }

    public OriginatorDto setBic(String bic) {
        this.bic = bic;
        return this;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public OriginatorDto setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public OriginatorDto setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getSortCode() {
        return sortCode;
    }

    public OriginatorDto setSortCode(String sortCode) {
        this.sortCode = sortCode;
        return this;
    }

    public AddressDto getAddress() {
        return address;
    }

    public OriginatorDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "OriginatorDto{" +
                "iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                ", swiftCode='" + swiftCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", address=" + address +
                '}';
    }
}
