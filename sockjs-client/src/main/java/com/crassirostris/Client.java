package com.crassirostris;

import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;

import java.util.List;

/**
 * Created by crassirostris on 2016. 12. 31..
 */
public class Client extends SockJsClient {

    public Client(List<Transport> transports) {
        super(transports);
    }
}
