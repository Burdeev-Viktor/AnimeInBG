package com.example.AnimeInBG.reposytory;

import com.example.AnimeInBG.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepoUser extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
