package com.example.traceability.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.traceability.models.Facility;
import java.util.List;


@Repository
public interface FacilityRepository extends MongoRepository<Facility,String>{
 Boolean deleteBy_id(String _id);
 List<Facility> getBy_id(String _id);
}
