package com.kubernetes.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/status")
    public String test(){
        return "Application is up!";
    }
}
