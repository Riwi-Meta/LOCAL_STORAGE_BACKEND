package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic;

public interface UpdateService<Request, Response, Id> {
    Response update(Id id, Request request);
}
