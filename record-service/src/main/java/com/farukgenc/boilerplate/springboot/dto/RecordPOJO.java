package com.farukgenc.boilerplate.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class RecordPOJO {

    private Long id;

    private BigDecimal refundTaxAmount;

    private String refundDate;

    private String username;

    public RecordPOJO() {

    }
}
