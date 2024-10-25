package com.example.demo.controller;

import com.example.demo.DTO.LoginUserDto;
import com.example.demo.DTO.RegisterUserDto;
import com.example.demo.DTO.VerifyUserDto;
import com.example.demo.model.User;
import com.example.demo.responses.LoginResponse;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.JwtService;
import org.apache.coyote.Response;
import org.springframework.context.annotation.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }
    // mapping for signup : post mapping
    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto input){
        User user = authenticationService.signup(input);
        return ResponseEntity.ok(user);
    }

    // mapping for verifying a user : when user enters the verification code
    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody VerifyUserDto input){
        try {
            authenticationService.verifyUser(input);
            return ResponseEntity.ok("Account verified scuccessfully");
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto input){
        User user = authenticationService.authenticate(input);
        String token = jwtService.generateToken(user);
        LoginResponse loginResponse = new LoginResponse(token, jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    // resending emails for verification
    @PostMapping("/resend")
    public ResponseEntity<?> resend(@RequestBody String email){
        try {
            authenticationService.resendVerificationCode(email);
            return ResponseEntity.ok("Re-sent Verification code was again sent successfully");
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
