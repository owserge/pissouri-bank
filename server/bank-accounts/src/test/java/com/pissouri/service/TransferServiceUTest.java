package com.pissouri.service;


import com.pissouri.TypeConversions;
import com.pissouri.converter.TransferDtoConverter;
import com.pissouri.data.BankRoute;
import com.pissouri.data.Transfer;
import com.pissouri.data.TransferRepository;
import com.pissouri.dto.TransferDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.ConversionService;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.pissouri.dto.TransferStatusCode.*;
import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransferServiceUTest {

    private TransferRepository transferRepository;
    private TransferService transferService;

    @Before
    public void setup() {

        transferRepository = mock(TransferRepository.class);
        ConversionService conversionService = TypeConversions.serviceOf(new TransferDtoConverter());
        transferService = new TransferService(transferRepository, conversionService);
    }

    @Test
    public void getTransferById_shouldReturnTransferDto_whenTransferExists() {

        givenTransfer();

        TransferDto transferDto = transferService.getTransfer(9L);

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

        givenTransfers();

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

    private void givenTransfer() {

        when(transferRepository.findById(anyLong()))
                .thenReturn(Optional.of(new Transfer()
                        .setId(9L)
                        .setAmount(100)
                        .setCurrency("EUR")
                        .setStatus(ACCEPTED)
                        .setBalanceAfter(100)
                        .setReference("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1")
                        .setCreatedAt(ZonedDateTime.of(2018, 7, 1, 0, 0, 0, 0, UTC))
                        .setBankRoute(new BankRoute()
                                .setId(9L)
                                .setFullName("Alcohol co. Ltd")
                                .setBic("PBBE10080")
                                .setIban("PB63910000004543")
                                .setSwiftCode("PB10080")
                                .setAccountNumber("90001050")
                                .setSortCode("10090")
                                .setStreet("1 Pissouri Ave")
                                .setCity("Paphos")
                                .setPostalCode("5200")
                                .setCountry("CY"))));
    }

    private void givenTransfers() {

        when(transferRepository.findAll()).thenReturn(Arrays.asList(
                new Transfer()
                        .setId(1L)
                        .setAmount(100)
                        .setCurrency("EUR")
                        .setStatus(ACCEPTED)
                        .setBalanceAfter(1000)
                        .setReference("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1")
                        .setCreatedAt(ZonedDateTime.of(2018, 7, 1, 0, 0, 0, 0, UTC))
                        .setBankRoute(new BankRoute()
                                .setId(1L)
                                .setFullName("Burgers Paphos")
                                .setBic("PBBE10080")
                                .setIban("PB63910000004543")
                                .setSwiftCode("PB10080")
                                .setAccountNumber("90001050")
                                .setSortCode("10090")
                                .setStreet("1 Pissouri Ave")
                                .setCity("Paphos")
                                .setPostalCode("5200")
                                .setCountry("CY")),

                new Transfer()
                        .setId(2L)
                        .setAmount(-100)
                        .setCurrency("GBP")
                        .setStatus(PENDING)
                        .setBalanceAfter(900)
                        .setReference("1189aca5-e628-4be6-82b7-d12b37e437d0")
                        .setCreatedAt(ZonedDateTime.of(2018, 7, 2, 0, 0, 0, 0, UTC))
                        .setBankRoute(new BankRoute()
                                .setId(2L)
                                .setFullName("Burgers Nicosia")
                                .setBic("NVBE10234")
                                .setIban("NV63910000005871")
                                .setSwiftCode("NV10918")
                                .setAccountNumber("90001255")
                                .setSortCode("10013")
                                .setStreet("1 God Save the Queen St")
                                .setCity("London")
                                .setPostalCode("E7500")
                                .setCountry("UK"))));
    }
}
