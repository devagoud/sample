package com.order.sample;

import lombok.Data;

/**
 * @author devagoud
 */
@Data
public class ResponseMesage {
    private String message;

    public ResponseMesage(String message) {
        this.message = message;
    }
}
