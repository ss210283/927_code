package com.farukgenc.boilerplate.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageForwardController {

    // /medical/identityVerification.html -> static/identityVerification.html
    @GetMapping("/medical/identityVerification.html")
    public String forwardIdentity() {
        return "forward:/identityVerification.html";
    }

    // /medical/hospitalChoice.html -> static/hospitalChoice.html
    @GetMapping("/medical/hospitalChoice.html")
    public String forwardHospital() {
        return "forward:/hospitalChoice.html";
    }
}
