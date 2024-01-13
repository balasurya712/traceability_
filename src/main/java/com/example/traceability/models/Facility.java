package com.example.traceability.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("facilities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Facility {
    @Id
    private String _id;
    private String facilityName;
    private FacilityAddress facilityAddress;
    @DocumentReference(collection = "suppliers")
    private Supplier supplierId;
}
