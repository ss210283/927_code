package com.farukgenc.boilerplate.springboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gateway")
public class GatewayController {

    @GetMapping("/distribute")
    public void refundTexRecordQuery(@RequestParam("type") String type) {

        System.out.println("111111");
    }
}
