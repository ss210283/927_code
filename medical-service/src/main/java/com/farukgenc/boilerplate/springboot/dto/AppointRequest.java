package com.farukgenc.boilerplate.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AppointRequest {

    private Long hospitalId;
    private Long doctorId;
    private String username;
    private LocalDateTime appointDatetime;
}
