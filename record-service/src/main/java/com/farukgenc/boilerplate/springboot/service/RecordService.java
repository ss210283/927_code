package com.farukgenc.boilerplate.springboot.service;

import com.farukgenc.boilerplate.springboot.model.RefundTaxRecord;
import com.farukgenc.boilerplate.springboot.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    public List<RefundTaxRecord> refundTexRecordQuery(String username,String year){

        int currentYear = Integer.parseInt(year)+1;

        LocalDateTime StartDate = LocalDateTime.parse(currentYear+"-01-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime EndDate = LocalDateTime.parse(currentYear+"-12-31 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return recordRepository.findByUsernameAndRefundDateBetween(username,StartDate,EndDate);
    }
}
