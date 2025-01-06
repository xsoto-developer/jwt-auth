package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth;

//import com.example.jwt.auth.controller.AuthController;
//import com.example.jwt.auth.dto.AuthResponse;
//import com.example.jwt.auth.dto.LoginRequest;
//import com.example.jwt.auth.dto.RegisterRequest;
//import com.example.jwt.auth.service.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.controller.AuthController;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.Rol;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.User;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.request.LoginRequest;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.request.RegisterRequest;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.response.AuthResponse;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service.AuthService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthService authService;

    @Test
    public void testLogin() {
        // Given
        LoginRequest loginRequest = LoginRequest.builder()
                .username("nombre")
                .password("123456")
                .build();
        AuthResponse expectedResponse = new AuthResponse("token");
        when(authService.login(loginRequest)).thenReturn(expectedResponse);

        // When
        ResponseEntity<AuthResponse> response = authController.login(loginRequest);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    public void testRegister() {
        // Given
        RegisterRequest registerRequest = RegisterRequest.builder()
                .username("nombre")
                .email("nombre@mail.com")
                .password("123456")
                .status(true)
                .createAt(new Date())
                .updateAt(new Date())
                .build();

        AuthResponse expectedResponse = new AuthResponse("token");
        when(authService.register(registerRequest)).thenReturn(expectedResponse);

        // When
        ResponseEntity<AuthResponse> response = authController.register(registerRequest);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }
}
