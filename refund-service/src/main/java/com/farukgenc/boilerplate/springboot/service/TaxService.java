package com.farukgenc.boilerplate.springboot.service;

import com.farukgenc.boilerplate.springboot.dto.AmountResponse;
import com.farukgenc.boilerplate.springboot.dto.RefundResponse;
import com.farukgenc.boilerplate.springboot.model.PayTaxRecord;
import com.farukgenc.boilerplate.springboot.model.RefundTaxRecord;
import com.farukgenc.boilerplate.springboot.repository.PayTaxRecordRepository;
import com.farukgenc.boilerplate.springboot.repository.RefundTaxRecordRepository;
import com.farukgenc.boilerplate.springboot.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaxService {

    @Autowired
    private PayTaxRecordRepository payTaxRecordRepository;
    @Autowired
    private RefundTaxRecordRepository refundTaxRecordRepository;

    public RefundResponse payRecordQuery(String username){

        int currentYear = Year.now().getValue();

        int lastYear = currentYear - 1;

        LocalDateTime startDate = LocalDateTime.parse(lastYear+"-01-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDate = LocalDateTime.parse(lastYear+"-12-31 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        LocalDateTime rStartDate = LocalDateTime.parse(currentYear+"-01-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime rEndDate = LocalDateTime.parse(currentYear+"-12-31 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


        List<PayTaxRecord> payList = payTaxRecordRepository.findByUsernameAndPayDateBetween(username,startDate,endDate);

        if(payList.isEmpty()){
           return new RefundResponse("1000");
        }else{
            List<RefundTaxRecord> refundList = refundTaxRecordRepository.findByUsernameAndRefundDateBetween(username,rStartDate,rEndDate);

            if(!refundList.isEmpty()){
                return new RefundResponse("1000");
            }
        }

        return new RefundResponse("1");
    }

    public AmountResponse calculateRefundAmount(String username){

        int currentYear = Year.now().getValue();

        int lastYear = currentYear - 1;

        LocalDateTime startDate = LocalDateTime.parse(lastYear+"-01-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDate = LocalDateTime.parse(lastYear+"-12-31 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        List<PayTaxRecord> payList = payTaxRecordRepository.findByUsernameAndPayDateBetween(username,startDate,endDate);

        BigDecimal refundAmount = BigDecimal.ZERO;

        if(!payList.isEmpty()){
            BigDecimal amount = BigDecimal.ZERO;
            for (int i = 0; i < payList.size(); i++) {
                amount = amount.add(payList.get(i).getPayTaxAmount());
            }

            refundAmount = amount.multiply(new BigDecimal(0.3)).setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        return new AmountResponse(refundAmount);
    }

    public RefundResponse applyRefundTex(String username){

        AmountResponse amountResponse = calculateRefundAmount(username);
        BigDecimal amount = amountResponse.getAmount();
        LocalDateTime localDateTime  = LocalDateTime.now();

        RefundTaxRecord refundTaxRecord = new RefundTaxRecord();
        refundTaxRecord.setRefundDate(localDateTime);
        refundTaxRecord.setRefundTaxAmount(amount);
        refundTaxRecord.setUsername(username);
        refundTaxRecordRepository.save(refundTaxRecord);
        return new RefundResponse("1");
    }
}
