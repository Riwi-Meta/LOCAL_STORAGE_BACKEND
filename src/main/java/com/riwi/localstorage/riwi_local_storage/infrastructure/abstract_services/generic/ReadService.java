package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic;

import java.util.Optional;

public interface ReadService<Response, Id> {
    Optional<Response> getById(Id id);
}
