package com.pissouri.data;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> getAccount();
}
