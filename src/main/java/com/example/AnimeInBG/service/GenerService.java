package com.example.AnimeInBG.service;

import com.example.AnimeInBG.model.anime.Gener;
import com.example.AnimeInBG.reposytory.GenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerService {
    @Autowired
    private GenerRepository generRepository;

    public List<Gener> getAllGenres() {
        return generRepository.findAll();
    }
}
