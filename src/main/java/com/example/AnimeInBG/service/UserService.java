package com.example.AnimeInBG.service;


import com.example.AnimeInBG.model.user.User;
import com.example.AnimeInBG.reposytory.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user){
        user.setRoles("ROLE_ADMIN");
        userRepository.save(user);
    }
}
