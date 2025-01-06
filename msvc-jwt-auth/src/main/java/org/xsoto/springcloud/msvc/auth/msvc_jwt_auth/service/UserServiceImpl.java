package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity.User;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        user.setCreateAt(new Date());
        user.setUpdateAt(new Date());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
