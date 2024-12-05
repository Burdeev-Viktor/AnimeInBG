package com.example.AnimeInBG.model.jasonParserModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


// Главный класс ответа
@Getter
@Setter
public class AniListResponse {
    @JsonProperty("data")
    private Data data;
}

