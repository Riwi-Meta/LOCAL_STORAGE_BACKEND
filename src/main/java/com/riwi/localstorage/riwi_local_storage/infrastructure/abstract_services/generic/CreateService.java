package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic;

public interface CreateService<Request, Response> {
    Response create(Request request);
}
