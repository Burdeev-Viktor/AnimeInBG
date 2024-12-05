package com.example.AnimeInBG.model.jasonParserModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Title {
    @JsonProperty("romaji")
    private String romaji;

    @JsonProperty("english")
    private String english;

}
