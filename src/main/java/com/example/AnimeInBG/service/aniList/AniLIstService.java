package com.example.AnimeInBG.service.aniList;

import com.example.AnimeInBG.model.anime.Anime;
import com.example.AnimeInBG.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AniLIstService {

    @Autowired
    private AniListClient aniListClient;


    @Autowired
    private AnimeService animeService;


    public void fetchAndSaveAnime(Long animeId) throws Exception {
        saveAnime(fetchAnime(animeId));
    }

    public Anime fetchAnime(Long animeId) throws Exception {
        return ParserService.jsonParseToAnime(aniListClient.getAnimeInfoById(animeId));
    }

    public void saveAnime(Anime anime) {
        animeService.saveAnime(anime);
    }


}


