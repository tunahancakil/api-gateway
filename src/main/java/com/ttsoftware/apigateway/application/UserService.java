package com.ttsoftware.apigateway.application;

import com.ttsoftware.apigateway.application.mapper.UserMapper;
import com.ttsoftware.apigateway.domain.dto.SignupDto;
import com.ttsoftware.apigateway.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ResponseEntity<String> signupUser(SignupDto signupDto) {
        userRepository.save(userMapper.toUser(signupDto));
        return new ResponseEntity<>("User signup successfully!.", HttpStatus.OK);
    }
}
