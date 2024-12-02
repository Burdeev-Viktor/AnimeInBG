package com.example.AnimeInBG.service;


import com.example.AnimeInBG.model.User;
import com.example.AnimeInBG.reposytory.RepoUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final RepoUser repoUser;

    public UserService(RepoUser repoUser) {
        this.repoUser = repoUser;
    }

    public void save(User user){
        user.setRoles("ROLE_ADMIN");
        repoUser.save(user);
    }
}
