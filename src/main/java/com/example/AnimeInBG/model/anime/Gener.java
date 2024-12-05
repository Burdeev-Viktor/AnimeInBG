package com.example.AnimeInBG.model.anime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Gener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gener;
    @ManyToMany(mappedBy = "geners")
    private List<Anime> animes;
    public Gener(String gener){
        this.gener = gener;
    }
}
