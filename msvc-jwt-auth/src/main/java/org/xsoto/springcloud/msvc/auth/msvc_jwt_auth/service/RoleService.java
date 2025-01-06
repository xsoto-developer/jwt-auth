package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service;

import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> list ();
    Optional<Role> findById(Long id);
    Role create (Role role);
    void delete (Long id);
}
