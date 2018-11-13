package com.pissouri.data;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static com.pissouri.dto.TransferStatusCode.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MemoryTransferRepositoryUTest {

    private TransferRepository transferRepository;

    @Before
    public void setup() {

        transferRepository = new MemoryTransferRepository();
    }

    @Test
    public void getTransferById_shouldReturnOptionalOfTransfer_ifTransferExists() {

        Optional<Transfer> transferOptional = transferRepository.getTransferById(1L);

        assertThat(transferOptional).isNotNull();
        assertThat(transferOptional).isNotEmpty();
        assertThat(transferOptional.isPresent()).isTrue();

        assertThatTransferIsValid(transferOptional.orElseThrow(AssertionError::new));
    }

    @Test
    public void getTransferById_shouldReturnOptionalEmpty_ifTransferDoesNotExist() {

        Optional<Transfer> transferOptional = transferRepository.getTransferById(Long.MAX_VALUE);

        assertThat(transferOptional).isNotNull();
        assertThat(transferOptional).isEmpty();
        assertThat(transferOptional.isPresent()).isFalse();
    }

    @Test
    public void getTransfers_shouldReturnTransferList() {

        List<Transfer> transferList = transferRepository.getTransfers();

        assertThat(transferList).isNotNull();
        assertThat(transferList).isNotEmpty();
        assertThat(transferList).allSatisfy(this::assertThatTransferIsValid);
    }

    private void assertThatTransferIsValid(Transfer transfer) {

        assertThat(transfer).isNotNull();
        assertThat(transfer.getId()).isGreaterThan(0);
        assertThat(transfer.getAmount()).isNotEqualTo(0);
        assertThat(transfer.getCurrency()).isNotNull();
        assertThat(transfer.getCurrency().length()).isEqualTo(3);
        assertThat(transfer.getStatus()).isNotNull();
        assertThat(transfer.getStatus()).isIn(PENDING, ACCEPTED, REJECTED);
        assertThat(transfer.getReference()).isNotNull();
        assertThat(transfer.getReference()).isNotEmpty();
        assertThat(transfer.getCreatedAt()).isNotNull();
    }
}
