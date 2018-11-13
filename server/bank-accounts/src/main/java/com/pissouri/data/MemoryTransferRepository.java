package com.pissouri.data;

import com.pissouri.dto.TransferStatusCode;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.time.ZoneOffset.UTC;

@Repository
public class MemoryTransferRepository implements TransferRepository {

    private static final LocalDateTime FIRST_OF_JULY = LocalDateTime.of(2018, 7, 1, 0, 0);

    private static final List<Transfer> TRANSFER_LIST = Arrays.asList(

            new Transfer()
                    .setId(1L)
                    .setAmount(100L)
                    .setCurrency("EUR")
                    .setStatus(TransferStatusCode.ACCEPTED)
                    .setBalanceAfter(100L)
                    .setReference("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1")
                    .setCreatedAt(ZonedDateTime.of(FIRST_OF_JULY, UTC)),

            new Transfer()
                    .setId(2L)
                    .setAmount(-50L)
                    .setCurrency("EUR")
                    .setStatus(TransferStatusCode.PENDING)
                    .setBalanceAfter(150L)
                    .setReference("e2b7104e-e6b3-11e8-9f32-f2801f1b9fd1")
                    .setCreatedAt(ZonedDateTime.of(FIRST_OF_JULY, UTC).plusDays((1))),

            new Transfer()
                    .setId(3L)
                    .setAmount(19L)
                    .setCurrency("EUR")
                    .setStatus(TransferStatusCode.REJECTED)
                    .setBalanceAfter(169L)
                    .setReference("e2b711ac-e6b3-11e8-9f32-f2801f1b9fd1")
                    .setCreatedAt(ZonedDateTime.of(FIRST_OF_JULY, UTC).plusDays(2))
    );

    @Override
    public Optional<Transfer> getTransferById(Long id) {

        return TRANSFER_LIST
                .stream()
                .filter(transfer -> id.equals(transfer.getId()))
                .findFirst();
    }

    @Override
    public List<Transfer> getTransfers() {

        return Collections.unmodifiableList(TRANSFER_LIST);
    }
}
