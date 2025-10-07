package com.farukgenc.boilerplate.springboot.repository;

import com.farukgenc.boilerplate.springboot.model.PayTaxRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PayTaxRecordRepository extends JpaRepository<PayTaxRecord, Long> {

    List<PayTaxRecord> findByUsernameAndPayDateBetween(String username, LocalDateTime startDate, LocalDateTime endDate);
}
