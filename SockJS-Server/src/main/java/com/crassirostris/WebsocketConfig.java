package com.crassirostris;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by crassirostris on 2016. 12. 31..
 */
@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer{
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler(), "/endpoint")
                .withSockJS()
                .setStreamBytesLimit(512* 1024)
                .setDisconnectDelay(30* 1000);
    }

    @Bean
    public WebSocketGroup group() {
        return new WebSocketGroup();
    }

    @Bean
    public EndpointHandler handler() {
        return new EndpointHandler();
    }
}
