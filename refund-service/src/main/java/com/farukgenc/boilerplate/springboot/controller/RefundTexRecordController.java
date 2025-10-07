package com.farukgenc.boilerplate.springboot.controller;

import com.farukgenc.boilerplate.springboot.dto.AmountResponse;
import com.farukgenc.boilerplate.springboot.dto.RefundResponse;
import com.farukgenc.boilerplate.springboot.service.TaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/refund")
public class RefundTexRecordController {

    private final TaxService taxService;

    @GetMapping("/payRecordQuery")
    public ResponseEntity<RefundResponse> payRecordQuery(@RequestParam("username") String username) {

        RefundResponse refundResponse = taxService.payRecordQuery(username);
        return ResponseEntity.ok(refundResponse);
    }

    @GetMapping("/calculateRefundAmount")
    public ResponseEntity<AmountResponse> calculateRefundAmount(@RequestParam("username") String username) {

        AmountResponse amountResponse = taxService.calculateRefundAmount(username);
        return ResponseEntity.ok(amountResponse);
    }

    @GetMapping("/applyRefundTex")
    public ResponseEntity<RefundResponse> applyRefundTex(@RequestParam("username") String username) {

        RefundResponse refundResponse = taxService.applyRefundTex(username);
        return ResponseEntity.ok(refundResponse);
    }
}
