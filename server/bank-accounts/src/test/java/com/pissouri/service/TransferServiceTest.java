package com.pissouri.service;


import com.pissouri.dto.TransferDto;
import com.pissouri.dto.TransferStatusCode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransferServiceTest {
    private TransferService transferService;

    @Before
    public void setup() {

        transferService = new TransferService();
    }

    @Test
    public void getTransferById_shouldReturnTransferDto() {

        TransferDto transferDto = transferService.getTransfer(1L);

        assertThat(transferDto).isNotNull();
        assertThat(transferDto.getId()).isEqualTo(1);
        assertThat(transferDto.getCurrency()).isNotNull();
        assertThat(transferDto.getCurrency()).isNotEmpty();
        assertThat(transferDto.getCurrency().length()).isEqualTo(3);
        assertThat(transferDto.getCurrency()).isEqualTo("EUR");
        assertThat(transferDto.getStatus()).isNotNull();
        assertThat(transferDto.getStatus()).isNotEmpty();
        assertThat(transferDto.getStatus()).isEqualTo(TransferStatusCode.ACCEPTED);
        assertThat(transferDto.getBalanceAfter()).isEqualTo(100);
        assertThat(transferDto.getReference()).isNotNull();
        assertThat(transferDto.getReference()).isNotEmpty();
        assertThat(transferDto.getReference()).isEqualTo("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1");
        assertThat(transferDto.getCreatedAt()).isNotNull();
        assertThat(transferDto.getCreatedAt()).isEqualTo("2018-07-01T00:00:00Z");
    }
}
