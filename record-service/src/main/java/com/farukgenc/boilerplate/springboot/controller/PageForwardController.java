package com.farukgenc.boilerplate.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageForwardController {

    @GetMapping("/record/refundRecordQuery.html")
    public String forwardRecordPage() {
        return "forward:/refundRecordQuery.html";
    }
}
