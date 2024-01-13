package com.example.traceability.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document("inbound_tranctions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InboundTranction {
    @Id
    public String _id;
    public String materialName;
    public String entityType;
    public String materialComposition;
    public String lotNumber;
    public String invoiceNumber;
    public String sellerName;
    public String invoiceDate;
    public double inboundQuantity;
    public double remainingQuantity;
}
