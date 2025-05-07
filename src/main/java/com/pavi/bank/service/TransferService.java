package com.pavi.bank.service;

import com.pavi.bank.domain.DTO.TransferRequest;
import com.pavi.bank.model.Account;
import com.pavi.bank.model.Transaction;
import com.pavi.bank.repository.AccountRepository;
import com.pavi.bank.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TransferService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;



    public Transaction transfer(TransferRequest request) {
        Account sender = accountRepository.findByAccountNumber(request.senderAccount())
                .orElseThrow(() -> new RuntimeException("Sender account not found."));

        Account receiver = accountRepository.findByAccountNumber(request.receiverAccount())
                .orElseThrow(() -> new RuntimeException("Receiver account not found."));

        if (sender.getBalance() < request.amount()) {
            throw new RuntimeException("Insufficient balance.");
        }

        sender.setBalance(sender.getBalance() - request.amount());
        receiver.setBalance(receiver.getBalance() + request.amount());

        Transaction transaction = new Transaction(sender, receiver, request.amount());
        return transactionRepository.save(transaction);
    }

}
