package com.pissouri.service;

import com.pissouri.data.TransferRepository;
import com.pissouri.dto.TransferDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final ConversionService conversionService;

    @Autowired
    public TransferService(TransferRepository transferRepository, ConversionService conversionService) {

        this.transferRepository = transferRepository;
        this.conversionService = conversionService;
    }

    public TransferDto getTransfer(Long id) {

        if (id == null || id <= 0) throw new IllegalArgumentException(String.format("Invalid argument %d", id));

        return transferRepository
                .findById(id)
                .map(transfer -> conversionService.convert(transfer, TransferDto.class))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Transfer %d not found", id)));
    }

    public List<TransferDto> getTransfers(Long accountId) {

        if (accountId == null || accountId <= 0) throw new IllegalArgumentException(String.format("Invalid argument %d", accountId));

        return transferRepository
                .findAllByAccountId(accountId)
                .stream()
                .map(transfer -> conversionService.convert(transfer, TransferDto.class))
                .collect(Collectors.toList());
    }
}
