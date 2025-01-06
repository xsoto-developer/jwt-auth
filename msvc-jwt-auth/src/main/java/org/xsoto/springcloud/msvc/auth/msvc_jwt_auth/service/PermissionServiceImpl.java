package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.Permission;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.repository.PermissionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Permission> list() {
        return (List<Permission>) permissionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Permission> findById(Long id) {
        return permissionRepository.findById(id);
    }

    @Override
    @Transactional
    public Permission create(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        permissionRepository.deleteById(id);
    }
}
