package com.pissouri.service;

import com.pissouri.data.TransferRepository;
import com.pissouri.dto.TransferDto;
import com.pissouri.dto.TransferSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public TransferDto getTransfer(long accountId, long id) {

        Arguments.must(accountId, accountId > 0);

        Arguments.must(id, id > 0);

        return transferRepository
                .findByIdAndAccountId(id, accountId)
                .map(transfer -> conversionService.convert(transfer, TransferDto.class))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Transfer %d not found", id)));
    }

    public List<TransferDto> getTransfers(long accountId, TransferSearchDto searchDto) {

        Arguments.must(accountId, accountId > 0);

        Pageable pageable = Paging.of(searchDto, Sort.by("id").descending());

        return transferRepository
                .findAllByAccountId(accountId, pageable)
                .stream()
                .map(transfer -> conversionService.convert(transfer, TransferDto.class))
                .collect(Collectors.toList());
    }
}
