package com.example.AnimeInBG.reposytory;

import com.example.AnimeInBG.model.anime.FormatAnime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatAnimeRepository extends JpaRepository<FormatAnime,Long> {
}
