package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.Permission;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service.PermissionService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping
    public List<Permission> list() {
        return permissionService.list();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Permission permission) {
        return ResponseEntity.status(HttpStatus.CREATED).body(permissionService.create(permission));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional optional = permissionService.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@RequestBody Permission permission, @PathVariable Long id) {
        if (validate(id)) {
            permission.setId(id);
            return ResponseEntity.status(HttpStatus.OK).body(permissionService.create(permission));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (validate(id)) {
            permissionService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Boolean validate(Long id) {
        Optional optional = permissionService.findById(id);
        return optional.isPresent();
    }
}
