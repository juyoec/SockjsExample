package com.crassirostris;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by crassirostris on 2016. 12. 31..
 */
@Slf4j
@Controller
public class HelloController {
    @Autowired
    private WebSocketGroup group;
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/send/{username}/{message}")
    public List<String> send(@PathVariable("username") String username, @PathVariable("message") String message) {
        String paload = String.format("{\"username\":\"%s\", \"message\":\"%s\"}", username, message);
        group.sendMessage(paload);

        return group.ids();
    }
}
