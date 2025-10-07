package com.farukgenc.boilerplate.springboot.controller;


import com.farukgenc.boilerplate.springboot.model.RefundTaxRecord;
import com.farukgenc.boilerplate.springboot.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/refundTexRecordQuery")
    public ResponseEntity<List<RefundTaxRecord>> refundTexRecordQuery(@RequestParam("username") String username, @RequestParam("year") String year) {

        List<RefundTaxRecord> list = recordService.refundTexRecordQuery(username,year);
        return ResponseEntity.ok(list);
    }
}
