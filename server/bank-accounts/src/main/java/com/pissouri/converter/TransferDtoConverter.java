package com.pissouri.converter;

import com.pissouri.data.BankRoute;
import com.pissouri.data.Transfer;
import com.pissouri.dto.AddressDto;
import com.pissouri.dto.BankRouteDto;
import com.pissouri.dto.TransferDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TransferDtoConverter implements Converter<Transfer, TransferDto> {

    @Override
    public TransferDto convert(Transfer transfer) {

        TransferDto transferDto = new TransferDto()
                .setId(transfer.getId())
                .setAmount(transfer.getAmount())
                .setCurrency(transfer.getCurrency())
                .setBalanceAfter(transfer.getBalanceAfter())
                .setReference(transfer.getReference())
                .setStatus(transfer.getStatus())
                .setCreatedAt(transfer.getCreatedAt());

        BankRoute bankRoute = transfer.getBankRoute();

        AddressDto addressDto = new AddressDto()
                .setStreet(bankRoute.getStreet())
                .setCity(bankRoute.getCity())
                .setPostalCode(bankRoute.getPostalCode())
                .setCountry(bankRoute.getCountry());

        BankRouteDto bankRouteDto = new BankRouteDto()
                .setFullName(bankRoute.getFullName())
                .setBic(bankRoute.getBic())
                .setIban(bankRoute.getIban())
                .setSwiftCode(bankRoute.getSwiftCode())
                .setAccountNumber(bankRoute.getAccountNumber())
                .setSortCode(bankRoute.getSortCode())
                .setAddress(addressDto);

        if (transfer.getAmount() < 0) transferDto.setBeneficiary(bankRouteDto);
        else transferDto.setOriginator(bankRouteDto);

        return transferDto;
    }
}
