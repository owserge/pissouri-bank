package com.pissouri.controller;

import com.pissouri.dto.ResponseDto;
import com.pissouri.dto.TransferDto;
import com.pissouri.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransferController {
    private TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {

        this.transferService = transferService;
    }

    @GetMapping(value = "/account/transfers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<TransferDto> getTransfer(@PathVariable("id") Long id) {
        return ResponseDto.ok(transferService.getTransfer(id));
    }

    @GetMapping(value = "/account/transfers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<List<TransferDto>> getTransfers() {
        return ResponseDto.ok(transferService.getTransfers());
    }
}
