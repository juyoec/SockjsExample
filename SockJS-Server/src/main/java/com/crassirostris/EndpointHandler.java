package com.crassirostris;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by crassirostris on 2016. 12. 31..
 */
@Slf4j
public class EndpointHandler implements WebSocketHandler {
    @Autowired
    private WebSocketGroup group;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("afterConnectionEstablished" + session.getId());
        group.add(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        WebSocketMessage<String> stringMessage = (WebSocketMessage<String>)message;
        String massage = stringMessage.getPayload();
        log.info("handleMessage" + session.getId() + "message : " + massage);
        group.sendMessage(massage);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("handleTransportError" + session.getId(), exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("afterConnectionClosed" + session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
