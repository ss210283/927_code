package com.farukgenc.boilerplate.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageForwardController {

    // 访问 /refund/refundApplication.html 时，转发到静态资源 /refundApplication.html
    @GetMapping("/refund/refundApplication.html")
    public String forwardRefundPage() {
        return "forward:/refundApplication.html";
    }
}
