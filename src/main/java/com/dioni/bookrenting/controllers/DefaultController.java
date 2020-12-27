package com.dioni.bookrenting.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/ping")
    public String getPing() {
        return "pong";
    }

}
