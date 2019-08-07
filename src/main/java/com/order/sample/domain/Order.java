package com.order.sample.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * @author devagoud
 */
@Document
@Data
public class Order {
    private String orderId= UUID.randomUUID().toString();
    private String itemName;
    private int itemPrice;
    private String itemTime;
    private String description;
    private String itemType;
}
