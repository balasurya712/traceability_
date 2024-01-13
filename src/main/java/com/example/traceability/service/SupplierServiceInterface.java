package com.example.traceability.service;

import java.util.List;

import com.example.traceability.models.Supplier;

public interface SupplierServiceInterface {

    Supplier getById(String id);

    List<Supplier> getAllSupplier();

    Supplier saveData(Supplier supplier);

    Supplier updateData(Supplier supplier);

    Boolean deleteData(String id);

}
