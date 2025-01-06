package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.request.LoginRequest;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.request.RegisterRequest;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.response.AuthResponse;

public interface AuthService {
    public AuthResponse register(RegisterRequest request);
    public AuthResponse login(LoginRequest request);
}
