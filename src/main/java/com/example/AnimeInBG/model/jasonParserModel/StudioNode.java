package com.example.AnimeInBG.model.jasonParserModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudioNode {
    @JsonProperty("name")
    private String name;

}
