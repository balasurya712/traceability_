package com.example.traceability.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.traceability.models.Supplier;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier,String> {

}
