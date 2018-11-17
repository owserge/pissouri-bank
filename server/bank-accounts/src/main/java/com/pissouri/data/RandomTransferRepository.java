package com.pissouri.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of a {@link Transfer} repository which generates random records and serves them from memory
 */
@Repository
public class RandomTransferRepository implements TransferRepository {

    private final List<Transfer> transferList = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    public RandomTransferRepository(@Value("${memory.transfer.repository.records.size:25}") Integer records) {

        setup(records);
    }

    private void setup(final int records) {

        if (records <= 0) throw new IllegalArgumentException(String.format("Invalid memory transfer records size %d", records));

        synchronized (transferList) {
            if (transferList.isEmpty()) {
                for (int i = 0; i < records; i++) {
                    transferList.add(Transfers.random(i + 1));
                }
            }
        }
    }

    @Override
    public Optional<Transfer> getTransferById(Long id) {

        if (id == null || id <= 0) return Optional.empty();
        
        return transferList
                .stream()
                .filter(transfer -> id.equals(transfer.getId()))
                .findFirst();
    }

    @Override
    public List<Transfer> getTransfers() {

        return Collections.unmodifiableList(transferList);
    }
}
