package com.pissouri.converter;

import com.pissouri.data.Account;
import com.pissouri.data.AccountRegistration;
import com.pissouri.data.BankRoute;
import com.pissouri.dto.AccountDto;
import com.pissouri.dto.AddressDto;
import com.pissouri.dto.BankRouteDto;
import com.pissouri.dto.RegistrationDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.time.format.DateTimeFormatter.ofPattern;

@Component
public class AccountDtoConverter implements Converter<Account, AccountDto> {

    @Override
    public AccountDto convert(Account account) {

        AccountRegistration registration = account.getRegistration();
        RegistrationDto registrationDto = new RegistrationDto()
                .setFirstName(registration.getFirstName())
                .setLastName(registration.getLastName())
                .setDateOfBirth(ofPattern("yyyy-MM-dd").format(registration.getDateOfBirth()))
                .setNationality(registration.getNationality())
                .setAddress(new AddressDto()
                        .setStreet(registration.getStreet())
                        .setCity(registration.getCity())
                        .setPostalCode(registration.getPostalCode())
                        .setCountry(registration.getCountry()));

        BankRoute bankRoute = account.getBankRoute();
        BankRouteDto bankRouteDto =  new BankRouteDto()
                .setFullName(String.format("%s, %s", registration.getLastName(), registration.getFirstName()))
                .setIban(bankRoute.getIban())
                .setBic(bankRoute.getBic())
                .setSwiftCode(bankRoute.getSwiftCode())
                .setAccountNumber(bankRoute.getAccountNumber())
                .setSortCode(bankRoute.getSortCode())
                .setAddress(new AddressDto()
                        .setStreet(bankRoute.getStreet())
                        .setCity(bankRoute.getCity())
                        .setPostalCode(bankRoute.getPostalCode())
                        .setCountry(bankRoute.getCountry()));

        return new AccountDto()
                .setId(account.getId())
                .setNumber(account.getNumber())
                .setCurrency(account.getCurrency())
                .setBalance(account.getBalance())
                .setReference(account.getReference())
                .setRegistration(registrationDto)
                .setBankRoute(bankRouteDto)
                .setCreatedAt(account.getCreatedAt())
                .setUpdatedAt(account.getUpdatedAt());
    }
}
