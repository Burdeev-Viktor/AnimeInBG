package com.example.AnimeInBG.reposytory;

import com.example.AnimeInBG.model.AnimeProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoAnimeProperties extends JpaRepository<AnimeProperties,Long> {
}
