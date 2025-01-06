package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.Role;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service.RoleService;

import java.util.Optional;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<?> list (){
        return ResponseEntity.ok(roleService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Role> optionalRole = roleService.findById(id);
        if(optionalRole.isPresent()){
            return  ResponseEntity.ok(optionalRole.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create (@RequestBody Role role){
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.create(role));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Role role, @PathVariable Long id){
        Optional<Role> optionalRole = roleService.findById(id);
        if(optionalRole.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(roleService.create(role));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Optional<Role> optionalRole = roleService.findById(id);
        if(optionalRole.isPresent()){
            roleService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
