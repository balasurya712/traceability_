package com.example.traceability.models;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("productions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Production {
    @Id
    public String _id;
    public String materialName;
    public String entityType;
    public int totalQuantityAvailable;
    public String lotNumber;
    public int remainingQuantity;
    public String materialComposition;
    public ArrayList<InputLot> inputLots;
}
