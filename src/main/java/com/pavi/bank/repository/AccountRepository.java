package com.pavi.bank.repository;

import com.pavi.bank.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);
}
