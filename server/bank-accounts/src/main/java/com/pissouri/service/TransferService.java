package com.pissouri.service;

import com.pissouri.dto.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


import static java.time.ZoneOffset.UTC;

@Service
public class TransferService {

    static LocalDateTime firstOfJuly = LocalDateTime.of(2018, 7, 1, 0, 0);

    static final List<TransferDto> transfers = new ArrayList<TransferDto>() {{
        add(new TransferDto().setId(1L).setAmount(100L).setCurrency("EUR").setStatus(TransferStatusCode.ACCEPTED).setBalanceAfter(100L).setReference("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1").setOriginator(new OriginatorDto().setAddress(new AddressDto())).setCreatedAt(ZonedDateTime.of(firstOfJuly, UTC)));
        add(new TransferDto().setId(2L).setAmount(-50L).setCurrency("EUR").setStatus(TransferStatusCode.PENDING).setBalanceAfter(150L).setReference("e2b7104e-e6b3-11e8-9f32-f2801f1b9fd1").setBeneficiary(new BeneficiaryDto().setAddress(new AddressDto())).setCreatedAt(ZonedDateTime.of(firstOfJuly, UTC).plusDays((1))));
        add(new TransferDto().setId(3L).setAmount(19L).setCurrency("EUR").setStatus(TransferStatusCode.REJECTED).setBalanceAfter(169L).setReference("e2b711ac-e6b3-11e8-9f32-f2801f1b9fd1").setOriginator(new OriginatorDto().setAddress(new AddressDto())).setCreatedAt(ZonedDateTime.of(firstOfJuly, UTC).plusDays(2)));
    }};


    public TransferDto getTransfer(Long id) {
        return transfers.stream()
                .filter(transfer -> id.equals(transfer.getId()))
                .findAny()
                .orElse(null);
    }

    public List<TransferDto> getTransfers() {
        return transfers;
    }
}
