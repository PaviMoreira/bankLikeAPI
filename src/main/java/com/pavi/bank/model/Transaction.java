package com.pavi.bank.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Account receiverAccount;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Account senderAccount;

    private Double amount;

    private LocalDateTime timestamp;

    public Transaction(Account senderAccount, Account receiverAccount, Double amount) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

}
