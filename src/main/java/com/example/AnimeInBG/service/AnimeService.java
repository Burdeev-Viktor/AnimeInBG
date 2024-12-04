package com.example.AnimeInBG.service;

import com.example.AnimeInBG.model.anime.Anime;
import com.example.AnimeInBG.reposytory.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> getAll(){
        return animeRepository.findAll();
    }
    public void saveAnime(Anime anime){
        animeRepository.save(anime);
    }
}
