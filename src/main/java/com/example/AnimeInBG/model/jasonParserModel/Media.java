package com.example.AnimeInBG.model.jasonParserModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
        public class Media {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private Title title;

    @JsonProperty("coverImage")
    private CoverImage coverImage;

    @JsonProperty("description")
    private String description;

    @JsonProperty("genres")
    private List<String> genres;

    @JsonProperty("episodes")
    private int episodes;

    @JsonProperty("averageScore")
    private int averageScore;

    @JsonProperty("format")
    private String format;

    @JsonProperty("status")
    private String status;

    @JsonProperty("studios")
    private Studios studios;


}
