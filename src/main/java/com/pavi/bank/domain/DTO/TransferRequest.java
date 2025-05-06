package com.pavi.bank.domain.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record TransferRequest(
        @NotBlank String senderAccount,
        @NotBlank String receiverAccount,
        @Positive Double amount
) {

}
