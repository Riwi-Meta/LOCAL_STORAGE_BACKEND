package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import com.riwi.localstorage.riwi_local_storage.util.enums.SortType;

public interface CRUDService<REQUEST, RESPONSE, TYPE> {
    Page<RESPONSE> getAll(int page, int size, SortType sortType);

    RESPONSE getById(TYPE id);

    RESPONSE create(REQUEST request);

    RESPONSE update(REQUEST request, TYPE id);

    void disable(TYPE id);

}
