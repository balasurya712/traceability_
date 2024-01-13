package com.example.traceability.models;


import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InputLot {
    
    @DocumentReference(collection = "inbound_Tranctions")
    public InboundTranction inputTranctionId;
    public int quantity;
}
