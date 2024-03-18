package com.ttsoftware.apigateway.application.mapper;

import com.ttsoftware.apigateway.domain.dto.SignupDto;
import com.ttsoftware.apigateway.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(SignupDto signupDto);
}