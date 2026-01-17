package com.vasia.gestionpretbancairespringboot.domain.port.out;

import org.apache.catalina.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(String id);
}
