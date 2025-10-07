package com.farukgenc.boilerplate.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RefundRequest {

    private String username;

    private String password;
}
