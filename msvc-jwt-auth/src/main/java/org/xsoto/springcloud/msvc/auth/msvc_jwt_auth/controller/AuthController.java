package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.request.LoginRequest;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.request.RegisterRequest;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.response.AuthResponse;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public  ResponseEntity<AuthResponse> register (@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

}
