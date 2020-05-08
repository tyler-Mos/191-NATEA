package com.example.natea.nateawebappproject.service;
import java.util.Optional;
import com.example.natea.nateawebappproject.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NATEAUserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);

    User findByEmail(String email);
}