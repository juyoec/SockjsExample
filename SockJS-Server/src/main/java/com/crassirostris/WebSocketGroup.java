package com.crassirostris;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by crassirostris on 2016. 12. 31..
 */
public class WebSocketGroup extends ArrayList<WebSocketSession> {
    public void sendMessage(String message) {
        TextMessage textMessage = new TextMessage(message);
        this.stream().forEach(webSocketSession -> {
            try {
                if (!webSocketSession.isOpen()) return;
                webSocketSession.sendMessage(textMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public List<String> ids() {
        return this.stream().map(webSocketSession -> webSocketSession.getId()).collect(Collectors.toList());
    }
}
