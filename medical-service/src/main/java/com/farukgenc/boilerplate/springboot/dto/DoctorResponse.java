package com.farukgenc.boilerplate.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DoctorResponse {

    private Long id;

    private String doctorName;

    private List<String> times;

    public DoctorResponse() {

    }
}
