package com.example.AnimeInBG.service;

import com.example.AnimeInBG.model.anime.FormatAnime;
import com.example.AnimeInBG.reposytory.FormatAnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormatAnimeService {
    @Autowired
    private FormatAnimeRepository formatAnimeRepository;

    public List<FormatAnime> getAllFormats() {
        return formatAnimeRepository.findAll();
    }
}
