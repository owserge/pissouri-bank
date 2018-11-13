package com.pissouri.data;

import java.util.List;
import java.util.Optional;

public interface TransferRepository {

    Optional<Transfer> getTransferById(Long id);

    List<Transfer> getTransfers();
}
