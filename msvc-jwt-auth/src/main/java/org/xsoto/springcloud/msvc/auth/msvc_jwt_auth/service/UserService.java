package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service;

import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService{

    List<User> findAll ();
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(long id);

}
