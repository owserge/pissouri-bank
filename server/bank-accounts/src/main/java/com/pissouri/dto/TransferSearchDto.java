package com.pissouri.dto;

import com.pissouri.common.TransferStatusCode;
import com.pissouri.common.TransferTypeCode;

import java.util.Objects;

/**
 * A {@link PageableDto} set of search parameters, used for filtering through a list of {@link TransferDto}
 */
public class TransferSearchDto implements PageableDto {

    /**
     * Type of bank transfer, as defined by {@link TransferTypeCode}
     */
    private String type;

    /**
     * Status of bank transfer, as defined by {@link TransferStatusCode}
     */
    private String status;

    /**
     * Number of transfers per page
     */
    private Integer size;

    /**
     * The transfers page to be retrieved
     */
    private Integer page;

    public String getType() {

        return type;
    }

    public TransferSearchDto setType(String type) {

        this.type = type;
        return this;
    }

    public String getStatus() {

        return status;
    }

    public TransferSearchDto setStatus(String status) {

        this.status = status;
        return this;
    }

    @Override
    public Integer getSize() {

        return size;
    }

    public TransferSearchDto setSize(Integer size) {

        this.size = size;
        return this;
    }

    @Override
    public Integer getPage() {

        return page;
    }

    public TransferSearchDto setPage(Integer page) {

        this.page = page;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferSearchDto that = (TransferSearchDto) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(status, that.status) &&
                Objects.equals(size, that.size) &&
                Objects.equals(page, that.page);
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, status, size, page);
    }

    @Override
    public String toString() {

        return "TransferSearchDto{" +
                "type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", size=" + size +
                ", page=" + page +
                '}';
    }
}
