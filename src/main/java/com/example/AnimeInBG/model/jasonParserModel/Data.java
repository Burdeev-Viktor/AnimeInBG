package com.example.AnimeInBG.model.jasonParserModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
    @JsonProperty("Media")
    private Media media;
}
