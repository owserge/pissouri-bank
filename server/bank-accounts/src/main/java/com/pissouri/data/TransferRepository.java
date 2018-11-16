package com.pissouri.data;

import java.util.List;
import java.util.Optional;

/**
 * Data access repository for {@link Transfer} data record models
 */
public interface TransferRepository {

    /**
     * Retrieve a {@link Transfer} data record by record id
     * @return The corresponding {@link Transfer} record, empty if not found
     */
    Optional<Transfer> getTransferById(Long id);

    /**
     * Retrieve a list of {@link Transfer} data records
     * @return List of {@link Transfer} data records
     */
    List<Transfer> getTransfers();
}
