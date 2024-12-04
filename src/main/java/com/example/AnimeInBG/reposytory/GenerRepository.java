package com.example.AnimeInBG.reposytory;

import com.example.AnimeInBG.model.anime.Gener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerRepository extends JpaRepository<Gener,Long> {
}
