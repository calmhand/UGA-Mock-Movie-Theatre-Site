package com.backend.example.Controller;

import org.springframework.web.bind.annotation.*;;

@RestController
@RequestMapping("/api/messages")
public class BackEndController {
    
    @GetMapping("/hello")
    public String Hello() {
        return "HELLO";
    }

    @GetMapping("/test")
    public String Test() {
        return "Good test.";
    }
    
}
