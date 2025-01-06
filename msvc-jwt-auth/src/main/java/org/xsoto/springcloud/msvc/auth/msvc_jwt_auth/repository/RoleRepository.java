package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.repository;


import org.springframework.data.repository.CrudRepository;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.Role;

public interface RoleRepository extends CrudRepository<Role,Long> {

}
