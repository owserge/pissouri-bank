package com.pissouri.data;

import com.pissouri.common.TransferStatusCode;
import com.pissouri.common.TransferTypeCode;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.pissouri.common.TransferTypeCode.INCOMING;
import static com.pissouri.common.TransferTypeCode.OUTGOING;

/**
 * JPA specification for {@link Transfer} records
 */
public class TransferSpecification implements Specification<Transfer> {

    /** The identifier of the {@link Account} the record should be associated with */
    private Long accountId;

    /** The status of a record, as per {@link TransferStatusCode} */
    private String status;

    /** The type of a record, as per {@link TransferTypeCode} */
    private String type;

    public TransferSpecification setAccountId(Long accountId) {

        this.accountId = accountId;
        return this;
    }

    public TransferSpecification setStatus(String status) {

        this.status = status;
        return this;
    }

    public TransferSpecification setType(String type) {

        this.type = type;
        return this;
    }

    /**
     * @return A {@link Predicate} composed of conditions based on the class fields
     */
    @Override
    public Predicate toPredicate(Root<Transfer> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<>();

        if (Objects.nonNull(accountId)) {
            Path<Account> account = root.get("account");
            predicates.add(builder.equal(account.get("id"), accountId));
        }

        if (Objects.nonNull(status)) {
            predicates.add(builder.equal(root.get("status"), status));
        }

        if (Objects.nonNull(type)) {
            if (INCOMING.equals(type)) predicates.add(builder.greaterThan(root.get("amount"), 0));
            if (OUTGOING.equals(type)) predicates.add(builder.lessThan(root.get("amount"), 0));
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
