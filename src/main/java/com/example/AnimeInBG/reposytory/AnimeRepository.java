package com.example.AnimeInBG.reposytory;

import com.example.AnimeInBG.model.anime.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime,Long> {
}
