package com.pavi.bank.repository;

import com.pavi.bank.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
