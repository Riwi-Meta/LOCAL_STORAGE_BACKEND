package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReadAllService<Request, Response> {
    Page<Response> getAll(Pageable pageable); 
}
