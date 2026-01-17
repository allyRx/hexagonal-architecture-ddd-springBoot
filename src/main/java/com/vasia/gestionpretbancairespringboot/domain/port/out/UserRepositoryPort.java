package com.vasia.gestionpretbancairespringboot.domain.port.out;

import org.apache.catalina.User;

import java.util.Optional;
import java.util.UUID;

public interface UseRepositoryPort {
    User save(User user);
    Optional<User> findById(String id);
}
