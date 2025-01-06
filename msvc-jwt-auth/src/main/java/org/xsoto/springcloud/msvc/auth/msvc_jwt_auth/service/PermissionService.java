package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service;

import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionService {

    List<Permission> list ();
    Optional findById (Long id);
    Permission create(Permission permission);
    void delete (Long id);

}
