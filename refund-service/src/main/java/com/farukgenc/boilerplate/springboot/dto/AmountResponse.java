package com.farukgenc.boilerplate.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class AmountResponse {

    private BigDecimal amount;
}
