package com.pavi.bank.domain.DTO;

import java.time.LocalDateTime;

public record TransferResponse(
        String status,
        String message,
        String transactionId,
        LocalDateTime timestamp,
        Double newBalance
) {}
