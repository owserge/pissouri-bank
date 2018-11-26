package com.pissouri.service;

import com.pissouri.data.BankRoute;
import com.pissouri.data.Transfer;
import com.pissouri.data.TransferRepository;
import com.pissouri.dto.AddressDto;
import com.pissouri.dto.BankRouteDto;
import com.pissouri.dto.TransferDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferService {

    private final TransferRepository transferRepository;

    @Autowired
    public TransferService(TransferRepository transferRepository) {

        this.transferRepository = transferRepository;
    }

    public TransferDto getTransfer(Long id) {

        if (id == null || id <= 0) throw new IllegalArgumentException(String.format("Invalid argument %d", id));

        return transferRepository
                .findById(id)
                .map(TransferService::mapToDto)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Transfer %d not found", id)));
    }

    public List<TransferDto> getTransfers() {

        return transferRepository
                .findAll()
                .stream()
                .map(TransferService::mapToDto)
                .collect(Collectors.toList());
    }

    private static TransferDto mapToDto(Transfer transfer) {

        TransferDto transferDto = new TransferDto()
                .setId(transfer.getId())
                .setAmount(transfer.getAmount())
                .setCurrency(transfer.getCurrency())
                .setBalanceAfter(transfer.getBalanceAfter())
                .setReference(transfer.getReference())
                .setStatus(transfer.getStatus())
                .setCreatedAt(transfer.getCreatedAt());

        BankRouteDto bankRouteDto = mapToDto(transfer.getBankRoute());

        if (transfer.getAmount() < 0) transferDto.setBeneficiary(bankRouteDto);
        else transferDto.setOriginator(bankRouteDto);

        return transferDto;
    }

    private static BankRouteDto mapToDto(BankRoute bankRoute) {

        if (bankRoute == null) return null;

        AddressDto addressDto = new AddressDto()
                .setStreet(bankRoute.getStreet())
                .setCity(bankRoute.getCity())
                .setPostalCode(bankRoute.getPostalCode())
                .setCountry(bankRoute.getCountry());

        return new BankRouteDto()
                .setFullName(bankRoute.getFullName())
                .setBic(bankRoute.getBic())
                .setIban(bankRoute.getIban())
                .setSwiftCode(bankRoute.getSwiftCode())
                .setAccountNumber(bankRoute.getAccountNumber())
                .setSortCode(bankRoute.getSortCode())
                .setAddress(addressDto);
    }
}
