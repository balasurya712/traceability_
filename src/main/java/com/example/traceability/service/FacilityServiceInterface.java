package com.example.traceability.service;

import java.util.List;

import com.example.traceability.models.Facility;

public interface FacilityServiceInterface {

    Facility saveData(Facility facility);

    List<Facility> getAllFacility();

    Facility getById(String id);

    Facility updateData(Facility facility);

    Boolean deleteData(String id);

}
