package com.farukgenc.boilerplate.springboot.repository;

import com.farukgenc.boilerplate.springboot.model.RefundTaxRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RecordRepository extends JpaRepository<RefundTaxRecord, Long> {

    List<RefundTaxRecord> findByUsernameAndRefundDateBetween(String username, LocalDateTime startDate, LocalDateTime endDate);
}
