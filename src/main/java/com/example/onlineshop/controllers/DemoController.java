package com.example.onlineshop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("")
    public ResponseEntity<String> getDemoMessage() {
        return new ResponseEntity<>("Hello from Spring!",HttpStatus.OK);
    }

}
