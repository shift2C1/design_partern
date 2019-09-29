package com.test.eg.handler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestHandler {
    @RequestMapping("/test")
    public String test(){
        return "hahah";
    }
}
