package com.ttsoftware.apigateway.application;

import com.ttsoftware.apigateway.application.config.JwtTokenUtil;
import com.ttsoftware.apigateway.domain.dto.LoginDto;
import com.ttsoftware.apigateway.model.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginDto loginDto){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            final UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginDto.getUsernameOrEmail());

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            return ResponseEntity.ok(new JwtResponse(null));
        }
    }

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }
}