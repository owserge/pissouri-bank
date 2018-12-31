package com.pissouri.service;

import com.pissouri.dto.PageableDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Static utility methods for paging
 */
final class Paging {

    /** Default value to use when page size is not provided or is not defined */
    private static final int PAGE_SIZE_DEFAULT = 10;

    /**
     * @return A {@link PageRequest}, with sorting options, based on information provided by a {@link PageableDto}
     */
    static Pageable of(PageableDto pageableDto, Sort sort) {

        int page = pageableDto.getPage() != null ? pageableDto.getPage() :  0;
        int size = pageableDto.getSize() != null ? pageableDto.getSize() : PAGE_SIZE_DEFAULT;

        return PageRequest.of(page, size, sort);
    }
}