package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.Role;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.repository.RoleRepository;


import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements  RoleService{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> list() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    @Transactional
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
