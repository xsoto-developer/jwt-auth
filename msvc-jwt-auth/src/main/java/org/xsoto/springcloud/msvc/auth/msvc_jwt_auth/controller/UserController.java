package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.User;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User>listar(){
        return  userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody User user, @PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);
        if(userOptional.isPresent()){
            user.setId(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<User> optional = userService.findById(id);
        if (optional.isPresent()){
            userService.deleteById(id);
            return ResponseEntity.noContent().build(); // noContenct 404
        }
        return ResponseEntity.notFound().build();
    }

}
