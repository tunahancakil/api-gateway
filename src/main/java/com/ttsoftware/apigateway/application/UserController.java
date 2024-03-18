package com.ttsoftware.apigateway.application;

import com.ttsoftware.apigateway.domain.dto.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signupUser(@RequestBody SignupDto signupDto){
        return userService.signupUser(signupDto);
    }
}
