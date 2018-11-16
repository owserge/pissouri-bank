package com.pissouri.dto;

import java.util.Objects;

/**
 * Set of search parameters, used for filtering a list of {@link TransferDto}
 */
public class TransferSearchDto {

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
    private int pageSize;

    /**
     * The transfers page to be retrieved
     */
    private int page;

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

    public int getPageSize() {

        return pageSize;
    }

    public TransferSearchDto setPageSize(int pageSize) {

        this.pageSize = pageSize;
        return this;
    }

    public int getPage() {

        return page;
    }

    public TransferSearchDto setPage(int page) {

        this.page = page;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferSearchDto that = (TransferSearchDto) o;
        return pageSize == that.pageSize &&
                page == that.page &&
                Objects.equals(type, that.type) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, status, pageSize, page);
    }

    @Override
    public String toString() {

        return "TransferSearchDto{" +
                "type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", pageSize=" + pageSize +
                ", page=" + page +
                '}';
    }
}
