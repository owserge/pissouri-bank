package com.pissouri.dto;

/**
 * A data transfer object that contains information on paging
 */
public interface PageableDto {

    /** The number of records per page */
    Integer getSize();

    /** The page to be retrieved */
    Integer getPage();
}
