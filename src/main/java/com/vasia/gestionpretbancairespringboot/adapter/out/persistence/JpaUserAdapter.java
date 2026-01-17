package com.vasia.gestionpretbancairespringboot.adapter.out.persistence;

import com.vasia.gestionpretbancairespringboot.domain.port.out.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaUserAdapter implements UserRepositoryPort {

    @Override
    public User save(User user) {
        // TODO: Implémenter la sauvegarde de l'utilisateur via JPA
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        // TODO: Implémenter la recherche de l'utilisateur via JPA
        return Optional.empty();
    }
}
