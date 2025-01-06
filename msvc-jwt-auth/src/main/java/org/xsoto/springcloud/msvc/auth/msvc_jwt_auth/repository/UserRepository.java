package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
