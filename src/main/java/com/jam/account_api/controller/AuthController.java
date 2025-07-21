package com.jam.account_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<?> register() {
        // Implementation
        return ResponseEntity.ok("test register");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        // Implementation
        return ResponseEntity.ok("test login");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // Implementation
        return ResponseEntity.ok("test logout");
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verify() {
        // Implementation
        return ResponseEntity.ok("test verify");
    }

    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword() {
        // Implementation
        return ResponseEntity.ok("test reset password");
    }

    @DeleteMapping("/delete-account")
    public ResponseEntity<?> deleteAccount() {
        // Implementation
        return ResponseEntity.ok("test delete account");
    }
}
