package com.pissouri.service;


import com.pissouri.TypeConversions;
import com.pissouri.converter.TransferDtoConverter;
import com.pissouri.data.BankRoute;
import com.pissouri.data.Transfer;
import com.pissouri.data.TransferRepository;
import com.pissouri.data.TransferSpecification;
import com.pissouri.dto.TransferDto;
import com.pissouri.dto.TransferSearchDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.pissouri.common.TransferStatusCode.*;
import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.*;
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
    public void getTransferById_shouldReturnTransferDto_whenTransferFound() {

        givenTransfer();

        TransferDto transferDto = transferService.getTransfer(1L, 9L);

        assertThatTransferDtoIsValid(transferDto);
    }

    @Test
    public void getTransferById_shouldThrowResourceNotFoundException_whenTransferNotFound() {

        assertThatThrownBy(() -> transferService.getTransfer(1L, Long.MAX_VALUE))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(String.format("Transfer %d not found", Long.MAX_VALUE));
    }

    @Test
    public void getTransferById_shouldThrowIllegalArgumentException_whenAccountIdIsEqualToZero() {

        assertThatThrownBy(() -> transferService.getTransfer(0L, 1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument 0");
    }

    @Test
    public void getTransferById_shouldThrowIllegalArgumentException_whenAccountIdIsLessThanZero() {

        assertThatThrownBy(() -> transferService.getTransfer(-1L, 1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument -1");
    }

    @Test
    public void getTransferById_shouldThrowIllegalArgumentException_whenTransferIdIsEqualToZero() {

        assertThatThrownBy(() -> transferService.getTransfer(1L, 0L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument 0");
    }

    @Test
    public void getTransferById_shouldThrowIllegalArgumentException_whenTransferIdIsLessThanZero() {

        assertThatThrownBy(() -> transferService.getTransfer(1L, -1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument -1");
    }

    @Test
    public void getTransfers_shouldReturnListOfTransferDto_whenTransfersFound() {

        givenTransfers();

        List<TransferDto> transferDtoList = transferService.getTransfers(1L, new TransferSearchDto());

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
        assertThat(transferDto.getCreatedAt()).isEqualTo(LocalDate.ofYearDay(2018, 1).atStartOfDay(UTC));
    }

    private void givenTransfer() {

        when(transferRepository.findByIdAndAccountId(anyLong(), eq(1L)))
                .thenReturn(Optional.of(new Transfer()
                        .setId(9L)
                        .setAmount(100)
                        .setCurrency("EUR")
                        .setStatus(ACCEPTED)
                        .setBalanceAfter(100)
                        .setReference("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1")
                        .setCreatedAt(LocalDate.ofYearDay(2018, 1).atStartOfDay(UTC))
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

        Mockito
                .when(transferRepository.findAll(any(TransferSpecification.class), any(Pageable.class)))
                .thenReturn(new PageImpl<>(Arrays.asList(
                        new Transfer()
                                .setId(1L)
                                .setAmount(100)
                                .setCurrency("EUR")
                                .setStatus(ACCEPTED)
                                .setBalanceAfter(1000)
                                .setReference("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1")
                                .setCreatedAt(LocalDate.ofYearDay(2018, 1).atStartOfDay(UTC))
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
                                .setCreatedAt(LocalDate.ofYearDay(2018, 1).atStartOfDay(UTC))
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
                                        .setCountry("UK")))));
    }
}
