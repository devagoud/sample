package com.order.sample.controller;

import com.order.sample.domain.Greeting;
import com.order.sample.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.Map;

/**
 * @author devagoud
 */
@Controller
@Slf4j
public class WebSocketController {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;


    @MessageMapping("/message/{fleetId}")
    @SendTo("/topic/reply")
    public String processMessageFromClient(@DestinationVariable String fleetId) throws Exception {
        log.info("OrderId {}",fleetId);
        System.out.println(fleetId);
        return fleetId;
    }

    @MessageExceptionHandler
    public String handleException(Throwable exception) {
        messagingTemplate.convertAndSend("/errors", exception.getMessage());
        return exception.getMessage();
    }
}
