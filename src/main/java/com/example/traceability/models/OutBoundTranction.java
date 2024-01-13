package com.example.traceability.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("outbound_tranctions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OutBoundTranction {
    public String _id;
    public String productName;
     @DocumentReference(collection = "productions")
    public Production lotNumber;
    public int quantity;
    public String shipmentDate;
    public String customerName;
}
