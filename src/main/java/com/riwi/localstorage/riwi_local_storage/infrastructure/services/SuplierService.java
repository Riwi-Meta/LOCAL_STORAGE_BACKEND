package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.time.LocalDateTime;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.SupplierRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.SupplierResponse;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.SupplierResponseRelations;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Supplier;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.SupplierRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.ISupplierService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.helpers.EmailHelpper;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.SupplierMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SuplierService implements ISupplierService{

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired 
    private EmailHelpper emailHelpper;
    
    @Override
    public SupplierResponseRelations create(SupplierRequest request) {
        Supplier supplier = supplierMapper.toSupplier(request);
        supplier.setEnable(true);
        return supplierMapper.toSupplierResponse(supplierRepository.save(supplier));
    }

    @Override
    public Optional<SupplierResponseRelations> getById(String id) {

        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (supplier.isEmpty()) throw new IdNotFoundException("SUPPLIER", id);

        return supplier.map(supplierMapper::toSupplierResponse);
    }

    @Override
    public Page<SupplierResponseRelations> getAll(Pageable pageable) {
        return supplierRepository.findAll(pageable).map(supplier -> supplierMapper.toSupplierResponse(supplier));
    }

    @Override
    public void sendEmail(String supplierId, String title, String description, String name, LocalDateTime date) {
        Supplier supplier = supplierRepository.findById(supplierId).orElseThrow();         
        emailHelpper.sendEmail(supplier.getEmail(), description, title, name, date, "/src/main/resources/static/emails/supplierEmail.html");
    }

    @Override
    public void delete(String id) {
        Supplier supplier = supplierRepository.findById(id)
        .orElseThrow(()-> new IdNotFoundException("SUPPLIER", id));
        supplier.setEnable(false);
        supplierRepository.save(supplier);
    }

    @Override
    public Optional<SupplierResponseRelations> getByName(String supplierName) {
        Optional<Supplier> supplier = supplierRepository.findByName(supplierName)
        if (supplier.isEmpty()) throw new IdNotFoundException("SUPPLIER", supplierName);
        return supplier.map(supplierMapper::toSupplierResponse);
    }
}
