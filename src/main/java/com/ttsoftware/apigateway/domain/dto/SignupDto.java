package com.ttsoftware.apigateway.domain.dto;

import lombok.Data;

@Data
public class SignupDto {
    private String email;
    private String name;
    private String password;
    private String username;
}
