package com.pissouri.service;


import com.pissouri.data.MemoryTransferRepository;
import com.pissouri.dto.TransferDto;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.pissouri.dto.TransferStatusCode.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TransferServiceUTest {

    private TransferService transferService;

    @Before
    public void setup() {

        transferService = new TransferService(new MemoryTransferRepository());
    }

    @Test
    public void getTransferById_shouldReturnTransferDto_whenTransferExists() {

        TransferDto transferDto = transferService.getTransfer(1L);

        assertThatTransferDtoIsValid(transferDto);
    }

    @Test
    public void getTransferById_shouldThrowResourceNotFoundException_whenTransferDoesNotExist() {

        assertThatThrownBy(() -> transferService.getTransfer(Long.MAX_VALUE))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(String.format("Transfer %d not found", Long.MAX_VALUE));
    }

    @Test
    public void getTransferById_shouldThrowIllegalArgumentException_whenTransferIdIsNull() {

        assertThatThrownBy(() -> transferService.getTransfer(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument null");
    }

    @Test
    public void getTransferById_shouldThrowIllegalArgumentException_whenTransferIdNotGreaterThanZero() {

        assertThatThrownBy(() -> transferService.getTransfer(0L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument 0");

        assertThatThrownBy(() -> transferService.getTransfer(-1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument -1");
    }

    @Test
    public void getTransfers_shouldReturnListOfTransferDto() {

        List<TransferDto> transferDtoList = transferService.getTransfers();

        assertThat(transferDtoList).isNotNull();
        assertThat(transferDtoList).isNotEmpty();
        assertThat(transferDtoList).allSatisfy(this::assertThatTransferDtoIsValid);
    }

    private void assertThatTransferDtoIsValid(TransferDto transferDto) {

        assertThat(transferDto).isNotNull();
        assertThat(transferDto.getId()).isGreaterThan(0);
        assertThat(transferDto.getAmount()).isNotEqualTo(0);
        assertThat(transferDto.getCurrency()).isNotNull();
        assertThat(transferDto.getCurrency()).isNotEmpty();
        assertThat(transferDto.getCurrency().length()).isEqualTo(3);
        assertThat(transferDto.getStatus()).isNotNull();
        assertThat(transferDto.getStatus()).isIn(PENDING, ACCEPTED, REJECTED);
        assertThat(transferDto.getReference()).isNotNull();
        assertThat(transferDto.getReference()).isNotEmpty();
        assertThat(transferDto.getCreatedAt()).isNotNull();
    }
}
