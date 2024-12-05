package com.example.AnimeInBG.service.aniList;

import com.example.AnimeInBG.model.anime.Anime;
import com.example.AnimeInBG.model.anime.FormatAnime;
import com.example.AnimeInBG.model.anime.Gener;
import com.example.AnimeInBG.model.jasonParserModel.AniListResponse;
import com.example.AnimeInBG.model.jasonParserModel.Media;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ParserService {

    public static Anime jsonParseToAnime(String json){
        return mediaToAnime(Objects.requireNonNull(jsonToMedia(json)));
    }


    private static Media jsonToMedia(String json){
        try {
            // Создаем ObjectMapper для десериализации
            ObjectMapper objectMapper = new ObjectMapper();
            // Преобразуем JSON в объект AniListResponse
            AniListResponse response = objectMapper.readValue(json, AniListResponse.class);
            return response.getData().getMedia();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Anime mediaToAnime(Media media){
        System.out.println(media.getId());
        Anime anime = new Anime();
        anime.setTitle(media.getTitle().getEnglish());
        anime.setEnglishTitle(media.getTitle().getEnglish());
        anime.setOriginalTitle(media.getTitle().getRomaji());
        anime.setFormat(new FormatAnime(media.getFormat()));
        anime.setDescription(media.getDescription());
        anime.setEpisodeCount(media.getEpisodes());
        anime.setRating(((double) media.getAverageScore() /100));
        anime.setStudio(media.getStudios().getEdges().get(0).getNode().getName());
        anime.setGeners(media.getGenres().stream().map(Gener::new).collect(Collectors.toList()));
        anime.setImageUrl(media.getCoverImage().getLarge());
        return anime;
    }
}
