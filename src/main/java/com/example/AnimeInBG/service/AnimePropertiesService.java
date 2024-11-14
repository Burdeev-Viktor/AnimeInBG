package com.example.AnimeInBG.service;

import com.example.AnimeInBG.model.AnimeProperties;
import com.example.AnimeInBG.reposytory.RepoAnimeProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimePropertiesService {
    private final RepoAnimeProperties repoAnimeProperties;

    public AnimePropertiesService(RepoAnimeProperties repoAnimeProperties) {
        this.repoAnimeProperties = repoAnimeProperties;
    }

    public List<AnimeProperties> getAll(){
        return repoAnimeProperties.findAll();
    }
    public void setAnimeProperties(AnimeProperties animeProperties){
        repoAnimeProperties.save(animeProperties);
    }
}
