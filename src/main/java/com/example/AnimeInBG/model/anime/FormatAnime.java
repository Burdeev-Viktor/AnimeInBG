package com.example.AnimeInBG.model.anime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class FormatAnime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String format;
    @OneToMany(mappedBy = "format")
    private List<Anime> animes;

    public FormatAnime(String format) {
        this.format=format;
    }
}
