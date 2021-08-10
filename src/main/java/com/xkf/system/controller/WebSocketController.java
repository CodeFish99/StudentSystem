package com.xkf.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xukefei
 * @create 2021-08-10 上午10:21
 */
@Controller
public class WebSocketController {
    @RequestMapping("/websocket")
    public String init() {
        return "websocket.html";
    }
}
