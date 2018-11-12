package com.pissouri.dto;

public class BeneficiaryDto {

    private String iban;
    private String bic;
    private String swiftCode;
    private String accountNumber;
    private String sortCode;
    private AddressDto address;

    public String getIban() {
        return iban;
    }

    public BeneficiaryDto setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public String getBic() {
        return bic;
    }

    public BeneficiaryDto setBic(String bic) {
        this.bic = bic;
        return this;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public BeneficiaryDto setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BeneficiaryDto setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getSortCode() {
        return sortCode;
    }

    public BeneficiaryDto setSortCode(String sortCode) {
        this.sortCode = sortCode;
        return this;
    }

    public AddressDto getAddress() {
        return address;
    }

    public BeneficiaryDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "BeneficiaryDto{" +
                "iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                ", swiftCode='" + swiftCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", address=" + address +
                '}';
    }
}
