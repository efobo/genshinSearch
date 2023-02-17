package com.example.genshinSearch.repo;

import com.example.genshinSearch.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeroRepo extends JpaRepository<Hero, Long> {

    void deleteHeroById(Long id);

    Optional<Hero> findHeroById(Long id);
}
