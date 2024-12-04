package com.example.AnimeInBG.model.review;

import com.example.AnimeInBG.model.user.User;
import com.example.AnimeInBG.model.anime.Anime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToOne
    @JoinColumn(name = "anime_id", referencedColumnName = "id")
    private Anime anime;
    private int rating;
}
