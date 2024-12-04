package com.example.AnimeInBG.model.anime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String originalTitle;
    private String englishTitle;
    private String description;
    private int episodeCount;
    @ManyToMany
    @JoinTable(
            name = "anime_gener",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "gener_id")
    )
    private List<Gener> geners;
    private String imageUrl;
    private double rating;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    @ManyToOne
    @JoinColumn(name = "format_id")
    private FormatAnime format;
    private String studio;
}
