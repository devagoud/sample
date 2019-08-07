package com.order.sample.domain;

import lombok.Data;

/**
 * @author devagoud
 */
@Data
public class Message {
    private String name;

    public Message(String name) {
        this.name = name;
    }
}
