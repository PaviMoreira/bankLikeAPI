package com.pavi.bank.controller;

import com.pavi.bank.domain.DTO.TransferRequest;
import com.pavi.bank.domain.DTO.TransferResponse;
import com.pavi.bank.model.Transaction;
import com.pavi.bank.service.TransferService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log
@RequestMapping("/transference")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping(path = "/transfer")
    public ResponseEntity<String> transfer(@Valid @RequestBody TransferRequest request){

        Transaction transaction = transferService.transfer(request);

        TransferResponse response = new TransferResponse(
                "SUCCESS",
                "Transfer completed successfully.",
                transaction.getId().toString(),
                transaction.getTimestamp(),
                transaction.getReceiverAccount().getBalance()
        );

        return ResponseEntity.ok("Transfer completed successfully");
    }


}
