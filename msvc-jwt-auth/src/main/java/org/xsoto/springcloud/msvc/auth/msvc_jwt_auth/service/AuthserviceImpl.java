package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.Rol;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.User;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.repository.UserRepository;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.request.LoginRequest;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.request.RegisterRequest;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.response.AuthResponse;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthserviceImpl implements AuthService{

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails=userRepository.findByUsername(request.getUsername()).orElseThrow();
        return AuthResponse.builder()
                .token(jwtService.getToken(userDetails))
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .status(request.getStatus())
                .createAt(new Date())
                .updateAt(new Date())
                .rol(Rol.USER)
                .build();
         userRepository.save(user);
         return AuthResponse.builder()
                 .token(jwtService.getToken(user))
                 .build();
    }
}
